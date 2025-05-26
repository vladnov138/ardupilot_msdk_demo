package dji.common.bus

import io.dronefleet.mavlink.MavlinkMessage
import io.dronefleet.mavlink.common.CommandAck
import java.util.concurrent.ConcurrentHashMap

object EventBus {
    private val subscribers: ConcurrentHashMap<Class<*>, MutableList<(Any) -> Unit>> =
        ConcurrentHashMap()

    @Synchronized
    fun <T : Any> register(eventClass: Class<T>, handler: (T) -> Unit) {

    }

    @Synchronized
    fun <T : Any> unregister(eventClass: Class<T>, handler: (T) -> Unit) {

    }

    @Synchronized
    fun post(event: Any) {

    }
}


data class CommandAckEvent(val commandAck: CommandAck)

data class MavlinkMessageEvent<T>(val message: MavlinkMessage<T>)