package dji.sdk.mission.waypoint

import dji.common.error.DJIError
import dji.common.mission.waypoint.*
import dji.common.util.CommonCallbacks.CompletionCallback
import dji.sdk.mission.error.MissionControlError
import dji.sdk.mission.timeline.Mission
import dji.sdk.mission.timeline.TimelineElement
import dji.sdk.mission.timeline.TimelineEvent
import java.util.concurrent.CopyOnWriteArrayList


class MissionControl private constructor() {
    private var _waypointMissionOperator: WaypointMissionOperator? = null

    var waypointMissionOperator: WaypointMissionOperator
        get() {
            if (_waypointMissionOperator == null) {
                _waypointMissionOperator = WaypointMissionOperator()
            }
            return _waypointMissionOperator!!
        }
        private set(value) {
            _waypointMissionOperator = value
        }

    private var waypointListener: WaypointMissionOperatorListener? = null

    var isTimelineRunning: Boolean = false
        private set
    private var currentElementIndex: Int = 0
    private var isTimelinePaused: Boolean = false
    private var currentRunningElement: TimelineElement? = null

    private val timelineElements: CopyOnWriteArrayList<TimelineElement?> = CopyOnWriteArrayList()
    private val eventListeners: CopyOnWriteArrayList<Listener> = CopyOnWriteArrayList()

    companion object {
        val instance: MissionControl by lazy { MissionControl() }
//        fun getInstance(): MissionControl = instance
    }

    fun destroy() {
        _waypointMissionOperator?.destroy()
        _waypointMissionOperator = null
    }

//    fun getWaypointMissionOperator(): WaypointMissionOperator {
//        if (_waypointMissionOperator == null) {
//            waypointMissionOperator = WaypointMissionOperator()
//        }
//        return _waypointMissionOperator!!
//    }

//    fun isTimelineRunning(): Boolean = isTimelineRunning

    fun setTimelineRunning(running: Boolean) {
        isTimelineRunning = running
    }

    fun getCurrentElementIndex(): Int = currentElementIndex

    fun setCurrentElementIndex(index: Int) {
        if (!isTimelineRunning) {
            currentElementIndex = index
        }
    }

    fun isTimelinePaused(): Boolean = isTimelinePaused

    fun setTimelinePaused(paused: Boolean) {
        isTimelinePaused = paused
    }

    fun getCurrentRunningElement(): TimelineElement? = currentRunningElement

    fun setCurrentRunningElement(element: TimelineElement?) {
        currentRunningElement = element
    }

    fun startTimeline() {
        if (currentElementIndex < timelineElements.size) {
            if (!isTimelineRunning && !isTimelinePaused) {
                isTimelineRunning = true
                notifyListeners(null, TimelineEvent.STARTED, null)
                timelineElements[currentElementIndex]?.let { startElement(it) }
            }
        }
    }

    fun pauseTimeline() {
        if (isTimelineRunning && !isTimelinePaused && currentRunningElement != null) {
            pauseElement(currentRunningElement!!)
        }
    }

    fun resumeTimeline() {
        if (isTimelineRunning && isTimelinePaused && currentRunningElement != null) {
            resumeElement(currentRunningElement!!)
        }
    }

    fun stopTimeline() {
        if (isTimelineRunning && currentRunningElement != null) {
            isTimelineRunning = false
            currentElementIndex = 0
            stopElement(currentRunningElement!!)
        }
    }

    fun scheduleElement(element: TimelineElement): DJIError? {
        if (isTimelineRunning) {
            return MissionControlError.CANNOT_SCHEDULE_WHILE_RUNNING
        }
        val validityError = element.checkValidity()
        return if (validityError != null) {
            validityError
        } else {
            timelineElements.add(element)
            null
        }
    }

    fun scheduleElements(elements: List<TimelineElement>): DJIError? {
        elements.forEach { element ->
            scheduleElement(element)?.let { return it }
        }
        return null
    }

    fun scheduleElementAtIndex(element: TimelineElement, index: Int): DJIError? {
        if (isTimelineRunning) {
            return MissionControlError.CANNOT_SCHEDULE_WHILE_RUNNING
        }
        val validityError = element.checkValidity()
        return if (validityError != null) {
            validityError
        } else {
            timelineElements.add(index, element)
            null
        }
    }

    fun unscheduleElement(element: TimelineElement?) {
        val index = timelineElements.indexOf(element)
        unscheduleElementAtIndex(index)
    }

    fun unscheduleElementAtIndex(index: Int) {
        if (!isTimelineRunning) {
            timelineElements.removeAt(index)
            if (index < currentElementIndex) {
                currentElementIndex--
            }
        }
    }

