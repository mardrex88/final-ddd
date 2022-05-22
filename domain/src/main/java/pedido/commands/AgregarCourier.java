package pedido.commands;

import co.com.sofka.domain.generic.Command;
import pedido.values.CourierId;
import pedido.values.Nombre;
import pedido.values.PedidoId;
import pedido.values.Vehiculo;

public class AgregarCourier extends Command {

    private final Nombre nombre;
    private final Vehiculo vehiculo;
    protected PedidoId pedidoId;


    public AgregarCourier(PedidoId pedidoId, Nombre nombre,Vehiculo vehiculo) {
        this.nombre = nombre;
        this.pedidoId = pedidoId;
        this.vehiculo = vehiculo;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }
}
