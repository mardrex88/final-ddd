package factura.values;

import co.com.sofka.domain.generic.Identity;

public class DetalleId extends Identity {
    public DetalleId(String id) {
        super(id);
    }


    public static DetalleId of(String id){
        return new DetalleId(id);
    }
}
