package dji.sdk.mission.waypoint

import io.dronefleet.mavlink.common.*
import dji.common.error.DJIError
import dji.common.error.DJIMissionError
import dji.common.mission.waypoint.*
import dji.common.util.CallbackUtils
import dji.common.util.CommonCallbacks.CompletionCallback
import dji.midware.MavlinkConnector
import dji.thirdparty.rx.Subscription
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap


class WaypointMissionOperator {

    companion object {
        private const val DEFAULT_TIMEOUT_FOR_NAVIGATION = 1000L
        @Volatile
        var mavlinkConnector: MavlinkConnector? = null
            set (value) {
                if (mavlinkConnector == null) {
                    field = value
                }
            }
    }

    // Объект абстракции, предоставляющий функциональность работы с миссией
//    private val missionAbstraction: c = c()

    private var operatingMissionBuilder: WaypointMission.Builder? = null
    private val listenerSubscriptionMap: MutableMap<WaypointMissionOperatorListener, Subscription?> =
        ConcurrentHashMap()

    fun destroy() {

        operatingMissionBuilder = null
        listenerSubscriptionMap.values.forEach { subscription ->
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe()
            }
        }
        listenerSubscriptionMap.clear()
    }

    fun addListener(listener: WaypointMissionOperatorListener) {
//        val subscription = MissionEventBus.getInstance()
//            .register(b::class.java)
//            .onBackpressureDrop()
//            .observeOn(Schedulers.computation())
//            .subscribe { event -> notifyListener(listener, event) }
//        listenerSubscriptionMap[listener] = subscription
    }

    private fun notifyListener(listener: WaypointMissionOperatorListener, event: Any) {
//        val currentState = StateHelper.convertToWaypointPublicState(event.a())
//        val previousState = StateHelper.convertToWaypointPublicState(event.b())
//        val extraData = event.d()
//        val error = event.e()
//        val missionEvent = event.c()
//        if (missionEvent == null || (!missionEvent.equals(MissionEvent.EXECUTION_FINISHED)
//                    && !missionEvent.equals(MissionEvent.EXECUTION_STOPPED))
//        ) {
//            if (missionEvent != null && missionEvent.equals(MissionEvent.EXECUTION_STARTED)) {
//
//            } else if (extraData == null) {
//                val uploadBuilder = WaypointMissionUploadEvent.Builder()
//                if (previousState === WaypointMissionState.UPLOADING &&
//                    currentState === WaypointMissionState.READY_TO_EXECUTE
//                ) {
//                    uploadBuilder.currentState(currentState)
//                        .previousState(previousState)
//                        .error(error)
//
//                }
//            } else if (extraData is WaypointUploadProgress) {
//                val uploadBuilder = WaypointMissionUploadEvent.Builder()
//                uploadBuilder.previousState(previousState)
//                if (currentState !== WaypointMissionState.UNKNOWN) {
//                    uploadBuilder.currentState(currentState)
//                        .progress(extraData)
//                        .error(error)
//
//                }
//            } else if (extraData is WaypointDownloadProgress) {
//                val downloadBuilder = WaypointMissionDownloadEvent.Builder()
//                downloadBuilder.progress(extraData)
//                    .error(error)
//
//            } else if (extraData is WaypointExecutionProgress ||
//                (missionEvent != null && missionEvent.equals(MissionEvent.EXECUTION_PROGRESS_UPDATE))
//            ) {
//                val executionBuilder = WaypointMissionExecutionEvent.Builder()
//                executionBuilder.previousState(previousState)
//                if (currentState !== WaypointMissionState.UNKNOWN) {
//                    executionBuilder.currentState(currentState)
//                    if (extraData is WaypointExecutionProgress) {
//                        executionBuilder.progress(extraData)
//                        if (extraData.isWaypointReached) {
//
//                        }
//                    }
//                    executionBuilder.error(error)
//
//                }
//            }
//        } else {
//
//        }
    }

    fun removeListener(listener: WaypointMissionOperatorListener) {
        val subscription = listenerSubscriptionMap.remove(listener)
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe()
        }
    }

    fun loadMission(mission: WaypointMission): DJIError? {
        operatingMissionBuilder = WaypointMission.Builder(mission)
        val error = operatingMissionBuilder?.checkParameters()
        if (error != null) {
            println("here error: $error")
            operatingMissionBuilder = null
        } else {
            val yawHeadingMode = mission.getHeadingMode() == WaypointMissionHeadingMode.USING_WAYPOINT_HEADING
            val isRTL = mission.getFinishedAction() == WaypointMissionFinishedAction.GO_HOME
            mavlinkConnector!!.missionManager.setSpeedCommand(mission.getAutoFlightSpeed())
            mavlinkConnector!!.missionManager.formMissionItems(mission.getWaypointList(), yawHeadingMode, mission.getFinishedAction())
        }
        return error
    }

    fun uploadMission(callback: ((DJIError?) -> Unit)?) {
        if (operatingMissionBuilder == null && false) {
            CallbackUtils.onFailure(callback, DJIMissionError.NULL_MISSION)
        } else {
//            val missionItems = listOf(
//                // seq=0 (current=1)
//                MissionItemInt.builder().seq(0).frame(MavFrame.MAV_FRAME_GLOBAL_RELATIVE_ALT)
//                    .command(MavCmd.MAV_CMD_NAV_WAYPOINT)
//                    .current(1).autocontinue(1)
//                    .param1(0f).param2(1f).param3(0f).param4(0f)
//                    .x((-35.363262f * 1e7).toInt()).y((149.1652372f * 1e7).toInt()).z(5f)
//                    .missionType(MavMissionType.MAV_MISSION_TYPE_MISSION).build(),
//                // seq=1
//                MissionItemInt.builder().seq(1).frame(MavFrame.MAV_FRAME_GLOBAL_RELATIVE_ALT)
//                    .command(MavCmd.MAV_CMD_NAV_WAYPOINT)
//                    .current(0).autocontinue(1)
//                    .param1(0f).param2(1f).param3(0f).param4(0f)
//                    .x((-35.365262f * 1e7).toInt()).y((149.1652372f * 1e7).toInt()).z(7f)
//                    .missionType(MavMissionType.MAV_MISSION_TYPE_MISSION).build(),
//                // seq=2
//                MissionItemInt.builder().seq(2).frame(MavFrame.MAV_FRAME_GLOBAL_RELATIVE_ALT)
//                    .command(MavCmd.MAV_CMD_NAV_WAYPOINT)
//                    .current(0).autocontinue(1)
//                    .param1(0f).param2(1f).param3(0f).param4(0f)
//                    .x((-35.378562f * 1e7).toInt()).y((149.1702372f * 1e7).toInt()).z(7f)
//                    .missionType(MavMissionType.MAV_MISSION_TYPE_MISSION).build()
//            )

            mavlinkConnector!!.missionManager!!.uploadMission { success ->
                if (success) {
                    callback?.invoke(null)
                }
            }
        }
//        if (operatingMissionBuilder == null) {
//            CallbackUtils.onFailure(callback, DJIMissionError.NULL_MISSION)
//        } else if (!operatingMissionBuilder!!.isMissionComplete()) {
//            CallbackUtils.onFailure(callback, DJIMissionError.INCOMPLETE_MISSION)
//        } else {
//            if (missionAbstraction.c() == WaypointMissionState.NOT_READY) {
//
//            } else if (missionAbstraction.c() != WaypointMissionState.READY_TO_UPLOAD &&
//                missionAbstraction.c() != WaypointMissionState.READY_TO_EXECUTE &&
//                missionAbstraction.c() != WaypointMissionState.READY_TO_RETRY_UPLOAD
//            ) {
//                CallbackUtils.onFailure(callback, CommonError.COMMON_SYSTEM_BUSY)
//
//            } else {
//                missionAbstraction.a(operatingMissionBuilder, callback)
//            }
//        }
    }

    fun downloadMission(callback: CompletionCallback<*>?) {
        if (operatingMissionBuilder == null) {
            operatingMissionBuilder = WaypointMission.Builder()
        }


    }

    fun retryUploadMission(callback: CompletionCallback<*>?) {
        if (operatingMissionBuilder == null) {
            CallbackUtils.onFailure(callback, DJIError.COMMON_EXECUTION_FAILED)
        } else {

        }
    }

    fun startMission(callback: ((DJIError?) -> Unit)?) {
        if (operatingMissionBuilder != null && operatingMissionBuilder!!.isMissionComplete()) {
            CoroutineScope(Dispatchers.IO).launch {
                mavlinkConnector!!.missionManager.setAutoMode()
                delay(1000)
                mavlinkConnector!!.missionManager.startMission()
            }
        } else {
            CallbackUtils.onFailure(callback, DJIMissionError.MISSION_INFO_INVALID)
        }

    }

    fun pauseMission(callback: CompletionCallback<*>?) {


    }

    fun resumeMission(callback: CompletionCallback<*>?) {


    }

    fun stopMission(callback: CompletionCallback<*>?) {
//        if (missionAbstraction.c() != WaypointMissionState.EXECUTING &&
//            missionAbstraction.c() != WaypointMissionState.EXECUTION_PAUSED
//        ) {
//            CallbackUtils.onSuccess(callback)
//        } else {
//            missionAbstraction.f(callback)
//        }

    }

    fun getCurrentState() {
//        return StateHelper.convertToWaypointPublicState(missionAbstraction.c())
    }

    fun setAutoFlightSpeed(speed: Float, callback: CompletionCallback<*>?) {

    }

    fun getLoadedMission(): WaypointMission {
        if (operatingMissionBuilder == null) {
//            operatingMissionBuilder = missionAbstraction.j().l
        }
        return operatingMissionBuilder!!.build()
    }
}