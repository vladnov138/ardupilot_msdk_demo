package dji.common.mission.waypoint


class WaypointUploadProgress {
    var isSummaryUploaded: Boolean = false
    var uploadedWaypointIndex: Int = -1
    var totalWaypointCount: Int = -1

    annotation class InitialValue
    companion object {
        const val UNKNOWN: Int = -1
    }
}