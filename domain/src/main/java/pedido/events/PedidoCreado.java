package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import pedido.values.PedidoId;

public class PedidoCreado extends DomainEvent {

private final String estado;
protected PedidoId pedidoId;

    public PedidoCreado(String estado){
        super("PedidoCreado");
        this.estado = estado;
    }
    public PedidoCreado(PedidoId pedidoId, String estado){
        super("PedidoCreado");
        this.estado = estado;
        this.pedidoId = pedidoId;
    }


}
