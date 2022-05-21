package tarea.events;

import co.com.sofka.domain.generic.DomainEvent;
import tarea.values.Coordenadas;
import tarea.values.DestinoId;
import tarea.values.Direccion;


public class DestinoCreado extends DomainEvent {
    private final DestinoId destinoId;
    private final Direccion direccion;
    private final Coordenadas coordenadas;

    public DestinoCreado(DestinoId destinoId, Direccion direccion, Coordenadas coordenadas) {
        super("DestinoCreado");
        this.destinoId = destinoId;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
    }

    public DestinoId getDestinoId() {
        return destinoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }
}
