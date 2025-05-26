package dji.common.mission.waypoint

enum class WaypointActionType(private val data: Int) {
    STAY(0),
    START_TAKE_PHOTO(1),
    START_RECORD(2),
    STOP_RECORD(3),
    ROTATE_AIRCRAFT(4),
    GIMBAL_PITCH(5);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): WaypointActionType {
            return entries.firstOrNull { it.data == var0 } ?: STAY
        }
    }
}