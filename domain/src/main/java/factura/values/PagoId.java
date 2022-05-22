package factura.values;

import co.com.sofka.domain.generic.Identity;

public class PagoId  extends Identity {

    public PagoId(String id) {
        super(id);
    }

    public PagoId of(String id) {
        return new PagoId(id);
    }
}
