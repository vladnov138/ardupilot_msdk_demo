package dji.sdk.mission.timeline.triggers

import dji.common.flightcontroller.GPSSignalLevel

enum class TriggerEvent(private val event: Int) {
    STARTED(0),
    ACTION_TRIGGERED(1),
    STOPPED(2),
    UNKNOWN(255);

    private fun _equals(var1: Int) = this.event == var1

    companion object {
        fun find(var0: Int): TriggerEvent? {
            return entries.firstOrNull { it.event == var0 }
        }
    }
}