package dji.common.flightcontroller

import kotlin.Double.Companion.NaN

data class LocationCoordinate3D(var latitude: Double = NaN, var longitude: Double = NaN, var altitude: Float = 0.0f)