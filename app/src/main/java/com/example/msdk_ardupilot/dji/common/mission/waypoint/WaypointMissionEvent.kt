package dji.common.mission.waypoint

import dji.common.error.DJIError

abstract class WaypointMissionEvent(var1: DJIError?) {
    val error: DJIError? = var1

//    fun getError(): CommonError? {
//        return this.error
//    }
}