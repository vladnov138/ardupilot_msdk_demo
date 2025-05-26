package dji.sdk.sdkmanager

import kotlinx.coroutines.*
import dji.midware.MavlinkConnector
import dji.sdk.base.BaseComponent
import dji.sdk.base.BaseProduct
import dji.sdk.base.BaseProduct.ComponentKey
import dji.sdk.mission.waypoint.WaypointMissionOperator
import dji.sdk.products.Aircraft
import java.net.InetSocketAddress
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger


class SDKManager private constructor() {
    // TODO Add video, camera, feature flags
    private val currentInitRes: AtomicInteger? = null
    //    private val context: Context? = null
    private var sdkManagerCallback: SDKManagerCallback? = null
    var connector: MavlinkConnector? = null
    private var _product: BaseProduct? = null
    val product get() = _product!!
    private val managerScope = CoroutineScope(Dispatchers.Default + Job())
    private val initSDKFlag: AtomicBoolean? = null
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)


    companion object {
        private var instance: SDKManager? = null
        @Synchronized
        fun getInstance(): SDKManager {
            if (instance == null) {
                instance = SDKManager()
            }
            return instance!!
        }
    }

    private fun initSDKManager() {
        val instance = getInstance()

    }

    private fun initParams() {

    }

    private fun notifyFlagsChange() {
    }

    private fun notifyProductConnected(var1: BaseProduct) {
    }

    private fun notifyProductChanged(var1: BaseProduct) {
    }

    private fun isMultiSourceProduct(): Boolean {
        return false
    }

    private fun judgeSourceValid(var1: Int, var2: Int): Boolean {
        return false
    }

    private fun changePhysicalSourceToCamIndex(var1: Int): Int {
        return 0
    }

//    private fun getCurOcuSyncLink(): OcuSyncLink? {
//        return null
//    }

    private fun removeListener() {
    }

//    fun getMobileNetworkManager(): MobileNetworkManager? {
//        return null
//    }

//    fun getBluetoothProductConnector(): BluetoothProductConnector? {
//        return null
//    }
//
//    fun getRTKNetworkServiceProvider(): RTKNetworkServiceProvider? {
//        return null
//    }
//
//    fun getUpgradeManager(): UpgradeManager? {
//        return null
//    }
//
//    fun getFlyZoneManager(): FlyZoneManager? {
//        return null
//    }
//
//    fun getFlightHubManager(): FlightHubManager? {
//        return null
//    }

    fun destroy() {
    }

//    fun addSubscription(var1: Subscription?) {
//    }

    fun startConnectionToProduct(): Boolean {

    }

    fun stopConnectionToProduct() {

    }

//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    fun onEvent3MainThread(var1: dji.sdksharedlib.gfd.fdd.ddd?) {
//    }
//
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    fun onEvent3MainThread(var1: DJISDKInnerInitEvent?) {
//    }
//
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    fun onEvent3BackgroundThread(var1: LdmEnableEvent?) {
//    }
//
//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    fun onEvent3BackgroundThread(var1: LdmDisableEvent?) {
//    }

    fun setCallbackRunInUIThread(var1: Boolean) {
    }

    fun closeAOAConnection() {
    }

    fun getLogPath(): String? {
        return null
    }

    fun setSupportOnlyForBluetoothDevice(var1: Boolean) {
    }

    fun enableBridgeModeWithBridgeAppIP(var1: String?) {
    }

    fun initialize(callback: SDKManagerCallback) {

    }

    fun updateProduct(newProduct: BaseProduct) {

    }

    fun getFlycLogPath(): String? {
        return null
    }

    fun setDeviceInfoPrivacyPermission(var1: Boolean) {
    }

    fun setAnalyticsEventPrivacyPermission(var1: Boolean) {
    }

    fun allowStreamWhenAppInBackground(var1: Boolean) {
    }

//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    fun onEventException(var1: SubscriberExceptionEvent?) {
//    }
//
//    private class LifecycleListener private constructor() : LifecycleObserver {
//        @OnLifecycleEvent(Event.ON_START)
//        fun onMoveToForeground() {
//        }
//
//        @OnLifecycleEvent(Event.ON_STOP)
//        fun onMoveToBackground() {
//        }
//    }

    interface SDKManagerCallback {

        fun onProductDisconnect()

        fun onProductConnect(var1: BaseProduct?)

        fun onProductChanged(var1: BaseProduct?)

        fun onComponentChange(var1: ComponentKey?, var2: BaseComponent?, var3: BaseComponent?)

        fun onInitProcess(var1: SDKInitEvent?, var2: Int)
    }
}