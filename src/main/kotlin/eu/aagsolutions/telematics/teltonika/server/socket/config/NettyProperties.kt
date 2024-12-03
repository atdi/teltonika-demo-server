package eu.aagsolutions.telematics.teltonika.server.socket.config

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "netty")
class NettyProperties {
    @NotNull
    @Size(min = 1000, max = 65535)
    var tcpPort: Int = 0

    @NotNull
    @Min(1)
    var bossCount: Int = 0

    @NotNull
    @Min(2)
    var workerCount: Int = 0

    @NotNull
    var keepAlive: Boolean = false

    @NotNull
    var backlog: Int = 0
}
