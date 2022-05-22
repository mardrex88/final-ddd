package pedido;

import co.com.sofka.domain.generic.EventChange;
import factura.Factura;
import factura.events.FacturaCreada;
import factura.values.FacturaId;
import pedido.events.AsesorCreado;
import pedido.events.CourierCreado;
import pedido.events.PedidoCreado;
import pedido.events.ServicioCreado;
import pedido.values.Precio;

import java.util.HashSet;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.tareas = new HashSet<>();
        });

        apply((AsesorCreado event) -> {
            var asesorId = event.getAsesorId();
            var asesor = new Asesor(asesorId,event.getNombre(), event.getSede());

            pedido.asesor = asesor;
        });

        apply((ServicioCreado event) -> {
            var servicioId = event.getServicioId();
            var servicio = new Servicio(servicioId, event.getNombre(), event.getPrecioKm(), event.getPrecioBase(), event.getDescripcion());

            pedido.servicio = servicio;
        });

        apply((CourierCreado event) -> {
            var courierId = event.getCourierId();
            var courier = new Courier(courierId, event.getVehiculo(),event.getNombre());

            pedido.courier = courier;
        });

    }


}
