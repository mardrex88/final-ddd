package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.Cliente;
import factura.values.FacturaId;
import pedido.values.PedidoId;


public class FacturaCreada extends DomainEvent {
    protected Cliente cliente;
    protected PedidoId pedidoId;
    protected FacturaId faturaId;



    public FacturaCreada( Cliente cliente) {
        super("FacturaCreada");
        this.cliente = cliente;

    }

    public FacturaCreada(PedidoId pedidoId, Cliente cliente, FacturaId faturaId) {
        super("FacturaCreada");
        this.cliente = cliente;
        this.pedidoId = pedidoId;
        this.faturaId = faturaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
    }


}
