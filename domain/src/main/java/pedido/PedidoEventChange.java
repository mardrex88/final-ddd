package pedido;

import co.com.sofka.domain.generic.EventChange;
import pedido.events.PedidoCreado;

import java.util.HashSet;

public class PedidoEventChange extends EventChange {
    public PedidoEventChange(Pedido pedido) {
        apply((PedidoCreado event) -> {
            pedido.tareas = new HashSet<>();
        });
    }

    public void agregarTarea(){

    }
}
