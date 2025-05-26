package dji.common.battery

enum class BatteryCellVoltageLevel(private val data: Int) {
    LEVEL_0(0),
    LEVEL_1(1),
    LEVEL_2(2),
    LEVEL_3(3),
    UNKNOWN(255);

    fun value(): Int {
        return this.data
    }
}
