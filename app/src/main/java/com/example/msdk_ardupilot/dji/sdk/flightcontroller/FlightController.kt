package dji.sdk.flightcontroller

import io.dronefleet.mavlink.common.GpsRawInt
import io.dronefleet.mavlink.common.HomePosition
import dji.common.flightcontroller.FlightControllerState
import dji.common.flightcontroller.LocationCoordinate3D
import dji.common.model.LocationCoordinate2D
import dji.common.util.CommonCallbacks.CompletionCallback
import dji.common.util.CommonCallbacks.CompletionCallbackWith
import dji.midware.MavlinkConnector
import dji.sdk.base.BaseComponent
import dji.common.bus.EventBus
import dji.common.bus.MavlinkMessageEvent
import dji.common.error.DJIError
import dji.common.flightcontroller.Attitude


class FlightController(id: Int, mavlinkConnector: MavlinkConnector) : BaseComponent(id, mavlinkConnector) {
    protected var onboardSDKDeviceDataCallback: OnboardSDKDeviceDataCallback? = null
    var stateCb: FlightControllerState.Callback? = null
    val state = FlightControllerState()

//    protected var imuStateCallback: IMUState.Callback? = null
//    protected var upgradeSelfCallback: CompletionCallbackWith<Boolean>? = null
//    protected var gravityCenterStateCallback: GravityCenterState.Callback? = null
//    protected var compass: Compass? = null
//    protected var landingGear: LandingGear? = null
//    protected var accessLocker: AccessLocker? = null
//    protected var currentState: FlightControllerState? = null
//    protected var adsbInfoCallback: AirSenseSystemInformation.Callback? = null
//    protected var adsbAvoidanceActionCallback: AirSenseAvoidanceAction.Callback? = null
//    protected var navigationSystemErrorCallbacks: CopyOnWriteArrayList<NavigationSystemError.Callback>? = null
//    protected var paramAccessListener: DJIParamAccessListener? = null
//    protected var verticalControlMode: VerticalControlMode? = null
//    protected var rollPitchControlMode: RollPitchControlMode? = null
//    protected var yawControlMode: YawControlMode? = null
//    protected var virtualStickAdvancedModeEnabled: Boolean = false
//    protected var rollPitchCoordinateSystem: FlightCoordinateSystem? = null
//    private val pipelines: Pipelines? = null

    init {

    }

    fun savePipelinesLog(var1: Boolean) {
    }

//    abstract fun setConnectionFailSafeBehavior(var1: ConnectionFailSafeBehavior, var2: CompletionCallback<*>?)
//
//    abstract fun getConnectionFailSafeBehavior(var1: CompletionCallbackWith<ConnectionFailSafeBehavior?>)
//
//    abstract fun setNoviceModeEnabled(var1: Boolean, var2: CompletionCallback<*>?)
//
//    abstract fun getNoviceModeEnabled(var1: CompletionCallbackWith<Boolean?>)

    fun startTakeoff(var1: CompletionCallback<*>?) {

    }

//    abstract fun startPrecisionTakeoff(var1: CompletionCallback<*>?)

//    abstract fun cancelTakeoff(var1: CompletionCallback<*>?)

    fun startLanding(var1: CompletionCallback<*>?) {

    }

//    abstract fun cancelLanding(var1: CompletionCallback<*>?)

    fun turnOnMotors(callback: CompletionCallback<*>?) {

    }

    fun turnOffMotors(callback: CompletionCallback<*>?) {

    }

//    abstract fun startGoHome(var1: CompletionCallback<*>?)
//
//    abstract fun cancelGoHome(var1: CompletionCallback<*>?)

    fun setHomeLocation(var1: LocationCoordinate2D, var2: CompletionCallback<*>?) {

    }

    fun setHomeLocation(var1: LocationCoordinate2D, var2: (DJIError?) -> Unit) {

    }

