package factura;

import co.com.sofka.domain.generic.Entity;
import factura.values.ClienteId;
import factura.values.Identificacion;
import pedido.values.Nombre;

public class Cliente extends Entity<ClienteId> {

    protected Nombre nombre;
    protected Identificacion Identificacion;

    public Cliente(ClienteId entityId, Nombre nombre, Identificacion identificacion) {
        super(entityId);
        this.nombre = nombre;
        Identificacion = identificacion;
    }
}
