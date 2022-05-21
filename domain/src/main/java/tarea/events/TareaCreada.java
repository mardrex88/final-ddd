package tarea.events;

import co.com.sofka.domain.generic.DomainEvent;

public class TareaCreada extends DomainEvent {

    private final String estado;

    public TareaCreada(String estado) {
        super("TareaCreada");
        this.estado = estado;
    }

}
