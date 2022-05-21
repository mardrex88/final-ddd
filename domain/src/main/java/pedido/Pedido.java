package pedido;

import Tarea.Tarea;
import Tarea.values.TareaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import pedido.events.AsesorCreado;
import pedido.events.PedidoCreado;
import pedido.values.AsesorId;
import pedido.values.Nombre;
import pedido.values.PedidoId;

import java.util.List;
import java.util.Set;


public class Pedido  extends AggregateEvent<PedidoId> {

    protected Asesor asesor;
    protected Servicio servicio;
    protected Courier courier;
    protected Set<TareaId> tareas;
    protected String estado;

    public Pedido(PedidoId entityId,String estado) {
        super(entityId);
        appendChange(new PedidoCreado(estado)).apply();
        subscribe(new PedidoEventChange(this));
    }
    public Pedido(PedidoId entityId) {
        super(entityId);
        subscribe(new PedidoEventChange(this));
    }
    public static Pedido from(PedidoId entityId, List<DomainEvent> events){
        var curso = new Pedido(entityId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarAsesor(Nombre nombre){
        var asesorId = new AsesorId();
        appendChange(new AsesorCreado(nombre,asesorId)).apply();
    }

    public void agregarTarea(TareaId tareaId){
        this.tareas.add(tareaId);
    }



    public void agregarServicio(Servicio servicio){
        this.servicio = servicio;

    }
    public void agregarCourier(Courier courier){
        this.courier = courier;
    }

    public String estado() {
        return estado;
    }
}
