package dji.midware

import io.dronefleet.mavlink.minimal.Heartbeat
import io.dronefleet.mavlink.minimal.MavAutopilot
import io.dronefleet.mavlink.minimal.MavState
import io.dronefleet.mavlink.minimal.MavType
import kotlinx.coroutines.*

/**
 * HeartbeatManager отвечает за периодическую отправку heartbeat-сообщений.
 */
class HeartbeatManager(
    private val connectionWrapper: MavlinkConnectionWrapper,
    private val systemId: Int = 255
) {
    private var heartbeatJob: Job? = null
    private var connected = false

    fun start() {

    }

    fun stop() {

    }
}