    fun scheduledElementAtIndex(index: Int): TimelineElement? =
        timelineElements.getOrNull(index)

    fun scheduledCount(): Int = timelineElements.size

    fun unscheduleEverything() {
        timelineElements.clear()
        resetAllStates()
    }

    fun onStart(element: TimelineElement) {
        if (element == currentRunningElement) {
            notifyListeners(element, TimelineEvent.ELEMENT_STARTED, null)
        }
    }

    fun onStartWithError(element: TimelineElement, error: DJIError?) {
        if (element == currentRunningElement) {
            isTimelineRunning = false
            notifyListeners(element, TimelineEvent.ELEMENT_START_ERROR, error)
        }
    }

    fun onProgressWithError(element: TimelineElement, error: DJIError?) {
        if (element == currentRunningElement) {
            notifyListeners(element, TimelineEvent.ELEMENT_PROGRESSED, error)
        }
    }

    fun onPause(element: TimelineElement) {
        if (element == currentRunningElement) {
            isTimelinePaused = true
            notifyListeners(element, TimelineEvent.PAUSED, null)
        }
    }

    fun onPauseWithError(element: TimelineElement, error: DJIError?) {
        if (element == currentRunningElement) {
            notifyListeners(element, TimelineEvent.PAUSE_ERROR, error)
        }
    }

    fun onResume(element: TimelineElement) {
        if (element == currentRunningElement) {
            isTimelinePaused = false
            notifyListeners(element, TimelineEvent.RESUMED, null)
        }
    }

    fun onResumeWithError(element: TimelineElement, error: DJIError?) {
        if (element == currentRunningElement) {
            notifyListeners(element, TimelineEvent.RESUME_ERROR, error)
        }
    }

    fun onFinishWithError(element: TimelineElement, error: DJIError?) {
        if (element == currentRunningElement) {
            element.triggers()?.forEach { it.stop() }
            element.didRun()
            notifyListeners(element, TimelineEvent.ELEMENT_FINISHED, error)
            if (error != null) {
                isTimelineRunning = false
            }
            currentRunningElement = null
            if (isTimelineRunning) {
                startNextElement()
            } else {
                resetAllStates()
                notifyListeners(null, TimelineEvent.FINISHED, error)
            }
        }
    }

    fun onStopWithError(element: TimelineElement, error: DJIError?) {
        if (element == currentRunningElement) {
            notifyListeners(element, TimelineEvent.STOP_ERROR, error)
        }
    }

    fun addListener(listener: Listener) {
        eventListeners.add(listener)
    }

    fun removeListener(listener: Listener) {
        eventListeners.remove(listener)
    }

    fun removeAllListeners() {
        eventListeners.clear()
    }

    private fun notifyListeners(
        element: TimelineElement?,
        event: TimelineEvent,
        error: DJIError?
    ) {
        if (eventListeners.isNotEmpty()) {
            eventListeners.forEach { it.onEvent(element, event, error) }
        }
    }

    fun startNextElement() {
        currentElementIndex++
        if (currentElementIndex >= scheduledCount()) {
            resetAllStates()
            notifyListeners(null, TimelineEvent.FINISHED, null)
        } else {
            timelineElements[currentElementIndex]?.let { startElement(it) }
        }
    }

    fun startElement(element: TimelineElement) {
//        Observable.just(true)
//            .subscribeOn(Schedulers.newThread())
//            .subscribe { _ ->
//                currentRunningElement = element
//                element.willRun()
//                element.triggers()?.forEach { it.start() }
//                if (element is Mission) {
//                    startMission(element)
//                } else {
//                    element.run()
//                }
//            }
    }

    fun pauseElement(element: TimelineElement) {
        if (!element.isPausable()) {
            notifyListeners(
                element,
                TimelineEvent.PAUSE_ERROR,
                MissionControlError.NOT_PAUSABLE_OR_RESUMABLE
            )
        } else {
            if (element is Mission) {
                pauseMission(element)
            } else {
                element.pause()
                isTimelinePaused = true
                notifyListeners(element, TimelineEvent.PAUSED, null)
            }
        }
    }

    fun resumeElement(element: TimelineElement) {
        if (element is Mission) {
            resumeMission(element)
        } else if (element.isPausable()) {
            element.resume()
            isTimelinePaused = false
            notifyListeners(element, TimelineEvent.RESUMED, null)
        } else {
            notifyListeners(
                element,
                TimelineEvent.RESUME_ERROR,
                MissionControlError.NOT_PAUSABLE_OR_RESUMABLE
            )
        }
    }

