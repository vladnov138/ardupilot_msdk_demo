package dji.sdk.mission.timeline

import dji.common.error.DJIError
import dji.common.mission.waypoint.WaypointMission



class Mission private constructor(mission: WaypointMission): TimelineElement() {
    private var missionObject: Any? = null

    init {
        this.missionObject = mission
    }

    fun elementFromWaypointMission(var0: WaypointMission): TimelineElement {
        val mission = Mission(var0)
        return mission
    }

    fun getMissionObject(): Any? {
        return this.missionObject
    }

    override fun run() {
    }

    override fun isPausable(): Boolean {
        return true
    }

    override fun stop() {
    }

    override fun checkValidity(): DJIError? {
        return null
    }
}