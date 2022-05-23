package factura;

import co.com.sofka.domain.generic.EventChange;
import factura.events.FacturaCreada;
import factura.events.PedidoAgregado;

import java.util.ArrayList;
import java.util.HashSet;

public class FacturaEventChange extends EventChange {


    public FacturaEventChange(Factura factura) {

        apply((FacturaCreada event) -> {
            factura.pedidos = new HashSet<>();
        });

        apply((PedidoAgregado event) -> {
            factura.pedidos.add(event.getPedidoId());
        });
    }
}
