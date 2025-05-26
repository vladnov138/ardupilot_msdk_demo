package dji.common.flightcontroller

enum class FlightOrientationMode(private val data: Int) {
    AIRCRAFT_HEADING(0),
    COURSE_LOCK(1),
    HOME_LOCK(2);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): FlightOrientationMode? {
            return entries.firstOrNull { it.data == var0 }
        }
    }
}