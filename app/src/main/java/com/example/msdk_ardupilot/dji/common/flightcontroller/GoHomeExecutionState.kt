package dji.common.flightcontroller

enum class GoHomeExecutionState(private val data: Int) {
    NOT_EXECUTING(0),
    TURN_DIRECTION_TO_HOME_POINT(1),
    GO_UP_TO_HEIGHT(2),
    AUTO_FLY_TO_HOME_POINT(3),
    GO_DOWN_TO_GROUND(4),
    COMPLETED(5),
    BRAKING(6),
    BYPASSING(7),
    UNKNOWN(255);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): GoHomeExecutionState? {
            return entries.firstOrNull { it.data == var0 }
        }
    }
}