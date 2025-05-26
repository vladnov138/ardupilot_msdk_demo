package dji.midware

import android.util.Log
import io.dronefleet.mavlink.common.*
import kotlinx.coroutines.*
import dji.common.bus.EventBus
import dji.common.bus.MavlinkMessageEvent
import dji.common.mission.waypoint.Waypoint
import dji.common.mission.waypoint.WaypointMissionFinishedAction
import dji.common.model.LocationCoordinate2D
import dji.midware.MavlinkConnectionWrapper

class MissionManager(
    private val wrapper: MavlinkConnectionWrapper,
    private val sysId: Int,
    private val compId: Int
) {

    companion object {
        const val yawSpeed = 90f // 90 degrees per second
        const val yawDirection = 1f // clockwise
    }

    private val scope = CoroutineScope(Dispatchers.IO)
    private var seq = 0
    var missionItems: List<MissionItemInt>? = null
        private set
    private var speedCommand: MissionItemInt.Builder? = null


    fun setSpeedCommand(speed: Float) {

    }

    fun setHomePosition(position: LocationCoordinate2D) {

    }

    fun formMissionItems(waypointList: List<Waypoint>, yawFix: Boolean, finishedAction: WaypointMissionFinishedAction) {

    }

    fun clearMissionItems() {

    }

    fun uploadMission(
        onResult: (Boolean) -> Unit
    ) {

    }

    fun startMission() {

    }

    fun setAutoMode() {

    }

    private suspend inline fun <reified T> waitFor(
        crossinline filter: (T) -> Boolean,
        timeout: Long = 3000
    ): T? = withTimeoutOrNull(timeout) {

    }
}