package factura.commands;

import co.com.sofka.domain.generic.Command;
import factura.Cliente;
import factura.values.FacturaId;

public class CrearFactura  extends Command {

    private final FacturaId facturaId;
    private final Cliente cliente;

    public CrearFactura(FacturaId facturaId, Cliente cliente) {
        this.facturaId = facturaId;
        this.cliente = cliente;

    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
