package eu.aagsolutions.telematics.teltonika.server.devices.repository

import eu.aagsolutions.telematics.teltonika.server.devices.model.Inventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : JpaRepository<Inventory, String>
