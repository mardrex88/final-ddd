package tarea;

import pedido.PedidoEventChange;
import pedido.values.ServicioId;
import tarea.events.ContactoCreado;
import tarea.events.TareaCreada;
import co.com.sofka.domain.generic.AggregateEvent;
import tarea.values.ContactoId;
import tarea.values.TareaId;
import co.com.sofka.domain.generic.DomainEvent;
import tarea.values.Telefono;

import java.util.List;

public class Tarea  extends AggregateEvent<TareaId> {

    protected Contacto contacto;
    protected Destino destino;
    protected String estado;

    public Tarea(TareaId entityId,String estado) {
        super(entityId);
        appendChange(new TareaCreada(estado)).apply();
        subscribe(new TareaEventChange(this));
    }

    public Tarea(TareaId entityId) {
        super(entityId);
        subscribe(new TareaEventChange(this));
    }

    public static Tarea from(TareaId tareaId, List<DomainEvent> events){
        var tarea = new Tarea(tareaId);
        events.forEach(tarea::applyEvent);
        return tarea;
    }



    public void agregarContacto(Telefono telefono, String nombre){
            var contactoId = new ContactoId();
          appendChange(new ContactoCreado(contactoId,telefono,nombre)).apply();
    }

    public void agregarDestino(Destino destino){
        this.destino = destino;
    }

}
