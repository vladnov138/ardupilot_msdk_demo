package dji.common.error

open class DJIError(protected val _description: String, protected val _errorCode: Int? = null) {
    companion object {
        val CANNOT_PAUSE_STABILIZATION: DJIError = DJIError("Can't pause stabilization.")
        val COMMON_EXECUTION_FAILED: DJIError = DJIError("The execution could not be executed.")
        val COMMON_SYSTEM_BUSY: DJIError = DJIError("The system is too busy to execute the action")
        val COMMON_UNKNOWN: DJIError = DJIError("Server error, please contact <dev@dji.com> for help.")
        val COMMON_UNDEFINED: DJIError = DJIError("Undefined Error")
        val COMMON_TIMEOUT: DJIError = DJIError("Execution of this process has timed out")
        val COMMON_PARAM_ILLEGAL: DJIError = DJIError("Param Illegal")
        val COMMON_PARAM_INVALID: DJIError = DJIError("Param Invalid")
        val COMMON_UNSUPPORTED: DJIError = DJIError("Not supported")
        val COMMON_DISCONNECTED: DJIError = DJIError("Disconnected")
        val FIRMWARE_NON_SEQUENCE: DJIError = DJIError("Firmware pattern number not continuous")
        val FIRMWARE_LENGTH_WRONG: DJIError = DJIError("Firmware length invalid")
        val FIRMWARE_CRC_WRONG: DJIError = DJIError("Firmware crc value invalid")
        val FLASH_CLEAR_WRONG: DJIError = DJIError("Flash clear error ")
        val FLASH_WRITE_WRONG: DJIError = DJIError("Flash write error ")
        val UPDATE_WRONG: DJIError = DJIError("Update error")
        val FIRMWARE_MATCH_WRONG: DJIError = DJIError("Firmware match error ")
        
        val FLASH_FLUSHING: DJIError = DJIError("Firmware flushing")
        val MEDIA_INVALID_REQUEST_TYPE: DJIError =
            DJIError("Media download result: media downloading request type is invalid")
        val MEDIA_NO_SUCH_FILE: DJIError = DJIError("Media download result: no such file")
        val MEDIA_REQUEST_CLIENT_ABORT: DJIError = DJIError("Media download result: the client aborts the downloading")
        val MEDIA_REQUEST_SERVER_ABORT: DJIError = DJIError("Media download result: the server aborts the downloading")
        val MEDIA_REQUEST_DISCONNECT: DJIError = DJIError("Media download result: the downloading link disconnects")
        val IMAGE_TRANSMITTER_INVALID_PARAMETER: DJIError = DJIError("The input parameter is out of bound or invalid.")
        val COMMAND_NOT_SUPPORTED_BY_FIRMWARE: DJIError =
            DJIError("The command is not supported by the current firmware version.")
        val UNABLE_TO_GET_FIRMWARE_VERSION: DJIError =
            DJIError("Unable to get the firmware version. Note: The sdk will fetch the firmware version from the server so, please ensure you have Internet connectivity before you invoke getVersion().")
        val UNABLE_TO_GET_FLAGS: DJIError =
            DJIError("Unable to get the analytics flags from server. Please ensure you have Internet connectivity before you invoke this method.")
        val UNABLE_TO_GET_FLAG_BUT_RETRY: DJIError =
            DJIError("Unable to get the analytics flags from server, but retrying.  Please ensure you have Internet connectivity before invoking this method")
        val BATTERY_PAIR_FAILED: DJIError = DJIError("Unable to pair the batteries")
        val BATTERY_GET_SMART_BATTERY_INFO_FAILED: DJIError = DJIError("Get smart battery info failed")
        val NO_NETWORK: DJIError = DJIError("No network")
    }

    val description: String
        get() = _description

    val errorCode: Int?
        get() = _errorCode
}