package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import pedido.Asesor;
import pedido.values.PedidoId;

import java.util.UUID;

public class PedidoCreado extends DomainEvent {
private final String estado;

    public PedidoCreado(String estado){
        super("PedidoCreado");
        this.estado = estado;
    }

}
