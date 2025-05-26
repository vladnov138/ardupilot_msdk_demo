package dji.midware

import io.dronefleet.mavlink.MavlinkMessage
import io.dronefleet.mavlink.common.CommandAck
import io.dronefleet.mavlink.minimal.Heartbeat
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import dji.common.bus.CommandAckEvent
import dji.common.bus.EventBus
import dji.common.bus.MavlinkMessageEvent
import io.dronefleet.mavlink.common.RequestDataStream
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.net.SocketAddress

class MavlinkConnector(
    private val defaultRemoteAddress: SocketAddress
) {
    companion object {
        private const val localPort = 14550
        private const val bufferSize = 65535
    }

    private var udpService: UDPService? = null
    private var connectionWrapper: MavlinkConnectionWrapper? = null
    private var heartbeatManager: HeartbeatManager? = null
    private var _missionManager: MissionManager? = null
    val missionManager get() = _missionManager!!
    private var _commandManager: CommandManager? = null
    val commandManager get() = _commandManager!!

    private val _connectionState = MutableStateFlow(false)
    val connectionState: StateFlow<Boolean> get() = _connectionState

    var connected: Boolean = false
        private set(value) {
            field = value
            _connectionState.value = value
        }

    private var receivingMsgJob: Job? = null

    suspend fun startMavlinkConnection(): Boolean = coroutineScope {

    }

    private fun startReceivingMessages() {

    }

    fun stopMavlinkConnection() {

    }

    private fun startConnectionMonitor() {

    }

    private fun requestDataStreams() {

    }
}