    fun stopElement(element: TimelineElement) {
        if (element is Mission) {
            stopMission(element)
        } else {
            element.stop()
        }
    }

    fun startMission(mission: Mission) {
        onStart(mission)
        if (mission.getMissionObject() is WaypointMission) {
            startWaypointMission(mission)
        }
    }

    fun startWaypointMission(mission: Mission) {
        val waypointMission = mission.getMissionObject() as WaypointMission
        waypointListener = object : WaypointMissionOperatorListener {
            override fun onDownloadUpdate(downloadEvent: WaypointMissionDownloadEvent) {
                // Реализация по необходимости
            }

            override fun onUploadUpdate(uploadEvent: WaypointMissionUploadEvent) {
                if (uploadEvent.error == null) {
                    if (uploadEvent.currentState == WaypointMissionState.READY_TO_EXECUTE &&
                        uploadEvent.previousState == WaypointMissionState.UPLOADING
                    ) {
                        waypointMissionOperator.startMission {
                            if (it != null) {
                                onStartWithError(mission, it)
                            }
                        }
                    }
                } else if (uploadEvent.currentState == WaypointMissionState.READY_TO_UPLOAD) {
                    waypointMissionOperator.uploadMission {
                        if (it != null) {
                            onFinishWithError(mission, it)
                        }
                    }
                } else if (uploadEvent.currentState == WaypointMissionState.READY_TO_RETRY_UPLOAD) {
                    waypointMissionOperator.retryUploadMission(object : CompletionCallback<DJIError?> {
                        override fun onResult(var1: DJIError?) {
                            if (var1 != null) {
                                onFinishWithError(mission, var1)
                            }
                        }
                    })
                }
            }

            override fun onExecutionUpdate(executionEvent: WaypointMissionExecutionEvent) {
                onProgressWithError(mission, executionEvent.error)
            }

            override fun onExecutionStart() {
                // Реализация по необходимости
            }

            override fun onExecutionFinish(error: DJIError?) {
                onFinishWithError(mission, error)
                waypointMissionOperator.removeListener(this)
            }
        }
        waypointMissionOperator.addListener(waypointListener!!)
        val loadError = waypointMissionOperator?.loadMission(waypointMission)
        if (loadError != null) {
            onStartWithError(mission, loadError)
        } else {
            waypointMissionOperator.uploadMission {
                if (it != null) {
                    onStartWithError(mission, it)
                }
            }
        }
    }

    fun pauseMission(mission: Mission) {
        if (mission.getMissionObject() is WaypointMission) {
            pauseWaypointMission(mission)
        }
    }

    fun pauseWaypointMission(mission: Mission) {
        waypointMissionOperator.pauseMission(object : CompletionCallback<DJIError?> {
            override fun onResult(error: DJIError?) {
                if (error != null) {
                    onPauseWithError(mission, error)
                } else {
                    isTimelinePaused = true
                    onPause(mission)
                }
            }
        })
    }

    fun resumeMission(mission: Mission) {
        if (mission.getMissionObject() is WaypointMission) {
            resumeWaypointMission(mission)
        }
    }

    fun resumeWaypointMission(mission: Mission) {
        waypointMissionOperator.resumeMission(object : CompletionCallback<DJIError?> {
            override fun onResult(error: DJIError?) {
                if (error != null) {
                    onResumeWithError(mission, error)
                } else {
                    isTimelinePaused = false
                    onResume(mission)
                }
            }
        })
    }

    fun stopMission(mission: Mission) {
        if (mission.getMissionObject() is WaypointMission) {
            stopWaypointMission(mission)
        }
    }

    fun stopWaypointMission(mission: Mission) {
        waypointMissionOperator.stopMission(object : CompletionCallback<DJIError?> {
            override fun onResult(error: DJIError?) {
                if (error != null) {
                    notifyListeners(mission, TimelineEvent.STOP_ERROR, error)
                } else {
                    if (waypointListener != null) {
                        waypointMissionOperator.removeListener(waypointListener!!)
                    }
                    onFinishWithError(mission, null)
                }
            }
        })
    }

    private fun isElementValid(element: TimelineElement): DJIError? =
        element.checkValidity()

    private fun isElementAtIndexValid(index: Int): DJIError? {
        val element = scheduledElementAtIndex(index)
        return if (element != null) isElementValid(element) else null
    }

    private fun resetAllStates() {
        currentElementIndex = 0
        isTimelineRunning = false
        isTimelinePaused = false
        currentRunningElement = null
    }

    interface Listener {
        fun onEvent(element: TimelineElement?, event: TimelineEvent?, error: DJIError?)
    }
}