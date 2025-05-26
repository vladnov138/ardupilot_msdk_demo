package dji.common.mission.waypoint

enum class WaypointMissionFinishedAction(private val value: Int) {
    NO_ACTION(0),
    GO_HOME(1),
    AUTO_LAND(2),
    GO_FIRST_WAYPOINT(3),
    CONTINUE_UNTIL_END(4);

    fun value() = value
    fun _equals(var1: Int) = value == var1

    companion object {
        fun find(var0: Int): WaypointMissionFinishedAction? {
            return entries.firstOrNull { it.value == var0 }
        }
    }
}