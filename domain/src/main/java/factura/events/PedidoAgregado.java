package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.Cliente;
import factura.values.FacturaId;
import pedido.values.PedidoId;

public class PedidoAgregado extends DomainEvent {

    protected PedidoId pedidoId;
    protected FacturaId facturaId;
    protected Cliente cliente;

    public PedidoAgregado(String type, PedidoId pedidoId, FacturaId facturaId, Cliente cliente) {
        super(type);
        this.pedidoId = pedidoId;
        this.facturaId = facturaId;
        this.cliente = cliente;
    }

    public PedidoAgregado(String type) {
        super(type);
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
