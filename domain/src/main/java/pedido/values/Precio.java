package pedido.values;

import co.com.sofka.domain.generic.ValueObject;

public class Precio implements ValueObject<Double> {
    private Double value;

    public Precio(Double value) {
        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }
}