    fun getHomeLocation(var1: CompletionCallbackWith<LocationCoordinate2D?>) {}

//    abstract fun setGoHomeHeightInMeters(
//        @IntRange(from = 20L, to = 500L) var1: Int,
//        var2: CompletionCallback<*>?
//    )

//    abstract fun getGoHomeHeightInMeters(var1: CompletionCallbackWith<Int?>)

//    abstract fun sendDataToOnboardSDKDevice(
//        @Size(min = 1L, max = 100L) var1: ByteArray?,
//        var2: CompletionCallback<*>?
//    )

//    abstract fun setLEDsEnabledSettings(var1: LEDsSettings?, var2: CompletionCallback<*>?)

//    abstract fun getLEDsEnabledSettings(var1: CompletionCallbackWith<LEDsSettings?>)

//    abstract fun setFlightOrientationMode(var1: FlightOrientationMode, var2: CompletionCallback<*>?)

//    abstract fun lockCourseUsingCurrentHeading(var1: CompletionCallback<*>?)

//    fun getVerticalControlMode(): VerticalControlMode? {
//        return null
//    }
//
//    fun setVerticalControlMode(var1: VerticalControlMode) {
//    }
//
//    fun getRollPitchControlMode(): RollPitchControlMode? {
//        return null
//    }
//
//    fun setRollPitchControlMode(var1: RollPitchControlMode) {
//    }
//
//    fun getYawControlMode(): YawControlMode? {
//        return null
//    }
//
//    fun setYawControlMode(var1: YawControlMode) {
//    }
//
//    fun getRollPitchCoordinateSystem(): FlightCoordinateSystem? {
//        return null
//    }
//
//    fun setRollPitchCoordinateSystem(var1: FlightCoordinateSystem) {
//    }

    fun setVirtualStickAdvancedModeEnabled(var1: Boolean) {
    }

    fun isVirtualStickAdvancedModeEnabled(): Boolean {
        return false
    }

    fun destroyMOP() {
    }

    fun setState(var1: FlightControllerState) {
    }

    fun setStateCallback(callback: FlightControllerState.Callback?) {
//        this.callback = callback
        state.callback = callback
    }

    fun setStateCallback(callback: (FlightControllerState) -> Unit) {
    }
//
//    fun setASBInformationCallback(var1: AirSenseSystemInformation.Callback?) {
//    }
//
//    fun setADSBAvoidanceActionCallback(var1: AirSenseAvoidanceAction.Callback?) {
//    }

//    fun setMaxFlightHeight(@IntRange(from = 20L, to = 500L) var1: Int, var2: CompletionCallback<*>?) {
//    }

    fun getMaxFlightHeight(var1: CompletionCallbackWith<Int?>) {
    }

//    fun setMaxFlightRadius(@IntRange(from = 15L, to = 8000L) var1: Int, var2: CompletionCallback<*>?) {
//    }

    fun getMaxFlightRadius(var1: CompletionCallbackWith<Int?>) {
    }

    fun setMaxFlightRadiusLimitationEnabled(var1: Boolean, var2: CompletionCallback<*>?) {
    }

    fun getMaxFlightRadiusLimitationEnabled(var1: CompletionCallbackWith<Boolean?>) {
    }

//    abstract fun setESCBeepEnabled(var1: Boolean, var2: CompletionCallback<*>?)
//
//    abstract fun getESCBeepEnabled(var1: CompletionCallbackWith<Boolean?>)
//
//    fun setGravityCenterStateCallback(var1: GravityCenterState.Callback?) {
//    }

    fun setUpgradeSelfCallback(var1: CompletionCallbackWith<Boolean?>?) {
    }

//    abstract fun setPropellerCageProtectionEnabled(var1: Boolean, var2: CompletionCallback<*>?)
//
//    abstract fun getPropellerCageProtectionEnabled(var1: CompletionCallbackWith<Boolean?>)
//
//    abstract fun toggleAttitudeFlightMode(var1: Boolean, var2: CompletionCallback<*>?)
//
//    abstract fun getIsAttitudeFlightModeOpen(var1: CompletionCallbackWith<Boolean?>)
//
//    abstract fun lockTakeoffWithoutGPS(var1: Boolean, var2: CompletionCallback<CommonError?>?)
//
//    abstract fun isLockTakeoffWithoutGPS(var1: CompletionCallbackWith<Boolean?>)
//
//    abstract fun setCoordinatedTurnEnabled(var1: Boolean, var2: CompletionCallback<CommonError?>?)
//
//    abstract fun getCoordinatedTurnEnabled(var1: CompletionCallbackWith<Boolean?>?)
//
//    abstract fun setNavigationSatelliteSystem(
//        var1: NavigationSatelliteSystem,
//        var2: CompletionCallback<CommonError?>?
//    )

//    abstract fun getNavigationSatelliteSystem(var1: CompletionCallbackWith<NavigationSatelliteSystem?>?)

//    abstract fun getPropellerCoverLimitEnabled(var1: CompletionCallbackWith<Boolean?>?)

//    abstract fun setPropellerCoverLimitEnabled(var1: Boolean, var2: CompletionCallback<CommonError?>?)

    interface OnboardSDKDeviceDataCallback {
        fun onReceive(var1: ByteArray?)
    }
}