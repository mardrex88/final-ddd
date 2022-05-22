package factura;

import factura.values.FacturaId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Factura extends AggregateEvent<FacturaId> {

    public Factura(FacturaId entityId) {
        super(entityId);
    }
}
