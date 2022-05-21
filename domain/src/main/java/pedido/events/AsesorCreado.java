package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import pedido.values.AsesorId;
import pedido.values.Nombre;

import java.util.UUID;

public class AsesorCreado extends DomainEvent {
    private final Nombre nombre;
    private final String sede;
    private final AsesorId asesorId;

    public AsesorCreado( Nombre nombre, AsesorId asesorId,String sede) {
        super("AsesorCreado");
        this.nombre = nombre;
        this.sede = sede;
        this.asesorId = asesorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public String getSede() {
        return sede;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }
}
