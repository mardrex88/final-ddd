package Tarea.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class TareaId extends Identity implements ValueObject<String> {
    public TareaId(String uuid) {
        super(uuid);
    }
    @Override
    public String value() {
        return null;
    }
}
