package dji.midware

import java.io.IOException
import java.io.PipedOutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetSocketAddress
import java.net.SocketAddress
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * UDPService отвечает за приём UDP-пакетов с заданного порта,
 * обновляет текущий удалённый адрес и передаёт данные в предоставленный OutputStream.
 */
class UDPService(
    private val localPort: Int,
    private val bufferSize: Int
) {
    val udpSocket: DatagramSocket = DatagramSocket(localPort)
    @Volatile
    var currentRemoteAddress: SocketAddress? = null
        private set

    private var receivingExecutor: ExecutorService? = null

    fun start(pipedOutputStream: PipedOutputStream) {

    }

    fun stop() {

    }
}