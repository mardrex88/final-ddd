package pedido;

import co.com.sofka.domain.generic.EventChange;
import pedido.events.AsesorCreado;
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
            //TODO: validar que no pueda tener mas de 10 mentorias por curso
            pedido.asesor = asesor;
        });

        apply((ServicioCreado event) -> {
            var servicioId = event.getServicioId();
            var servicio = new Servicio(servicioId, event.getNombre(), event.getPrecioKm(), event.getPrecioBase(), event.getDescripcion());
            //TODO: validar que no pueda tener mas de 10 mentorias por curso
            pedido.servicio = servicio;
        });
    }


}
