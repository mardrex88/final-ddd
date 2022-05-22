package factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import factura.Cliente;
import factura.Detalle;


public class FacturaCreada extends DomainEvent {

    private final Cliente cliente;


    public FacturaCreada( Cliente cliente) {
        super("FacturaCreada");
        this.cliente = cliente;

    }

    public Cliente getCliente() {
        return cliente;
    }

}
