package dji.common.mission.waypoint

enum class WaypointTurnMode(private val value: Int) {
    CLOCKWISE(0),
    COUNTER_CLOCKWISE(1);

    fun value() = value

    fun _equals(var1: Int) = value == var1

    companion object {
        fun find(var0: Int): WaypointTurnMode? {
            return entries.firstOrNull { it.value == var0 }
        }
    }
}