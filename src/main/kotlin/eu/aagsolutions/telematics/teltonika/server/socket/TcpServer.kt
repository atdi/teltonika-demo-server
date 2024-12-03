package eu.aagsolutions.telematics.teltonika.server.socket

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import jakarta.annotation.PreDestroy
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.net.InetSocketAddress

@Component
class TcpServer(
    private val serverBootstrap: ServerBootstrap,
    private val tcpPort: InetSocketAddress,
) {
    private var serverChannel: Channel? = null

    fun start() {
        try {
            val serverChannelFuture: ChannelFuture = serverBootstrap.bind(tcpPort).sync()
            logger.info("Server is started: port {}", tcpPort.port)
            serverChannel = serverChannelFuture.channel().closeFuture().sync().channel()
        } catch (e: InterruptedException) {
            logger.error("Server is interrupted: ", e)
            Thread.currentThread().interrupt()
        }
    }

    @PreDestroy
    fun stop() {
        serverChannel?.let {
            it.close()
            it.parent()?.close()
        }
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(TcpServer::class.java)
    }
}
