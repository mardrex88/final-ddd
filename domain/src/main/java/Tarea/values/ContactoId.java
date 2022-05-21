package tarea.values;

import co.com.sofka.domain.generic.Identity;
import pedido.values.ServicioId;

public class ContactoId extends Identity {
    public ContactoId(String uuid) {
        super(uuid);
    }

    public ContactoId() {
    }
    public static ContactoId of(String id) {
        return new ContactoId(id);
    }
}
