package dji.common.flightcontroller

class GoHomeAssessment(builder: Builder) {
    private var remainingFlightTime = 0
        get() = field
    private var timeNeededToGoHome = 0
        get() = field
    private var timeNeededToLandFromCurrentHeight = 0
        get() = field
    private var batteryPercentageNeededToGoHome = 0
        get() = field
    private var maxRadiusAircraftCanFlyAndGoHome = 0f
        get() = field
    private var batteryPercentageNeededToLandFromCurrentHeight = 0
        get() = field
    private var smartRTHState: SmartRTHState? = null
        get() = field
    private var smartRTHCountdown = 0
        get() = field

    init {
        remainingFlightTime = builder.remainingFlightTime
        timeNeededToGoHome = builder.timeNeededToGoHome
        timeNeededToLandFromCurrentHeight = builder.timeNeededToLandFromCurrentHeight
        batteryPercentageNeededToGoHome = builder.batteryPercentageNeededToGoHome
        maxRadiusAircraftCanFlyAndGoHome = builder.maxRadiusAircraftCanFlyAndGoHome
        batteryPercentageNeededToLandFromCurrentHeight = builder.batteryPercentageNeededToLandFromCurrentHeight
        smartRTHState = builder.smartRTHState
        smartRTHCountdown = builder.smartRTHCountdown
    }

    class Builder {
        var remainingFlightTime = 0
        var timeNeededToGoHome = 0
        var timeNeededToLandFromCurrentHeight = 0
        var batteryPercentageNeededToGoHome = 0
        var maxRadiusAircraftCanFlyAndGoHome = 0f
        var batteryPercentageNeededToLandFromCurrentHeight = 0
        var smartRTHState: SmartRTHState? = null
        var smartRTHCountdown = 0

        fun build(): GoHomeAssessment {
            return GoHomeAssessment(this)
        }
    }
}