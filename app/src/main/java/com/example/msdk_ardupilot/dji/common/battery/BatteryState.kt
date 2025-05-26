package dji.common.battery

class BatteryState private constructor(var1: Builder) {
    private val cellVoltageLevel: BatteryCellVoltageLevel?
    val fullChargeCapacity: Int
    val chargeRemaining: Int
    val voltage: Int
    val current: Int
    val lifetimeRemaining: Int
    val chargeRemainingInPercent: Int
    val temperature: Float
    val numberOfDischarges: Int
    val isBeingCharged: Boolean
    val isInSingleBatteryMode: Boolean
    val isBigBattery: Boolean

    init {
        this.cellVoltageLevel = var1.cellVoltageLevel
        this.fullChargeCapacity = var1.fullChargeCapacity
        this.chargeRemaining = var1.chargeRemaining
        this.voltage = var1.voltage
        this.current = var1.current
        this.lifetimeRemaining = var1.lifetimeRemaining
        this.chargeRemainingInPercent = var1.chargeRemainingInPercent
        this.temperature = var1.temperature
        this.numberOfDischarges = var1.numberOfDischarges
        this.isBeingCharged = var1.isBeingCharged
        this.isInSingleBatteryMode = var1.isSingleBattery
        this.isBigBattery = var1.isBigBattery
    }

    fun getCellVoltageLevel(): BatteryCellVoltageLevel? {
        return this.cellVoltageLevel
    }

    override fun equals(var1: Any?): Boolean {
        if (this === var1) {
            return true
        } else if (var1 != null && this.javaClass == var1.javaClass) {
            val var2 = var1 as BatteryState
            return if (this.fullChargeCapacity != var2.fullChargeCapacity) {
                false
            } else if (this.chargeRemaining != var2.chargeRemaining) {
                false
            } else if (this.voltage != var2.voltage) {
                false
            } else if (this.current != var2.current) {
                false
            } else if (this.lifetimeRemaining != var2.lifetimeRemaining) {
                false
            } else if (this.chargeRemainingInPercent != var2.chargeRemainingInPercent) {
                false
            } else if (var2.temperature == this.temperature) {
                false
            } else if (this.numberOfDischarges != var2.numberOfDischarges) {
                false
            } else if (this.isBeingCharged != var2.isBeingCharged) {
                false
            } else if (this.isInSingleBatteryMode != var2.isInSingleBatteryMode) {
                false
            } else if (this.isBigBattery != var2.isBigBattery) {
                false
            } else {
                getCellVoltageLevel() === var2.getCellVoltageLevel()
            }
        } else {
            return false
        }
    }

    override fun hashCode(): Int {
        var var1 = if (this.getCellVoltageLevel() != null) getCellVoltageLevel().hashCode() else 0
        var1 = 31 * var1 + this.fullChargeCapacity
        var1 = 31 * var1 + this.chargeRemaining
        var1 = 31 * var1 + this.voltage
        var1 = 31 * var1 + this.current
        var1 = 31 * var1 + this.lifetimeRemaining
        var1 = 31 * var1 + this.chargeRemainingInPercent
        var1 = 31 * var1 + java.lang.Float.floatToIntBits(this.temperature)
        var1 = 31 * var1 + this.numberOfDischarges
        var1 = 31 * var1 + (if (this.isBeingCharged) 0 else 1)
        var1 = 31 * var1 + (if (this.isInSingleBatteryMode) 0 else 1)
        var1 = 31 * var1 + (if (this.isBigBattery) 0 else 1)
        return var1
    }

    class Builder {
        internal var cellVoltageLevel: BatteryCellVoltageLevel? = null
        var fullChargeCapacity: Int = 0
        var chargeRemaining: Int = 0
        var voltage: Int = 0
        var current: Int = 0
        var lifetimeRemaining: Int = 0
        var chargeRemainingInPercent: Int = 0
        var temperature: Float = 0f
        var numberOfDischarges: Int = 0
        var isBeingCharged: Boolean = false
        var isSingleBattery: Boolean = false
        var isBigBattery: Boolean = false

        fun cellVoltageLevel(var1: BatteryCellVoltageLevel?): Builder {
            this.cellVoltageLevel = var1
            return this
        }

        fun fullChargeCapacity(var1: Int): Builder {
            this.fullChargeCapacity = var1
            return this
        }

        fun chargeRemaining(var1: Int): Builder {
            this.chargeRemaining = var1
            return this
        }

        fun voltage(var1: Int): Builder {
            this.voltage = var1
            return this
        }

        fun current(var1: Int): Builder {
            this.current = var1
            return this
        }

        fun lifetimeRemaining(var1: Int): Builder {
            this.lifetimeRemaining = var1
            return this
        }

        fun chargeRemainingInPercent(var1: Int): Builder {
            this.chargeRemainingInPercent = var1
            return this
        }

        fun temperature(var1: Float): Builder {
            this.temperature = var1
            return this
        }

        fun numberOfDischarges(var1: Int): Builder {
            this.numberOfDischarges = var1
            return this
        }

        fun isBeingCharged(var1: Boolean): Builder {
            this.isBeingCharged = var1
            return this
        }

        fun isSingleBattery(var1: Boolean): Builder {
            this.isSingleBattery = var1
            return this
        }

        fun isBigBattery(var1: Boolean): Builder {
            this.isBigBattery = var1
            return this
        }

        fun build(): BatteryState {
            return BatteryState(this)
        }
    }

    interface Callback {
        fun onUpdate(var1: BatteryState?)
    }
}