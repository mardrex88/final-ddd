package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import pedido.values.CourierId;
import pedido.values.Nombre;
import pedido.values.Vehiculo;

public class CourierCreado extends DomainEvent {

    private final Nombre nombre;
    private final Vehiculo vehiculo;
    private final CourierId courierId;

    public CourierCreado(CourierId courierId, Nombre nombre,Vehiculo vehiculo) {
        super("CourierCreado");
        this.nombre = nombre;
        this.courierId = courierId;
        this.vehiculo = vehiculo;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public CourierId getCourierId() {
        return courierId;
    }
}
