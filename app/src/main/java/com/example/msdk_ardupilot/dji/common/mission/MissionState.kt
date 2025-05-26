package dji.common.mission

open class MissionState(val name: String) {
    companion object {
        val DISCONNECTED: MissionState = MissionState("DISCONNECTED")
        val RECOVERING: MissionState = MissionState("RECOVERING")
        val NOT_READY: MissionState = MissionState("NOT_READY")
        val READY_TO_EXECUTE: MissionState = MissionState("READY_TO_EXECUTE")
        val NOT_SUPPORTED: MissionState = MissionState("NOT_SUPPORTED")
        val UNKNOWN: MissionState = MissionState("UNKNOWN")
        val READY_TO_UPLOAD: MissionState = MissionState("READY_TO_UPLOAD")
        val READY_TO_RETRY_UPLOAD: MissionState = MissionState("READY_TO_RETRY_UPLOAD")
        val UPLOAD_STARTING: MissionState = MissionState("UPLOAD_STARTING")
        val UPLOADING: MissionState = MissionState("UPLOADING")
        val EXECUTION_STARTING: MissionState = MissionState("EXECUTION_STARTING")
        val EXECUTING: MissionState = MissionState("EXECUTING")
        val EXECUTION_PAUSING: MissionState = MissionState("EXECUTION_PAUSING")
        val EXECUTION_PAUSED: MissionState = MissionState("EXECUTION_PAUSED")
        val EXECUTION_RESUMING: MissionState = MissionState("EXECUTION_RESUMING")
        val EXECUTION_STOPPING: MissionState = MissionState("EXECUTION_STOPPING")
        val GOT_STUCK: MissionState = MissionState("GOT_STUCK")
        val INITIAL_PHASE: MissionState = MissionState("INITIAL_PHASE")
        val IDLE: MissionState = MissionState("IDLE")
        val CANNOT_START: MissionState = MissionState("CANNOT_START")
        val DETECTING_HUMAN: MissionState = MissionState("DETECTING_HUMAN")
        val WAITING_FOR_CONFIRMATION: MissionState = MissionState("WAITING_FOR_CONFIRMATION")
        val CANNOT_CONFIRM: MissionState = MissionState("CANNOT_CONFIRM")
        val AIRCRAFT_FOLLOWING: MissionState = MissionState("AIRCRAFT_FOLLOWING")
        val ONLY_CAMERA_FOLLOWING: MissionState = MissionState("ONLY_CAMERA_FOLLOWING")
        val QUICK_MOVIE: MissionState = MissionState("PERFORMING_QUICK_SHOT")
        val FINDING_TRACKED_TARGET: MissionState = MissionState("FINDING_TRACKED_TARGET")
        val CAN_NOT_START: MissionState = MissionState("CAN_NOT_START")
        val EXECUTION_RESETTING: MissionState = MissionState("EXECUTION_RESETTING")
        val READY_TO_SETUP: MissionState = MissionState("READY_TO_SETUP")
        val SETTING_UP: MissionState = MissionState("SETTING_UP")
    }

    override fun equals(other: Any?): Boolean {
        return if (super.equals(other)) {
            true
        } else {
            if (other is MissionState) (this.name == other.name) else false
        }
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}