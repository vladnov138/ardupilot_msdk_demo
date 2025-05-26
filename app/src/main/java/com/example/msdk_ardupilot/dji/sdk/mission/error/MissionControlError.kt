package dji.sdk.mission.error

import dji.common.error.DJIError

class MissionControlError private constructor(msg: String) : DJIError(msg) {
    companion object {
        val NOT_PAUSABLE_OR_RESUMABLE: MissionControlError =
            MissionControlError("Item is not pausable or resumable, timeline will continue until next")
        val CANNOT_SCHEDULE_WHILE_RUNNING: MissionControlError =
            MissionControlError("Cannot schedule new element while the timeline was running")
    }
}