package pedido.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class AsesorId extends Identity {

    public AsesorId(String id){
        super(id);
    }

    public static AsesorId of(String id) {
        return new AsesorId(id);
    }
}
