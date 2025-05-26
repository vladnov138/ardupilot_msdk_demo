package dji.common.flightcontroller

enum class GPSSignalLevel(private val data: Int) {
    LEVEL_0(0),
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3),
    LEVEL_4(4),
    LEVEL_5(5),
    LEVEL_6(6),
    LEVEL_7(7),
    LEVEL_8(8),
    LEVEL_9(9),
    LEVEL_10(10),
    NONE(255);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): GPSSignalLevel? {
            return entries.firstOrNull { it.data == var0 }
        }
    }
}