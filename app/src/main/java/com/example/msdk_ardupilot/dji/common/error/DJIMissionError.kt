package dji.common.error

class DJIMissionError private constructor(var1: String) : DJIError(var1) {
    companion object {
        val MAX_FLIGHT_SPEED_NOT_VALID: DJIMissionError = DJIMissionError("Max Flight speed value provided is invalid")
        val AUTO_FLIGHT_SPEED_NOT_VALID: DJIMissionError =
            DJIMissionError("Auto flight speed value provided is invalid")
        val REPEAT_TIME_NOT_VALID: DJIMissionError = DJIMissionError("Repeat time value provided is invalid")
        val WAYPOINT_COUNT_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint count is invalid")
        val WAYPOINT_LIST_SIZE_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint list size is invalid")
        val WAYPOINT_COORDINATE_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint coordinate provided is invalid")
        val ALTITUDE_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint altitude provided is invalid")
        val HEADING_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint heading provided is invalid")
        val ACTION_REPEAT_TIME_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint repeat time provided is invalid")
        val ACTION_TIMEOUT_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint action timeout provided is invalid")
        val CORNER_RADIUS_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint corner radius provided is invalid")
        val GIMBAL_PITCH_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint gimbal pitch provided is invalid")
        val WAYPOINT_SPEED_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint speed provided is invalid")
        val SHOOT_PHOTO_NOT_VALID: DJIMissionError =
            DJIMissionError("Waypoint shoot photo distance provided is invalid")
        val STAY_ACTION_NOT_VALID: DJIMissionError = DJIMissionError("Waypoint stay action param provided is invalid")
        val ROTATE_GIMBAL_ACTION_NOT_VALID: DJIMissionError =
            DJIMissionError("Waypoint rotate gimbal action param provided is invalid")
        val ROTATE_AIRCRAFT_ACTION_NOT_VALID: DJIMissionError =
            DJIMissionError("Waypoint rotate aircraft action param provided is invalid")
        val NULL_MISSION: DJIMissionError = DJIMissionError("Null Mission")
        val INCOMPLETE_MISSION: DJIMissionError = DJIMissionError("Incomplete Mission")
        val COMMON_UNSUPPORTED: DJIMissionError = DJIMissionError("Not supported")
        val COMMON_DISCONNECTED: DJIMissionError = DJIMissionError("Disconnected")
        val BEGAN: DJIMissionError = DJIMissionError("began")
        val CANCELED: DJIMissionError = DJIMissionError("canceled")
        val FAILED: DJIMissionError = DJIMissionError("failed")
        val NO_MISSION_RUNNING: DJIMissionError = DJIMissionError("Mission not existed")
        val TIMEOUT: DJIMissionError = DJIMissionError("Execution of this process has timed out")
        val MODE_ERROR: DJIMissionError =
            DJIMissionError("The control mode of the aircraft is not in the correct state")
        val GPS_NOT_READY: DJIMissionError = DJIMissionError("GPS of aircraft is not ready")
        val MOTORS_DID_NOT_START: DJIMissionError = DJIMissionError("The aircraft's motor has not started")
        val TAKE_OFF: DJIMissionError = DJIMissionError("Aircraft is taking off")
        val IS_FLYING: DJIMissionError = DJIMissionError("Aircraft is flying")
        val NOT_AUTO_MODE: DJIMissionError = DJIMissionError("Aircraft is not in auto mode")
        val MAX_NUMBER_OF_WAYPOINTS_UPLOAD_LIMIT_REACHED: DJIMissionError =
            DJIMissionError("Waypoint mission has reached the maximum points limit")
        val UPLOADING_WAYPOINT: DJIMissionError = DJIMissionError("Waypoint mission is uploading")
        val KEY_LEVEL_LOW: DJIMissionError =
            DJIMissionError("The API key provided to you is not at the correct permission level")
        val NAVIGATION_MODE_DISABLED: DJIMissionError = DJIMissionError("Navigation is not open")
        val TOO_CLOSE_TO_HOME_POINT: DJIMissionError = DJIMissionError("Aircraft is too close to home point")
        val IOC_TYPE_UNKNOWN: DJIMissionError = DJIMissionError("The type of IOC is unknown")
        val HOME_POINT_VALUE_INVALID: DJIMissionError = DJIMissionError("The home point is not a valid float value")
        val HOME_POINT_LOCATION_INVALID: DJIMissionError =
            DJIMissionError("The latitude and longitude of homepoint are invalid")
        val HOME_POINT_DIRECTION_UNKNOWN: DJIMissionError = DJIMissionError("The direction of homepoint is unknown")
        val HOME_POINT_MISSION_PAUSED: DJIMissionError = DJIMissionError("The home-point mission is paused")
        val HOME_POINT_MISSION_NOT_PAUSED: DJIMissionError = DJIMissionError("The home-point  mission is not paused")
        val FOLLOW_ME_DISTANCE_TOO_LARGE: DJIMissionError =
            DJIMissionError("Distance between the aircraft and mobile phone is beyond acceptable limit(must be lower than 20000m)")
        val FOLLOW_ME_DISCONNECT_TIME_TOO_LONG: DJIMissionError =
            DJIMissionError("The disconnect time of follow me mission is too long")
        val FOLLOW_ME_GIMBAL_PITCH_ERROR: DJIMissionError =
            DJIMissionError("The initial pitch angle of gimbal is too large")
        val ALTITUDE_TOO_HIGH: DJIMissionError = DJIMissionError("The altitude is too high")
        val ALTITUDE_TOO_LOW: DJIMissionError = DJIMissionError("The altitude is too low")
        val MISSION_RADIUS_INVALID: DJIMissionError = DJIMissionError("The radius of mission is invalid")
        val MISSION_SPEED_TOO_HIGH: DJIMissionError = DJIMissionError("The speed of mission is too large")
        val MISSION_ENTRY_POINT_INVALID: DJIMissionError = DJIMissionError("The entry point of mission is invalid")
        val MISSION_HEADING_MODE_INVALID: DJIMissionError = DJIMissionError("The heading mode of mission is invalid")
        val MISSION_RESUME_FAILED: DJIMissionError = DJIMissionError("Failed to resume the mission")
        val MISSION_RADIUS_OVER_LIMIT: DJIMissionError =
            DJIMissionError("The radius of mission is over the acceptable limit")
        val NAVIGATION_MODE_NOT_SUPPORTED: DJIMissionError = DJIMissionError("Navigation mode is not supported")
        val DISTANCE_FROM_MISSION_TARGET_TOO_LONG: DJIMissionError =
            DJIMissionError("Navigation in the product is unsupported")
        val RC_MODE_ERROR: DJIMissionError =
            DJIMissionError("Mode error, please make sure the remote controller's mode switch is in 'F' mode.")
        val IOC_WORKING: DJIMissionError = DJIMissionError("The IOC mode is working")
        val MISSION_NOT_INITIALIZED: DJIMissionError = DJIMissionError("The mission is not initialized")
        val MISSION_NOT_EXIST: DJIMissionError = DJIMissionError("The mission does not exist")
        val MISSION_CONFLICT: DJIMissionError = DJIMissionError("There is a conflicting setting in the mission")
        val MISSION_ESTIMATE_TIME_TOO_LONG: DJIMissionError =
            DJIMissionError("The estimated time for the mission is too long")
        val IN_NOVICE_MODE: DJIMissionError = DJIMissionError("The aircraft is in novice mode now")
        val HIGH_PRIORITY_MISSION_EXECUTING: DJIMissionError = DJIMissionError("A higher priority mission is executing")
        val GPS_SIGNAL_WEAK: DJIMissionError = DJIMissionError("The GPS signal of the aircraft is weak")
        val LOW_BATTERY: DJIMissionError = DJIMissionError("Low battery level warning")
        val AIRCRAFT_NOT_IN_THE_AIR: DJIMissionError = DJIMissionError("The aircraft is not in the air")
        val MISSION_PARAMETERS_INVALID: DJIMissionError = DJIMissionError("The parameters of the mission are invalid")
        val MISSION_CONDITION_NOT_SATISFIED: DJIMissionError =
            DJIMissionError("The condition of mission is not satisfied")
        val MISSION_ACROSS_NO_FLY_ZONE: DJIMissionError = DJIMissionError("The mission is across the no fly zone")
        val HOME_POINT_NOT_RECORDED: DJIMissionError = DJIMissionError("The home point of aircraft is not recorded")
        val AIRCRAFT_IN_NO_FLY_ZONE: DJIMissionError = DJIMissionError("The aircraft is in the no fly zone")
        val MISSION_INFO_INVALID: DJIMissionError = DJIMissionError("The information of mission is invalid")
        val WAYPOINT_INFO_INVALID: DJIMissionError = DJIMissionError("The information of waypoint is invalid")
        val WAYPOINT_TRACE_TOO_LONG: DJIMissionError = DJIMissionError("The trace of waypoint is too long")
        val WAYPOINT_TOTAL_TRACE_TOO_LONG: DJIMissionError = DJIMissionError("The total trace of waypoint is too long")
        val WAYPOINT_INDEX_OVER_RANGE: DJIMissionError = DJIMissionError("The index of waypoint is over range")
        val WAYPOINT_DISTANCE_TOO_CLOSE: DJIMissionError = DJIMissionError("The waypoint distance is too close")
        val WAYPOINT_DISTANCE_TOO_LONG: DJIMissionError = DJIMissionError("The waypoint distance is too long")
        val WAYPOINT_DAMPING_CHECK_FAILED: DJIMissionError = DJIMissionError("The damping check is failed")
        val WAYPOINT_ACTION_PARAMETER_INVALID: DJIMissionError =
            DJIMissionError("The parameter of waypoint action is invalid")
        val WAYPOINTS_UPLOADING: DJIMissionError = DJIMissionError("The waypoints are still uploading")
        val WAYPOINT_MISSION_INFO_NOT_UPLOADED: DJIMissionError =
            DJIMissionError("The info of waypoint mission is not completely uploaded")
        val WAYPOINT_UPLOAD_NOT_COMPLETE: DJIMissionError = DJIMissionError("The waypoint uploading is not complete")
        val WAYPOINT_REQUEST_IS_RUNNING: DJIMissionError = DJIMissionError("The waypoint request is running")
        val WAYPOINT_NOT_RUNNING: DJIMissionError = DJIMissionError("The waypoint mission is not running")
        val WAYPOINT_IDLE_VELOCITY_INVALID: DJIMissionError = DJIMissionError("The idle velocity is invalid")
        val AIRCRAFT_TAKING_OFF: DJIMissionError = DJIMissionError("The aircraft is taking off")
        val AIRCRAFT_LANDING: DJIMissionError = DJIMissionError("The aircraft is landing")
        val AIRCRAFT_GOING_HOME: DJIMissionError = DJIMissionError("The aircraft is going home")
        val AIRCRAFT_STARTING_MOTOR: DJIMissionError = DJIMissionError("The aircraft is starting the motor")
        val WRONG_CMD: DJIMissionError = DJIMissionError("The command is wrong")
        val RUNNING_MISSION: DJIMissionError = DJIMissionError("The aircraft is running a mission")
        val TRACKING_TARGET_LOW_CONFIDENCE: DJIMissionError =
            DJIMissionError("The ActiveTrack mission is too unsure the tracking object and confirmation is required.")
        val TRACKING_PAUSED_BY_USER: DJIMissionError = DJIMissionError("Mission is paused by user.")
        val TRACKING_TARGET_TOO_HIGH: DJIMissionError = DJIMissionError("The tracking target is too high.")
        val TRACKING_OBSTACLE_DETECTED: DJIMissionError = DJIMissionError("Obstacles are detected.")
        val TRACKING_GIMBAL_PITCH_TOO_LOW: DJIMissionError = DJIMissionError("The gimbal pitch is too low.")
        val TRACKING_TARGET_TOO_FAR: DJIMissionError =
            DJIMissionError("The tracking target is too far away from the aircraft.")
        val TRACKING_TARGET_TOO_CLOSE: DJIMissionError =
            DJIMissionError("The tracking target is too close to the aircraft.")
        val AIRCRAFT_ALTITUDE_TOO_HIGH: DJIMissionError = DJIMissionError("The aircraft's altitude is too high.")
        val AIRCRAFT_ALTITUDE_TOO_LOW: DJIMissionError = DJIMissionError("The aircraft's altitude is too low.")
        val TRACKING_RECT_TOO_SMALL: DJIMissionError = DJIMissionError("The tracking rectangle is too small.")
        val TRACKING_RECT_TOO_LARGE: DJIMissionError = DJIMissionError("The tracking rectangle is too large.")
        val TRACKING_TARGET_NOT_ENOUGH_FEATURES: DJIMissionError =
            DJIMissionError("The tracking target doesn't have enough features to lock onto.")
        val TRACKING_TARGET_LOST: DJIMissionError = DJIMissionError("The tracking target is lost.")
        val VISION_DATA_ABNORMAL: DJIMissionError = DJIMissionError("The data from the vision system is abnormal.")
        val NO_VIDEO_FEED: DJIMissionError =
            DJIMissionError("No live video feed is captured for the ActiveTrack Mission. ")
        val VIDEO_FRAME_RATE_TOO_LOW: DJIMissionError =
            DJIMissionError("The frame rate of the live video feed is too low.")
        val REACH_FLIGHT_LIMITATION: DJIMissionError =
            DJIMissionError("The aircraft has reached the flight limitation.")
        val VISION_SYSTEM_NOT_AUTHORIZED: DJIMissionError =
            DJIMissionError("The vision system cannot get the authorization to control the aircraft. ")
        val TRACKING_TARGET_SHAKING: DJIMissionError = DJIMissionError("The tracking target is shaking too much.")
        val POINTING_AIRCRAFT_NOT_IN_THE_AIR: DJIMissionError =
            DJIMissionError("The aircraft is not in the air. Please take off first.")
        val VISION_SYSTEM_NEEDS_CALIBRATION: DJIMissionError =
            DJIMissionError("The vision system requires calibration.")
        val FEATURE_POINT_CANNOT_MATCH: DJIMissionError =
            DJIMissionError("The feature points found by both vision sensors cannot match.")
        val VISION_SENSOR_OVEREXPOSED: DJIMissionError = DJIMissionError("The vision sensors are overexposed.")
        val VISION_SENSOR_UNDEREXPOSED: DJIMissionError = DJIMissionError("The vision sensors are underexposed.")
        val VISION_SENSOR_LOW_QUALITY: DJIMissionError = DJIMissionError("The quality of vision sensor is low.")
        val VISION_SYSTEM_ERROR: DJIMissionError = DJIMissionError("The vision system encounters system error.")
        val REACH_ALTITUDE_LOWER_BOUND: DJIMissionError =
            DJIMissionError("The aircraft reaches the altitude lower bound of the TapFly Mission.")
        val CANNOT_BYPASS_OBSTACLE: DJIMissionError = DJIMissionError("The aircraft cannot bypass the obstacle.")
        val STOPPED_BY_USER: DJIMissionError = DJIMissionError("Mission was stopped by the user.")
        val MISSION_NOT_STARTED: DJIMissionError = DJIMissionError("Mission is not started yet")
        val UNKNOWN: DJIMissionError = DJIMissionError("Unknown result")

//        fun getDJIError(var0: Ccode): CommonError {
//            return if (COMMON_UNKNOWN !== CommonError.getDJIError(var0)) {
//                CommonError.getDJIError(var0)
//            } else {
//                when (var0) {
//                    else -> COMMON_UNKNOWN
//                }
//            }
//        }

        fun getDJIErrorByCode(var0: Int): DJIMissionError? {
            return when (var0) {
                0 -> null
                1 -> BEGAN
                2 -> CANCELED
                3 -> FAILED
                4 -> TIMEOUT
                5 -> MODE_ERROR
                6 -> GPS_NOT_READY
                7 -> MOTORS_DID_NOT_START
                8 -> TAKE_OFF
                9 -> IS_FLYING
                10 -> NOT_AUTO_MODE
                11 -> MAX_NUMBER_OF_WAYPOINTS_UPLOAD_LIMIT_REACHED
                12 -> UPLOADING_WAYPOINT
                13 -> KEY_LEVEL_LOW
                14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 164, 165, 167, 168, 171, 172, 173, 174, 175, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 203, 204, 205, 206, 207, 239, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254 -> UNKNOWN
                15 -> NAVIGATION_MODE_DISABLED
                160 -> TOO_CLOSE_TO_HOME_POINT
                161 -> IOC_TYPE_UNKNOWN
                162 -> HOME_POINT_VALUE_INVALID
                163 -> HOME_POINT_LOCATION_INVALID
                166 -> HOME_POINT_DIRECTION_UNKNOWN
                169 -> HOME_POINT_MISSION_PAUSED
                170 -> HOME_POINT_MISSION_NOT_PAUSED
                176 -> FOLLOW_ME_DISTANCE_TOO_LARGE
                177 -> FOLLOW_ME_DISCONNECT_TIME_TOO_LONG
                178 -> FOLLOW_ME_GIMBAL_PITCH_ERROR
                192 -> ALTITUDE_TOO_HIGH
                193 -> ALTITUDE_TOO_LOW
                194 -> MISSION_RADIUS_INVALID
                195 -> MISSION_SPEED_TOO_HIGH
                196 -> MISSION_ENTRY_POINT_INVALID
                197 -> MISSION_HEADING_MODE_INVALID
                198 -> MISSION_RESUME_FAILED
                199 -> MISSION_RADIUS_OVER_LIMIT
                200 -> NAVIGATION_MODE_NOT_SUPPORTED
                201 -> DISTANCE_FROM_MISSION_TARGET_TOO_LONG
                202 -> IN_NOVICE_MODE
                208 -> RC_MODE_ERROR
                209 -> NAVIGATION_MODE_DISABLED
                210 -> IOC_WORKING
                211 -> MISSION_NOT_INITIALIZED
                212 -> MISSION_NOT_EXIST
                213 -> MISSION_CONFLICT
                214 -> MISSION_ESTIMATE_TIME_TOO_LONG
                215 -> HIGH_PRIORITY_MISSION_EXECUTING
                216 -> GPS_SIGNAL_WEAK
                217 -> LOW_BATTERY
                218 -> AIRCRAFT_NOT_IN_THE_AIR
                219 -> MISSION_PARAMETERS_INVALID
                220 -> MISSION_CONDITION_NOT_SATISFIED
                221 -> MISSION_ACROSS_NO_FLY_ZONE
                222 -> HOME_POINT_NOT_RECORDED
                223 -> AIRCRAFT_IN_NO_FLY_ZONE
                224 -> MISSION_INFO_INVALID
                225 -> WAYPOINT_INFO_INVALID
                226 -> WAYPOINT_TRACE_TOO_LONG
                227 -> WAYPOINT_TOTAL_TRACE_TOO_LONG
                228 -> WAYPOINT_INDEX_OVER_RANGE
                229 -> WAYPOINT_DISTANCE_TOO_CLOSE
                230 -> WAYPOINT_DISTANCE_TOO_LONG
                231 -> WAYPOINT_DAMPING_CHECK_FAILED
                232 -> WAYPOINT_ACTION_PARAMETER_INVALID
                233 -> UPLOADING_WAYPOINT
                234 -> WAYPOINT_MISSION_INFO_NOT_UPLOADED
                235 -> WAYPOINT_UPLOAD_NOT_COMPLETE
                236 -> WAYPOINT_REQUEST_IS_RUNNING
                237 -> WAYPOINT_NOT_RUNNING
                238 -> WAYPOINT_IDLE_VELOCITY_INVALID
                240 -> AIRCRAFT_TAKING_OFF
                241 -> AIRCRAFT_LANDING
                242 -> AIRCRAFT_GOING_HOME
                243 -> AIRCRAFT_STARTING_MOTOR
                244 -> WRONG_CMD
                255 -> UNKNOWN
                else -> UNKNOWN
            }
        }
    }
}