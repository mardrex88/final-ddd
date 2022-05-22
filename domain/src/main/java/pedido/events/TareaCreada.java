package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import tarea.values.TareaId;

public class TareaCreada extends DomainEvent {

  private final TareaId tareaId;
  private final String estado;

    public TareaCreada(TareaId tareaId, String estado) {
        super("TareaCreada");
        this.tareaId = tareaId;
        this.estado = estado;
    }


    public TareaId getTareaId() {
        return tareaId;
    }
}
