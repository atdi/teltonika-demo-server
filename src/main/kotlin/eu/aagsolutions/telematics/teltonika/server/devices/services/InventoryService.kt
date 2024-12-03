package eu.aagsolutions.telematics.teltonika.server.devices.services

import eu.aagsolutions.telematics.teltonika.server.devices.model.Inventory
import eu.aagsolutions.telematics.teltonika.server.devices.repository.InventoryRepository
import org.springframework.stereotype.Service

@Service
class InventoryService(private val inventoryRepository: InventoryRepository) {
    fun saveOrUpdate(inventory: Inventory): Inventory {
        return inventoryRepository.save(inventory)
    }
}
