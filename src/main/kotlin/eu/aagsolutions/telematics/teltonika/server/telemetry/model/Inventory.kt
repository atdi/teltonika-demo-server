package eu.aagsolutions.telematics.teltonika.server.telemetry.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "inventory")
class Inventory(
    @Id
    val id: String,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val connectionStatus: ConnectionStatus,
    @Column(nullable = false)
    val updateTimestamp: Long,
) {
    enum class ConnectionStatus {
        CONNECTED,
        DISCONNECTED,
    }
}
