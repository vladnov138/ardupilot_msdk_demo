package dji.common.mission.waypoint

enum class WaypointMissionHeadingMode(private val value: Int) {
    AUTO(0),
    USING_INITIAL_DIRECTION(1),
    CONTROL_BY_REMOTE_CONTROLLER(2),
    USING_WAYPOINT_HEADING(3),
    TOWARD_POINT_OF_INTEREST(4);

    fun value(): Int = value

    fun _equals(var1: Int): Boolean = value == var1

    companion object {
        fun find(var0: Int): WaypointMissionHeadingMode? {
            return entries.firstOrNull { it.value == var0 }
        }
    }
}