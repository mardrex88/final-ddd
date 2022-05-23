package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.Cliente;
import factura.values.FacturaId;
import pedido.values.PedidoId;

public class PedidoAgregado extends DomainEvent {

    protected PedidoId pedidoId;
    protected FacturaId facturaId;
    protected Cliente cliente;


    public PedidoAgregado( PedidoId pedidoId, FacturaId facturaId) {
        super("PedidoAgregado");
        this.pedidoId = pedidoId;
        this.facturaId = facturaId;
    }
    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
