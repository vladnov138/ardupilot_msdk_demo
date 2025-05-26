package dji.common.mission.waypoint

import dji.common.mission.MissionState


class WaypointMissionState private constructor(msg: String) : MissionState(msg) {
    companion object {
        val UNKNOWN: WaypointMissionState = WaypointMissionState("UNKNOWN")
        val DISCONNECTED: WaypointMissionState = WaypointMissionState("DISCONNECTED")
        val NOT_SUPPORTED: WaypointMissionState = WaypointMissionState("NOT_SUPPORTED")
        val RECOVERING: WaypointMissionState = WaypointMissionState("RECOVERING")
        val READY_TO_UPLOAD: WaypointMissionState = WaypointMissionState("READY_TO_UPLOAD")
        val UPLOADING: WaypointMissionState = WaypointMissionState("UPLOADING")
        val READY_TO_EXECUTE: WaypointMissionState = WaypointMissionState("READY_TO_EXECUTE")
        val EXECUTING: WaypointMissionState = WaypointMissionState("EXECUTING")
        val EXECUTION_PAUSED: WaypointMissionState = WaypointMissionState("EXECUTION_PAUSED")
        val READY_TO_RETRY_UPLOAD: MissionState = MissionState("READY_TO_RETRY_UPLOAD")
    }
}