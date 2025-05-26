package dji.midware

import java.io.OutputStream
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.SocketAddress

/**
 * OutputStream для отправки данных по UDP.
 * Он накапливает данные в буфере и при вызове flush отправляет UDP-пакет.
 */
class UDPSenderOutputStream(
    private val udpSocket: DatagramSocket,
    private val bufferSize: Int,
    private val defaultRemoteAddress: SocketAddress,
    private val remoteAddressProvider: () -> SocketAddress?
) : OutputStream() {

    private val buffer = ByteArray(bufferSize)
    private var position = 0

    override fun write(b: Int) {

    }

    @Synchronized
    override fun write(b: ByteArray, off: Int, len: Int) {

    }

    @Synchronized
    override fun flush() {

    }
}
