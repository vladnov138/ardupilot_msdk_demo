package dji.sdk.sdkmanager


class SDKInitEvent(private val initializationState: InitializationState, private val currentTime: Long) {
    companion object {
        enum class InitializationState {
            START_TO_INITIALIZE,
            ASSETS_LOADED,
            DATABASE_LOADED
        }
    }
}