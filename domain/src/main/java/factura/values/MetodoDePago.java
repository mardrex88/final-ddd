package factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetodoDePago implements ValueObject<String> {
    private final String value;

    public MetodoDePago(String value) {
        this.value = Objects.requireNonNull(value);;
    }

    @Override
    public String value() {
        return value;
    }
}
