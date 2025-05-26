package dji.common.mission.waypoint

enum class WaypointMissionFlightPathMode(private val value: Int) {
    NORMAL(0),
    CURVED(1);

    fun value() = value
    fun _equals(var1: Int) = value == var1

    companion object {
        fun find(var0: Int): WaypointMissionFlightPathMode? {
            return entries.firstOrNull { it.value == var0 }
        }
    }
}