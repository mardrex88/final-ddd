package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import pedido.values.AsesorId;
import pedido.values.Nombre;

import java.util.UUID;

public class AsesorCreado extends DomainEvent {
    private final Nombre nombre;
    private final AsesorId asesorId;

    public AsesorCreado( Nombre nombre, AsesorId asesorId) {
        super("AsesorCreado");
        this.nombre = nombre;
        this.asesorId = asesorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }
}
