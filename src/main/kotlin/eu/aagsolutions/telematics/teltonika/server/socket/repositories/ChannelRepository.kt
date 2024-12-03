package eu.aagsolutions.telematics.teltonika.server.socket.repositories

import io.netty.channel.Channel
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class ChannelRepository {
    private val channelCache: MutableMap<String, Channel> = ConcurrentHashMap()

    fun put(
        key: String,
        value: Channel,
    ) {
        channelCache[key] = value
    }

    fun get(key: String): Channel? {
        return channelCache[key]
    }

    fun remove(key: String) {
        channelCache.remove(key)
    }

    fun size(): Int {
        return channelCache.size
    }
}
