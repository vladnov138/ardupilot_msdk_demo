package dji.sdk.mission.waypoint

import dji.common.error.DJIError
import dji.common.mission.waypoint.WaypointMissionDownloadEvent
import dji.common.mission.waypoint.WaypointMissionExecutionEvent
import dji.common.mission.waypoint.WaypointMissionUploadEvent


interface WaypointMissionOperatorListener {
    fun onDownloadUpdate(var1: WaypointMissionDownloadEvent)

    fun onUploadUpdate(var1: WaypointMissionUploadEvent)

    fun onExecutionUpdate(var1: WaypointMissionExecutionEvent)

    fun onExecutionStart()

    fun onExecutionFinish(var1: DJIError?)
}