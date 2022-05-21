package tarea.values;

import co.com.sofka.domain.generic.ValueObject;

public class Telefono implements ValueObject {
    private String value;

    public Telefono(String value) {
        this.value = value;
    }

    @Override
    public Object value() {
        return value;
    }
}
