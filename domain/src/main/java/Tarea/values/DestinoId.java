package tarea.values;

import co.com.sofka.domain.generic.Identity;

public class DestinoId extends Identity {
    public DestinoId(String uuid) {
        super(uuid);
    }

    public DestinoId() {
    }
    public static DestinoId of(String id) {
        return new DestinoId(id);
    }
}
