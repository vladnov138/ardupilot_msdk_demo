package dji.common.mission.waypoint

import dji.common.error.DJIError
import dji.common.error.DJIMissionError
import dji.common.model.LocationCoordinate2D
import kotlin.math.abs


class WaypointMission(builder: Builder) {

    companion object {
        const val MAX_FLIGHT_SPEED: Float = 15.0f
        const val MIN_FLIGHT_SPEED: Float = 2.0f
        const val MAX_AUTO_FLIGHT_SPEED: Float = 15.0f
        val MIN_AUTO_FLIGHT_SPEED: Float = -15.0f
        const val MAX_WAYPOINT_COUNT: Int = 99
        const val MIN_WAYPOINT_COUNT: Int = 2
        const val MIN_REPEAT_TIME: Int = 0
    }

    private var waypointCount = builder.waypointCount
    private var maxFlightSpeed = builder.maxFlightSpeed
    private var autoFlightSpeed = builder.autoFlightSpeed
    private var finishedAction = builder.finishedAction
    private var headingMode = builder.headingMode
    private var flightPathMode = builder.flightPathMode
    private var gotoFirstWaypointMode = builder.gotoFirstWaypointMode
    private var isExitMissionOnRCSignalLostEnabled = builder.isExitMissionOnRCSignalLost
    private var pointOfInterest = builder.pointOfInterest
    private var isGimbalPitchRotationEnabled = builder.isGimbalPitchRotationEnabled
    private var repeatTimes = builder.repeatTimes

    private var waypointList = ArrayList<Waypoint>(builder.waypointList)

    fun getWaypointCount(): Int {
        return this.waypointCount
    }

    fun getMaxFlightSpeed(): Float {
        return this.maxFlightSpeed
    }

    fun getAutoFlightSpeed(): Float {
        return this.autoFlightSpeed
    }

    fun getFinishedAction(): WaypointMissionFinishedAction {
        return this.finishedAction
    }

    fun getHeadingMode(): WaypointMissionHeadingMode? {
        return this.headingMode
    }

    fun getFlightPathMode(): WaypointMissionFlightPathMode? {
        return this.flightPathMode
    }

    fun getGotoFirstWaypointMode(): WaypointMissionGotoWaypointMode? {
        return this.gotoFirstWaypointMode
    }

    fun isExitMissionOnRCSignalLostEnabled(): Boolean {
        return this.isExitMissionOnRCSignalLostEnabled
    }

    fun getPointOfInterest(): LocationCoordinate2D? {
        return this.pointOfInterest
    }

    fun isGimbalPitchRotationEnabled(): Boolean {
        return this.isGimbalPitchRotationEnabled
    }

    fun getRepeatTimes(): Int {
        return this.repeatTimes
    }

    fun getWaypointList(): List<Waypoint> {
        return waypointList
    }

    fun checkParameters(): DJIError? {
        if (this.maxFlightSpeed >= 2.0f && this.maxFlightSpeed <= 15.0f) {
            if (this.autoFlightSpeed >= -15.0f && this.autoFlightSpeed <= 15.0f && abs(
                    autoFlightSpeed.toDouble()
                ) <= 15.0f
            ) {
                if (this.repeatTimes < 0) {
                    return DJIMissionError.REPEAT_TIME_NOT_VALID
                } else if (this.waypointCount >= 2 && this.waypointCount <= 99 && abs(
                        autoFlightSpeed.toDouble()
                    ) <= 15.0f
                ) {
                    if (this.waypointList != null && waypointList.size <= 99 && waypointList.size >= 2 && waypointList.size == this.waypointCount) {
                        for (var2 in this.waypointList) {
                            val var3: DJIError? = var2.checkParameters()
                            if (var3 != null) {
                                return var3
                            }
                        }

                        return null
                    } else {
                        return DJIMissionError.WAYPOINT_LIST_SIZE_NOT_VALID
                    }
                } else {
                    return DJIMissionError.WAYPOINT_COUNT_NOT_VALID
                }
            } else {
                return DJIMissionError.MAX_FLIGHT_SPEED_NOT_VALID
            }
        } else {
            return DJIMissionError.MAX_FLIGHT_SPEED_NOT_VALID
        }
    }

    class Builder {
        var waypointCount: Int
            private set

        var maxFlightSpeed: Float = 0f
            private set

        var autoFlightSpeed: Float = 0f
            private set
        var finishedAction: WaypointMissionFinishedAction = WaypointMissionFinishedAction.NO_ACTION
            private set
        var headingMode: WaypointMissionHeadingMode?
            private set
        var flightPathMode: WaypointMissionFlightPathMode? = null
            private set
        internal var gotoFirstWaypointMode: WaypointMissionGotoWaypointMode?
        var isExitMissionOnRCSignalLost: Boolean
        var pointOfInterest: LocationCoordinate2D? = null
            private set
        var isGimbalPitchRotationEnabled: Boolean
            private set

        var repeatTimes: Int
            private set

