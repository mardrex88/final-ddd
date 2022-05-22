package pedido;

import pedido.events.CourierCreado;
import tarea.values.TareaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import pedido.events.AsesorCreado;
import pedido.events.PedidoCreado;
import pedido.events.ServicioCreado;
import pedido.values.*;

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
        var pedido = new Pedido(entityId);
        events.forEach(pedido::applyEvent);
        return pedido;
    }

    public void agregarAsesor(Nombre nombre,String sede){
        var asesorId = new AsesorId();
        appendChange(new AsesorCreado(nombre,asesorId,sede)).apply();
    }


    public void agregarServicio(String nombre, Double precioKm, Precio precioBase, String descripcion) {
        var servicioId = new ServicioId();
        appendChange(new ServicioCreado(servicioId, nombre, precioKm, precioBase, descripcion)).apply();
    }


    public void agregarTarea(TareaId tareaId){
        this.tareas.add(tareaId);
    }



    public void agregarCourier(Nombre nombre, Vehiculo vehiculo){
        var courierId = new CourierId();
        appendChange(new CourierCreado(courierId,nombre,vehiculo)).apply();
    }

    public String estado() {
        return estado;
    }
}
