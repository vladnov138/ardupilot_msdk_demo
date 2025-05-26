package dji.common.mission.waypoint

import dji.common.error.DJIError
import dji.common.error.DJIMissionError
import dji.common.model.LocationCoordinate2D
import dji.common.util.LocationUtils
import java.util.*
import kotlin.math.abs


class Waypoint(val lat: Double, val lon: Double, var altitude: Float) {
    companion object {
        const val MAX_ACTION_COUNT: Int = 15
        const val MAX_ACTION_REPEAT_TIMES: Int = 15
        const val MIN_ACTION_REPEAT_TIMES: Int = 1
        val MIN_ALTITUDE: Float = -200.0f
        const val MAX_ALTITUDE: Float = 500.0f
        val MIN_HEADING: Int = -180
        const val MAX_HEADING: Int = 180
        const val MAX_ACTION_TIMEOUT: Int = 999
        const val MIN_ACTION_TIMEOUT: Int = 0
        const val MIN_CORNER_RADIUS: Float = 0.2f
        const val MAX_CORNER_RADIUS: Float = 1000.0f
        val MIN_GIMBAL_PITCH: Float = -90.0f
        const val MAX_GIMBAL_PITCH: Float = 0.0f
        const val MIN_SPEED: Float = 0.0f
        const val MAX_SPEED: Float = 15.0f
    }
    var coordinate = LocationCoordinate2D(lat, lon)

    var turnMode: WaypointTurnMode? = null

    var heading: Int = 0
    var gimbalPitch: Float = 0f
    var actionRepeatTimes: Int = 1
    var actionTimeoutInSeconds: Int = 999
    var cornerRadiusInMeters: Float = 0.2f
    var hasAction: Boolean = false
    var speed: Float = 0f
    var shootPhotoTimeInterval: Float = 0f
    var shootPhotoDistanceInterval: Float = 0f
    var waypointActions: MutableList<WaypointAction> = LinkedList()

    fun addAction(var1: WaypointAction?): Boolean {
        if (waypointActions.size <= 15 && var1 != null) {
            waypointActions.add(var1)
            this.hasAction = true
            return true
        } else {
            return false
        }
    }

    fun insertAction(var1: WaypointAction, var2: Int): Boolean {
        if (var2 <= waypointActions.size && waypointActions.size < 15) {
            waypointActions.add(var2, var1)
            this.hasAction = true
            return true
        } else {
            return false
        }
    }

    fun removeAllAction() {
        waypointActions.clear()
        this.hasAction = false
    }

    fun removeActionAtIndex(var1: Int): Boolean {
        if (var1 >= waypointActions.size) {
            return false
        } else {
            waypointActions.removeAt(var1)
            if (waypointActions.size <= 0) {
                this.hasAction = false
            }

            return true
        }
    }

    fun removeAction(var1: WaypointAction?): Boolean {
        return waypointActions.remove(var1)
    }

    fun getActionAtIndex(var1: Int): WaypointAction {
        return if (var1 >= waypointActions.size) WaypointAction(
            WaypointActionType.STAY,
            0
        ) else waypointActions[var1]
    }

    fun adjustActionAtIndex(var1: Int, var2: WaypointAction?): Boolean {
        if (var1 < waypointActions.size && var2 != null) {
            waypointActions[var1] = var2
            return true
        } else {
            return false
        }
    }

    fun checkParameters(): DJIError? {
        if (!coordinate.isValid()) {
            return DJIMissionError.WAYPOINT_COORDINATE_NOT_VALID
        } else if (this.altitude >= -200.0f && this.altitude <= 500.0f) {
            if (this.heading >= -180 && this.heading <= 180) {
                if (this.actionRepeatTimes >= 1 && this.actionRepeatTimes <= 15) {
                    if (this.actionTimeoutInSeconds >= 0 && this.actionTimeoutInSeconds <= 999) {
                        if (this.cornerRadiusInMeters >= 0.2f && this.cornerRadiusInMeters <= 1000.0f) {
                            if (this.gimbalPitch >= -90.0f && this.gimbalPitch <= 0.0f) {
                                if (this.speed >= 0.0f && this.speed <= 15.0f) {
                                    if (this.shootPhotoDistanceInterval >= 0.0f && this.shootPhotoTimeInterval >= 0.0f) {
                                        if (this.shootPhotoDistanceInterval > 0.0f && this.shootPhotoTimeInterval > 0.0f) {
                                            return DJIMissionError.SHOOT_PHOTO_NOT_VALID
                                        } else {
                                            for (var2 in this.waypointActions) {
                                                if (var2.actionType === WaypointActionType.STAY) {
                                                    if (var2.actionParam < 0 || var2.actionParam > 32767) {
                                                        return DJIMissionError.STAY_ACTION_NOT_VALID
                                                    }
                                                } else if (var2.actionType === WaypointActionType.GIMBAL_PITCH) {
                                                    if ((var2.actionParam as Float) < -90.0f || (var2.actionParam as Float) > 0.0f) {
                                                        return DJIMissionError.GIMBAL_PITCH_NOT_VALID
                                                    }
                                                } else if (var2.actionType === WaypointActionType.ROTATE_AIRCRAFT && (var2.actionParam > 180 || var2.actionParam < -180)) {
                                                    return DJIMissionError.ROTATE_AIRCRAFT_ACTION_NOT_VALID
                                                }
                                            }

                                            return null
                                        }
                                    } else {
                                        return DJIMissionError.SHOOT_PHOTO_NOT_VALID
                                    }
                                } else {
                                    return DJIMissionError.WAYPOINT_SPEED_NOT_VALID
                                }
                            } else {
                                return DJIMissionError.GIMBAL_PITCH_NOT_VALID
                            }
                        } else {
                            return DJIMissionError.CORNER_RADIUS_NOT_VALID
                        }
                    } else {
                        return DJIMissionError.ACTION_TIMEOUT_NOT_VALID
                    }
                } else {
                    return DJIMissionError.ACTION_REPEAT_TIME_NOT_VALID
                }
            } else {
                return DJIMissionError.HEADING_NOT_VALID
            }
        } else {
            return DJIMissionError.ALTITUDE_NOT_VALID
        }
    }

    fun isEqualPosition(var1: Waypoint): Boolean {
        val var2: Double = LocationUtils.getDistanceInMeterFromTwoGPSLocations(
            coordinate.latitude,
            coordinate.longitude, var1.coordinate.latitude, var1.coordinate.longitude
        )
        return var2 < 0.5 && abs((this.altitude - var1.altitude).toDouble()) < 0.5
    }
}