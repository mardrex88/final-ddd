package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;

public class PedidoCreado extends DomainEvent {

private final String estado;

    public PedidoCreado(String estado){
        super("PedidoCreado");
        this.estado = estado;
    }

}
