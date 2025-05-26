package dji.sdk.mission.timeline

import dji.common.error.DJIError
import dji.sdk.mission.timeline.triggers.Trigger

abstract class TimelineElement {

    fun willRun() {
    }

    fun triggers(): List<Trigger>? {
        return null
    }

    abstract fun run()

    abstract fun isPausable(): Boolean

    fun pause() {
    }

    fun resume() {
    }

    abstract fun stop()

    fun didRun() {
    }

    abstract fun checkValidity(): DJIError?
}