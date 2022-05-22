package pedido.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class CourierId extends Identity {

    public CourierId(String uuid) {
        super(uuid);
    }

    public CourierId() {
    }

    public static CourierId of(String id) {
        return new CourierId(id);
    }
}
