package dji.common.mission

import dji.common.mission.waypoint.WaypointMissionState


object StateHelper {
    private val PUBLIC_WAYPOINT_STATE: Array<WaypointMissionState>

    init {
        PUBLIC_WAYPOINT_STATE = arrayOf(
            WaypointMissionState.UNKNOWN,
            WaypointMissionState.DISCONNECTED,
            WaypointMissionState.NOT_SUPPORTED,
            WaypointMissionState.RECOVERING,
            WaypointMissionState.READY_TO_UPLOAD,
            WaypointMissionState.UPLOADING,
            WaypointMissionState.READY_TO_EXECUTE,
            WaypointMissionState.EXECUTING,
            WaypointMissionState.EXECUTION_PAUSED
        )
    }

    fun convertToWaypointPublicState(state: MissionState?): WaypointMissionState {
        if (state == null) {
            return WaypointMissionState.UNKNOWN
        } else {
            for (publicStateItem in PUBLIC_WAYPOINT_STATE) {
                if (publicStateItem.equals(state)) {
                    return publicStateItem
                }
            }

            return if (state != MissionState.NOT_READY && state != MissionState.READY_TO_RETRY_UPLOAD && state != MissionState.UPLOAD_STARTING) {
                if (state == MissionState.EXECUTION_STARTING) {
                    WaypointMissionState.READY_TO_EXECUTE
                } else if (state != MissionState.EXECUTION_PAUSING && state != MissionState.EXECUTION_STOPPING) {
                    if (state == MissionState.EXECUTION_RESUMING) {
                        WaypointMissionState.EXECUTION_PAUSED
                    } else {
                        WaypointMissionState.UNKNOWN
                    }
                } else {
                    WaypointMissionState.EXECUTING
                }
            } else {
                WaypointMissionState.READY_TO_UPLOAD
            }
        }
    }
}