package dji.common.flightcontroller

enum class FlightWindWarning(private val data: Int) {
    LEVEL_0(0),
    LEVEL_1(1),
    LEVEL_2(2),
    UNKNOWN(255);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): FlightWindWarning? {
            return entries.firstOrNull { it.data == var0 }
        }
    }
}