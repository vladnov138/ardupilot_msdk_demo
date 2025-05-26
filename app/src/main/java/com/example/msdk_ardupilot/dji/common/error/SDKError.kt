package dji.common.error

class SDKError(message: String, errorCode: Int? = null) : DJIError(message, errorCode) {
}