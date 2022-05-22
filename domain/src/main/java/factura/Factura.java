package factura;

import co.com.sofka.domain.generic.DomainEvent;
import factura.events.FacturaCreada;
import factura.events.PedidoAgregado;
import factura.values.FacturaId;
import co.com.sofka.domain.generic.AggregateEvent;
import pedido.Pedido;
import pedido.events.TareaCreada;
import pedido.values.Nombre;
import pedido.values.PedidoId;

import java.util.List;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaId> {

    protected Cliente cliente;
    protected Detalle detalles;
    protected Set<PedidoId> pedidos;
    protected Pago pago;

    public Factura(FacturaId entityId) {
        super(entityId);
        subscribe(new FacturaEventChange(this));
    }

    public Factura(FacturaId facturaId, Cliente cliente) {
        super(facturaId);
        appendChange(new FacturaCreada(cliente)).apply();
        subscribe(new FacturaEventChange(this));
    }


    public static Factura from(FacturaId entityId, List<DomainEvent> events){
        var factura = new Factura(entityId);
        events.forEach(factura::applyEvent);
        return factura;
    }

    public void agregarPedido(PedidoId pedidoId, Cliente cliente, FacturaId facturaId){
        appendChange(new FacturaCreada(pedidoId,cliente,facturaId)).apply();
    }
}