        var waypointList: MutableList<Waypoint>?

        constructor() {
            this.headingMode = WaypointMissionHeadingMode.AUTO
            this.gotoFirstWaypointMode = WaypointMissionGotoWaypointMode.SAFELY
            this.isExitMissionOnRCSignalLost = false
            this.isGimbalPitchRotationEnabled = false
            this.repeatTimes = 1
            this.waypointList = ArrayList()
            this.waypointCount = 0
        }

        constructor(var1: WaypointMission) {
            this.waypointCount = var1.waypointCount
            this.maxFlightSpeed = var1.maxFlightSpeed
            this.autoFlightSpeed = var1.autoFlightSpeed
            this.finishedAction = var1.finishedAction
            this.headingMode = var1.headingMode
            this.flightPathMode = var1.flightPathMode
            this.gotoFirstWaypointMode = var1.gotoFirstWaypointMode
            this.isExitMissionOnRCSignalLost = var1.isExitMissionOnRCSignalLostEnabled
            this.pointOfInterest = var1.pointOfInterest
            this.isGimbalPitchRotationEnabled = var1.isGimbalPitchRotationEnabled
            this.repeatTimes = var1.repeatTimes
            this.waypointList = ArrayList(var1.waypointList)
        }

        fun maxFlightSpeed(var1: Float): Builder {
            this.maxFlightSpeed = var1
            return this
        }

        fun autoFlightSpeed(var1: Float): Builder {
            this.autoFlightSpeed = var1
            return this
        }

        fun finishedAction(var1: WaypointMissionFinishedAction): Builder {
            this.finishedAction = var1
            return this
        }

        fun headingMode(var1: WaypointMissionHeadingMode): Builder {
            this.headingMode = var1
            return this
        }

        fun flightPathMode(var1: WaypointMissionFlightPathMode): Builder {
            this.flightPathMode = var1
            return this
        }

        fun gotoFirstWaypointMode(var1: WaypointMissionGotoWaypointMode): Builder {
            this.gotoFirstWaypointMode = var1
            return this
        }

        fun setExitMissionOnRCSignalLostEnabled(var1: Boolean): Builder {
            this.isExitMissionOnRCSignalLost = var1
            return this
        }

        fun setPointOfInterest(var1: LocationCoordinate2D): Builder {
            this.pointOfInterest = var1
            return this
        }

        fun setGimbalPitchRotationEnabled(var1: Boolean): Builder {
            this.isGimbalPitchRotationEnabled = var1
            return this
        }

        fun repeatTimes(var1: Int): Builder {
            this.repeatTimes = var1
            return this
        }

        fun waypointList(var1: List<Waypoint>): Builder {
            this.waypointList = var1.toMutableList()
            return this
        }

        fun addWaypoint(var1: Waypoint): Builder {
            waypointList!!.add(var1)
            ++this.waypointCount
            return this
        }

        fun waypointCount(var1: Int): Builder {
            this.waypointCount = var1
            return this
        }

        fun build(): WaypointMission {
            return WaypointMission(this)
        }

        fun isMissionComplete(): Boolean =
            this.waypointCount != 0 && this.waypointList != null && this.waypointCount == waypointList!!.size

        fun getGotoFirstWaypointMode(): WaypointMissionGotoWaypointMode? {
            return this.gotoFirstWaypointMode
        }

        fun isExitMissionOnRCSignalLostEnabled(): Boolean {
            return this.isGimbalPitchRotationEnabled
        }

        fun checkParameters(): DJIError? {
            if (this.maxFlightSpeed >= 2.0f && this.maxFlightSpeed <= 15.0f) {
                if (this.autoFlightSpeed >= -15.0f && this.autoFlightSpeed <= 15.0f && abs(
                        autoFlightSpeed.toDouble()
                    ) <= 15.0f
                ) {
                    if (this.repeatTimes < 0) {
                        return DJIMissionError.REPEAT_TIME_NOT_VALID
                    } else if (this.waypointCount >= 2 && this.waypointCount <= 99 && abs(
                            autoFlightSpeed.toDouble()
                        ) <= 15.0f
                    ) {
                        if (this.waypointList != null && waypointList!!.size <= 99 && waypointList!!.size >= 2 && waypointList!!.size == this.waypointCount) {
                            for (var2 in waypointList!!) {
                                val var3: DJIError? = var2.checkParameters()
                                if (var3 != null) {
                                    return var3
                                }
                            }
                            return null
                        } else {
                            return DJIMissionError.WAYPOINT_LIST_SIZE_NOT_VALID
                        }
                    } else {
                        return DJIMissionError.WAYPOINT_COUNT_NOT_VALID
                    }
                } else {
                    return DJIMissionError.MAX_FLIGHT_SPEED_NOT_VALID
                }
            } else {
                return DJIMissionError.MAX_FLIGHT_SPEED_NOT_VALID
            }
        }

//        fun getWaypointList(): List<Waypoint>? {
//            return this.waypointList
//        }
    }
}