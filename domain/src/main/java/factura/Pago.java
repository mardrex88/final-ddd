package factura;

import co.com.sofka.domain.generic.Entity;
import factura.values.Fecha;
import factura.values.MetodoDePago;
import factura.values.PagoId;

public class Pago extends Entity<PagoId> {

    protected Fecha fecha;
    protected Double monto;
    protected MetodoDePago metodoDePago;

    public Pago(PagoId entityId, Fecha fecha, Double monto, MetodoDePago metodoDePago) {
        super(entityId);
        this.fecha = fecha;
        this.monto = monto;
        this.metodoDePago = metodoDePago;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }
}
