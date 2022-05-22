package factura;

import co.com.sofka.domain.generic.Entity;
import factura.values.Descuento;
import factura.values.DetalleId;

public class Detalle extends Entity<DetalleId> {

    protected Double total;
    protected Descuento descuento;


    public Detalle(DetalleId entityId, Double total, Descuento descuento) {
        super(entityId);
        this.total = total;
        this.descuento = descuento;
    }

    public Double getTotal() {
        return total;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
