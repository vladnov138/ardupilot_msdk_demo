package dji.sdk.battery

import dji.common.battery.BatteryState
import dji.common.bus.EventBus
import dji.common.bus.MavlinkMessageEvent
import dji.common.util.CommonCallbacks.CompletionCallback
import dji.common.util.CommonCallbacks.CompletionCallbackWith
import dji.midware.MavlinkConnector
import dji.sdk.base.BaseComponent
import io.dronefleet.mavlink.common.BatteryStatus

class Battery(id: Int, mavlinkConnector: MavlinkConnector) :
    BaseComponent(id, mavlinkConnector) {
    protected var stateBuilder: BatteryState.Builder = BatteryState.Builder()
    protected var _stateCallback: BatteryState.Callback? = null
    var numberOfCells: Int = -1
        protected set

    init {
        subscribeToBatteryStatus()
    }

    private fun subscribeToBatteryStatus() {

    }

    private fun updateStateFromBatteryStatus(payload: BatteryStatus) {

    }

    fun setStateCallback(callback: BatteryState.Callback?) {

    }

//    override fun isConnected(): Boolean {
//        return DJIComponentManager.getInstance().a() !== PlatformType.a
//    }

//    override fun getIndex(): Int {
//        return this.index
//    }

//    abstract fun getWarningRecords(var1: CompletionCallbackWith<Array<WarningRecord?>?>?)

//    abstract fun getLatestWarningRecord(var1: CompletionCallbackWith<WarningRecord?>?)

    fun getCellVoltages(var1: CompletionCallbackWith<Array<Int?>?>?) {}

    fun setSelfDischargeInDays(
        var1: Int,
        var2: CompletionCallback<*>?
    ) {}

    fun getSelfDischargeInDays(var1: CompletionCallbackWith<Int?>?) {}

    override fun getFirmwareVersion(var1: CompletionCallbackWith<String?>) {
    }

    override fun getSerialNumber(var1: CompletionCallbackWith<String?>) {
    }

    fun setNumberOfCells(
        var1: Int,
        var2: CompletionCallback<*>?
    ) {}

    fun setLevel1CellVoltageThreshold(
        var1: Int,
        var2: CompletionCallback<*>?
    ) {}

    fun getLevel1CellVoltageThreshold(var1: CompletionCallbackWith<Int?>?) {}

    fun setLevel2CellVoltageThreshold(
        var1: Int,
        var2: CompletionCallback<*>?
    ) {}

    fun getLevel2CellVoltageThreshold(var1: CompletionCallbackWith<Int?>?) {}

//    abstract fun setLevel1CellVoltageBehavior(
//        var1: LowVoltageBehavior?,
//        var2: CompletionCallback<*>?
//    )

//    abstract fun getLevel1CellVoltageBehavior(var1: CompletionCallbackWith<LowVoltageBehavior?>?)

//    abstract fun setLevel2CellVoltageBehavior(
//        var1: LowVoltageBehavior?,
//        var2: CompletionCallback<*>?
//    )

//    abstract fun getLevel2CellVoltageBehavior(var1: CompletionCallbackWith<LowVoltageBehavior?>?)
//
//    abstract fun getPairingState(var1: CompletionCallbackWith<PairingState?>?)

    fun pairBatteries(var1: CompletionCallback<*>?) {}
}