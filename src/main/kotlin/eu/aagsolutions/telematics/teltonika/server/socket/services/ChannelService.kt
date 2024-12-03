package eu.aagsolutions.telematics.teltonika.server.socket.services

import eu.aagsolutions.telematics.teltonika.server.devices.model.Inventory
import eu.aagsolutions.telematics.teltonika.server.devices.services.InventoryService
import io.netty.channel.Channel
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class ChannelService(private val inventoryService: InventoryService) {
    private val channelCache: MutableMap<String, Channel> = ConcurrentHashMap()

    fun put(
        key: String,
        value: Channel,
    ) {
        channelCache[key] = value
        inventoryService.saveOrUpdate(
            Inventory(
                id = key,
                connectionStatus = Inventory.ConnectionStatus.CONNECTED,
                System.currentTimeMillis(),
            ),
        )
    }

    fun get(key: String): Channel? = channelCache[key]

    fun remove(key: String) {
        channelCache.remove(key)
        inventoryService.saveOrUpdate(
            Inventory(
                id = key,
                connectionStatus = Inventory.ConnectionStatus.DISCONNECTED,
                System.currentTimeMillis(),
            ),
        )
    }

    fun size(): Int = channelCache.size
}
