package dji.common.mission.waypoint

import dji.common.error.DJIError


class WaypointMissionUploadEvent(builder: Builder) : WaypointMissionEvent(builder.error) {
    var previousState: WaypointMissionState? = builder.previousState
        private set
    var currentState: WaypointMissionState = builder.currentState
        private set
    var progress: WaypointUploadProgress? = builder.progress
        private set

//    fun getPreviousState(): WaypointMissionState? {
//        return this.previousState
//    }
//
//    fun getCurrentState(): WaypointMissionState {
//        return currentState
//    }
//
//    fun getProgress(): WaypointUploadProgress? {
//        return this.progress
//    }

    companion object {
        class Builder {
            var previousState: WaypointMissionState? = null
            private var _currentState: WaypointMissionState? = null
            val currentState get() = _currentState!!

            var progress: WaypointUploadProgress? = null

            internal var error: DJIError? = null

            fun previousState(var1: WaypointMissionState?): Builder {
                this.previousState = var1
                return this
            }

            fun currentState(var1: WaypointMissionState?): Builder {
                this._currentState = var1
                return this
            }

            fun error(var1: DJIError?): Builder {
                this.error = var1
                return this
            }

            fun progress(var1: WaypointUploadProgress?): Builder {
                this.progress = var1
                return this
            }

            fun build(): WaypointMissionUploadEvent {
                return WaypointMissionUploadEvent(this)
            }
        }
    }
}