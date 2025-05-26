package dji.midware

import io.dronefleet.mavlink.common.CommandLong
import io.dronefleet.mavlink.common.MavCmd
import io.dronefleet.mavlink.common.MavFrame
import io.dronefleet.mavlink.common.MissionItemInt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommandManager(
    private val connectionWrapper: MavlinkConnectionWrapper,
    private val systemId: Int = 2  // пример systemId для отправки команд
) {

    fun arm() {

    }

    fun disarm() {

    }

    fun setGuidedMode() {

    }

    fun takeoff(height: Float) {

    }

    fun land() {

    }

    fun setHomePositionExplicit(lat: Float, lon: Float) {

    }

    fun flyTo(lat: Float, lon: Float, alt: Float) {

    }

    fun yaw(angle: Float) {

    }

    private fun sendCommand(command: Any) {

    }
}