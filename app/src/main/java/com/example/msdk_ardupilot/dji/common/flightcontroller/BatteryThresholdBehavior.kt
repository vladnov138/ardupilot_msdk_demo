package dji.common.flightcontroller

enum class BatteryThresholdBehavior(private val data: Int) {
    FLY_NORMALLY(0),
    GO_HOME(1),
    LAND_IMMEDIATELY(2),
    UNKNOWN(255);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): BatteryThresholdBehavior? {
            return entries.firstOrNull { it.data == var0 }
        }
    }
}