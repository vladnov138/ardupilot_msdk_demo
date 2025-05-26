package dji.midware

import io.dronefleet.mavlink.MavlinkConnection
import io.dronefleet.mavlink.MavlinkMessage
import io.dronefleet.mavlink.ardupilotmega.ArdupilotmegaDialect
import io.dronefleet.mavlink.minimal.MavAutopilot
import java.io.PipedInputStream

/**
 * Обёртка для MavlinkConnection.
 * Создаёт соединение на основе входного и выходного потоков и предоставляет методы отправки сообщений.
 */
class MavlinkConnectionWrapper(
    private val pipedInputStream: PipedInputStream,
    private val outputStream: UDPSenderOutputStream
) {
    val mavlinkConnection: MavlinkConnection = MavlinkConnection.builder(pipedInputStream, outputStream)
        .dialect(MavAutopilot.MAV_AUTOPILOT_ARDUPILOTMEGA, ArdupilotmegaDialect())
        .build()

    fun nextMessage(): MavlinkMessage<*>? {

    }

    fun sendMessage(systemId: Int, componentId: Int, message: Any) {

    }
}