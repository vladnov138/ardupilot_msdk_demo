package dji.common.mission.waypoint

enum class WaypointMissionGotoWaypointMode(private val value: Int) {
    SAFELY(0),
    POINT_TO_POINT(1);

    fun value() = value

    fun _equals(var1: Int) = value == var1

    companion object {
        fun find(var0: Int): WaypointMissionGotoWaypointMode? {
            return entries.firstOrNull { it.value == var0 }
        }
    }
}