package dji.common.mission

class MissionEvent(private var name: String) {
    companion object {
        val INITIALIZED: MissionEvent = MissionEvent("INITIALIZED")
        val ENTER_NAVIGATION_MODE: MissionEvent = MissionEvent("ENTER_NAVIGATION_MODE")
        val EXIT_NAVIGATION_MODE: MissionEvent = MissionEvent("EXIT_NAVIGATION_MODE")
        val RC_MODE_CHANGED: MissionEvent = MissionEvent("RC_MODE_CHANGED")
        val DISCONNECTED: MissionEvent = MissionEvent("DISCONNECTED")
        val CONNECTED: MissionEvent = MissionEvent("CONNECTED")
        val EXECUTION_STARTED: MissionEvent = MissionEvent("EXECUTION_STARTED")
        val EXECUTION_START_FAILED: MissionEvent = MissionEvent("EXECUTION_START_FAILED")
        val EXECUTION_PAUSED: MissionEvent = MissionEvent("EXECUTION_PAUSED")
        val EXECUTION_PAUSE_FAILED: MissionEvent = MissionEvent("EXECUTION_PAUSE_FAILED")
        val EXECUTION_STOPPED: MissionEvent = MissionEvent("EXECUTION_STOPPED")
        val EXECUTION_STOP_FAILED: MissionEvent = MissionEvent("EXECUTION_STOP_FAILED")
        val EXECUTION_RESUMED: MissionEvent = MissionEvent("EXECUTION_RESUMED")
        val EXECUTION_RESUME_FAILED: MissionEvent = MissionEvent("EXECUTION_RESUME_FAILED")
        val EXECUTION_PROGRESS_UPDATE: MissionEvent = MissionEvent("EXECUTION_PROGRESS_UPDATE")
        val EXECUTION_INTERRUPTED: MissionEvent = MissionEvent("EXECUTION_INTERRUPTED")
        val EXECUTION_FINISHED: MissionEvent = MissionEvent("EXECUTION_FINISHED")
        val EXECUTION_FAILED: MissionEvent = MissionEvent("EXECUTION_FAILED")
        val DOWNLOAD_FAILED: MissionEvent = MissionEvent("DOWNLOAD_FAILED")
        val DOWNLOAD_DONE: MissionEvent = MissionEvent("DOWNLOAD_DONE")
        val SETUP_FAILED: MissionEvent = MissionEvent("SETUP_FAILED")
        val UNKNOWN: MissionEvent = MissionEvent("UNKNOWN")
        val SETUP_DONE: MissionEvent = MissionEvent("SETUP_DONE")
        val CAMERA_MODE_CHANGE: MissionEvent = MissionEvent("CAMERA_MODE_CHANGE")
    }

    fun getName(): String {
        return this.name
    }

    override fun equals(other: Any?): Boolean {
        return if (super.equals(other)) {
            true
        } else {
            if (other is MissionEvent) (this.name == other.getName()) else false
        }
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}