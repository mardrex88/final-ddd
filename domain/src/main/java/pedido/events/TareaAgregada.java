package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import tarea.values.TareaId;

public class TareaAgregada extends DomainEvent {

    private final TareaId tareaId;
    private final String estado;

    public TareaAgregada(TareaId tareaId, String estado) {
        super("TareaAgregada");
        this.tareaId = tareaId;
        this.estado = estado;
    }


    public TareaId getTareaId() {
        return tareaId;
    }

    public String getEstado() {
        return estado;
    }
}
