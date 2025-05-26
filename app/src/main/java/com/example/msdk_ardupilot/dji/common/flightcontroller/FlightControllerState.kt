package dji.common.flightcontroller

import dji.common.model.LocationCoordinate2D


class FlightControllerState() {
    var callback: Callback? = null
    private var orientationMode: FlightOrientationMode? = null
    var attitude: Attitude = Attitude()
    private var goHomeExecutionState: GoHomeExecutionState? = null
    private var gpsSignalLevel: GPSSignalLevel? = null
    var homeLocation: LocationCoordinate2D? = null
    var aircraftLocation = LocationCoordinate3D()
    private var flightMode: FlightMode? = null
    private var goHomeAssessment: GoHomeAssessment? = null
    private var isGoingHome = false
    private var isMultipleModeOpen = false
    private var hasReachedMaxFlightHeight = false
    private var hasReachedMaxFlightRadius = false
    private var isHomeLocationSet = false
    private var isFailsafeEnabled = false
    private var motorsOn = false
    private var isUltrasonicBeingUsed = false
    private var isIMUPreheating = false
    private var isVisionPositioningSensorBeingUsed = false
    private var doesUltrasonicHaveError = false
    private var isFlying = false
    private var goHomeHeight = 0
    private var aircraftHeadDirection = 0
    private var ultrasonicHeightInMeters = 0f
    private var takeoffLocationAltitude = 0f
    private var satelliteCount = 0
    private var flightModeString: String? = null
    private var batteryThresholdBehavior: BatteryThresholdBehavior? = null
    private var velocityX = 0f
    private var velocityY = 0f
    private var velocityZ = 0f
    private var flightTimeInSeconds = 0
    private var isLowerThanBatteryWarningThreshold = false
    private var isLowerThanSeriousBatteryWarningThreshold = false
    private var flightWindWarning: FlightWindWarning? = null
    private var islandingConfirmationNeeded = false
    private var flightCount = 0
    private var flightLogIndex = 0
    private var activeBrakeEngaged = false

    interface Callback {
        fun onUpdate(state: FlightControllerState)
    }
}