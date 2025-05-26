package dji.sdk.products

import dji.common.util.CommonCallbacks.CompletionCallback
import dji.common.util.CommonCallbacks.CompletionCallbackWith
import dji.midware.MavlinkConnector
import dji.sdk.base.BaseProduct
import dji.sdk.battery.Battery
import dji.sdk.flightcontroller.FlightController
import dji.sdk.gimbal.Gimbal
import dji.sdk.sdkmanager.SDKManager


class Aircraft(mavlinkConnector: MavlinkConnector, callback: SDKManager.SDKManagerCallback) : BaseProduct(mavlinkConnector, callback) {

    var flightController = FlightController(0, mavlinkConnector)
        get() = field
        private set(value) {
            field = value
        }
    private val batteries: List<Battery>? = null
    private val _battery = Battery(0, mavlinkConnector)

    override fun isConnected() = mavlinkConnector.connectionState.value

    override fun getBattery() = _battery

    //    @Synchronized
//    fun getGimbals(): List<Gimbal>? {
//        return null
//    }

//    fun getRemoteController(): RemoteController? {
//        return null
//    }
//
//    fun getMobileRemoteController(): MobileRemoteController? {
//        return null
//    }
//
//    fun getBaseStation(): BaseStation? {
//        return null
//    }
//
//    fun getRadar(): Radar? {
//        return null
//    }

//    @Synchronized
//    fun getLidars(): List<Lidar>? {
//        return null
//    }
//
    override fun setName(var1: String, var2: CompletionCallback<*>) {

    }

    override fun getName(var1: CompletionCallbackWith<String>) {

    }
}