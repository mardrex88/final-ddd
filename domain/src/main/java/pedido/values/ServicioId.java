package pedido.values;

import co.com.sofka.domain.generic.Identity;

public class ServicioId extends Identity {
    public ServicioId(String uuid) {
        super(uuid);
    }

    public ServicioId() {
    }

    public static ServicioId of(String id) {
        return new ServicioId(id);
    }
}
