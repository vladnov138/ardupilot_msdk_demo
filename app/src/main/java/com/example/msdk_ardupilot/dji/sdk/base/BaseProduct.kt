package dji.sdk.base

import io.dronefleet.mavlink.MavlinkConnection
import dji.common.util.CommonCallbacks
import dji.midware.MavlinkConnector
import dji.sdk.BatteryBox
import dji.sdk.airlink.AirLink
import dji.sdk.battery.Battery
import dji.sdk.gimbal.Gimbal
import dji.sdk.lidar.Lidar
import dji.sdk.payload.Payload
import dji.sdk.sdkmanager.SDKManager

abstract class BaseProduct(
    protected val mavlinkConnector: MavlinkConnector,
    callback: SDKManager.SDKManagerCallback
) {
    protected var needReloadCameraList: Boolean = false
    protected var needReloadGimbalList: Boolean = false
    protected var needReloadBatteryList: Boolean = false
    protected var needReloadPayloadList: Boolean = false
    protected var needReloadLidarList: Boolean = false

    //    private val lastPlatform: DJIComponentManager.PlatformType? = null
    private val lastPlatformIsWifiConnected: Boolean? = null

    //    private val productListener: SDKManager.SDKManagerCallback? = null // TODO Add callback
//    protected var componentMap: Map<ComponentKey, BaseComponent>? = null // TODO Add components
//    protected var componentGroupMap: Map<ComponentGroupKey, SparseArray<BaseComponent>>? = null
    private val batteries: List<Battery>? = null
        get() = field
    protected var gimbals: List<Gimbal>? = null

    //    protected var cameras: List<Camera>? = null // TODO Connect camera
//        get() =  field
    protected var payloads: List<Payload>? = null
        get() = field
    protected var lidars: List<Lidar>? = null
//    private val diagnosticsHandlers: List<DiagnosticsBaseHandler>? = null // TODO Add diagnostics package
//    private val diagnosticsInformationCallback: DJIDiagnostics.DiagnosticsInformationCallback? = null


    private fun onCreateDiagnostics() {
        TODO("Not yet implemented")
    }

    private fun onDestroyDiagnostics() {
        TODO("Not yet implemented")
    }

    private fun updateComponent(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateLidar(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateCamera(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun getPayloadCamera(var1: Int): Class<*> {
        TODO("Not yet implemented")
    }

    private fun destroyComponent(var1: BaseComponent) {
        TODO("Not yet implemented")
    }

    private fun updateGimbal(var1: Boolean) {
        TODO("Not yet implemented")
    }

//    private fun getGimbalComponentClass(var1: ComponentManager.GimbalComponentType, var2: ComponentManager.PlatformType, var3: Int): Class<*> {
//        TODO("Not yet implemented")
//    }

    private fun updateRadar(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateHandHeld(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateAirLink(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateRemoteController(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateFlightController(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateBatteryBox(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateBattery(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateMobileRemoteController(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updatePayload(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateAccessory(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun updateBaseStation(var1: Boolean) {
        TODO("Not yet implemented")
    }

    private fun checkComponentWithIndex(var1: ComponentKey, var2: Class<*>, var3: Boolean) {
        TODO("Not yet implemented")
    }

    private fun checkComponentWithIndex(var1: ComponentKey, var2: Class<*>, var3: Boolean, var4: Int) {
        TODO("Not yet implemented")
    }

    private fun createBaseComponent(var1: Class<*>, var2: Int): BaseComponent {
        TODO("Not yet implemented")
    }

    private fun findGroupKeyByComponentKey(var1: ComponentKey): ComponentGroupKey {
        TODO("Not yet implemented")
    }

//    fun setDiagnosticsInformationCallback(var1: DJIDiagnostics.DiagnosticsInformationCallback) {
//        TODO("Not yet implemented")
//    }

//    Possible to implement for custom UAV?
//    fun getModel(): Model {
//        TODO("Not yet implemented")
//    }

    open fun isConnected(): Boolean {
        TODO("Not yet implemented")
    }

    abstract fun setName(var1: String, var2: CommonCallbacks.CompletionCallback<*>);

    abstract fun getName(var1: CommonCallbacks.CompletionCallbackWith<String>);

    fun getFirmwarePackageVersion(): String {
        TODO("Not yet implemented")
    }

//    fun getCamera(): Camera {
//        TODO("Not yet implemented")
//    }

//    fun getCameras(): List<Camera>? {
//        TODO("Not yet implemented")
//    }

//    fun getCameraWithComponentIndex(var1: Int): Camera  {
//        TODO("Not yet implemented")
//    }

    fun getBatteryBox(): BatteryBox {
        TODO("Not yet implemented")
    }

    open fun getBattery(): Battery {
        TODO("Not yet implemented")
    }

    fun getGimbal(): Gimbal {
        TODO("Not yet implemented")
    }

    fun getAirLink(): AirLink {
        TODO("Not yet implemented")
    }

    fun getPayload(): Payload {
        TODO("Not yet implemented")
    }

//    fun getAccessoryAggregation(): AccessoryAggregation? {
//        TODO("Not yet implemented")
//    }

    public fun destroy() {
        TODO("Not yet implemented")
    }

//    @Subscribe(
//        threadMode = ThreadMode.MAIN
//    )
//    fun onEvent3MainThread(var1: SDKManager) {
//        TODO("Not yet implemented")
//    }

    enum class ComponentGroupKey(private val data: Int) {
        BatteryGroup(0),
        GimbalGroup(1),
        CameraGroup(2),
        PayloadGroup(3),
        LidarGroup(4);

        fun value() = data
        fun _equals(var1: Int) = data == var1

        companion object {
            fun find(var0: Int): ComponentGroupKey? {
                return entries.firstOrNull { it.data == var0 }
            }
        }
    }

    enum class ComponentKey(private val data: Int) {
        CAMERA(0),
        GIMBAL(1),
        REMOTE_CONTROLLER(2),
        FLIGHT_CONTROLLER(3),
        BATTERY(4),
        HAND_HELD_CONTROLLER(5),
        AIR_LINK(6),
        MOBILE_REMOTE_CONTROLLER(7),
        PAYLOAD(8),
        ACCESSORY_AGGREGATION(9),
        BASE_STATION(10),
        BATTERY_BOX(11),
        RADAR(12),
        LIDAR(13);

        fun value() = data
        fun _equals(var1: Int) = data == var1

        companion object {
            fun find(var0: Int): ComponentKey? {
                return entries.firstOrNull { it.data == var0 }
            }
        }
    }
}