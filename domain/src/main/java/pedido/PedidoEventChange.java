package pedido;

import co.com.sofka.domain.generic.EventChange;
import pedido.events.AsesorCreado;
import pedido.events.PedidoCreado;

import java.util.HashSet;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.tareas = new HashSet<>();

        });

        apply((AsesorCreado event) -> {
            var asesorId = event.getAsesorId();
            var asesor = new Asesor(asesorId,event.getNombre());
            //TODO: validar que no pueda tener mas de 10 mentorias por curso
            pedido.asesor = asesor;
        });
    }


}
