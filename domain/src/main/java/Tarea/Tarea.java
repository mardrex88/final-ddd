package Tarea;

import co.com.sofka.domain.generic.AggregateEvent;
import Tarea.values.TareaId;

public class Tarea  extends AggregateEvent<TareaId> {

    protected Contacto contacto;
    protected Destino destino;
    protected String estado;

    public Tarea(TareaId entityId) {
        super(entityId);
    }


    public void agregarContacto(Contacto contacto){
        this.contacto = contacto;

    }
    public void agregarDestino(Destino destino){
        this.destino = destino;

    }

}
