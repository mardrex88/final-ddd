package pedido.commands;

import co.com.sofka.domain.generic.Command;
import pedido.values.PedidoId;
import tarea.values.TareaId;

public class AgregarTarea extends Command {

    private final PedidoId pedidoId;
    private final TareaId tareaId;
    private final String estado;

    public AgregarTarea(PedidoId pedidoId, TareaId tareaId, String estado) {
        this.pedidoId = pedidoId;
        this.tareaId = tareaId;
        this.estado = estado;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public TareaId getTareaId() {
        return tareaId;
    }

    public String getEstado() {
        return estado;
    }
}
