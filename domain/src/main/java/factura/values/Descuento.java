package factura.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descuento  implements ValueObject<Descuento.Pros> {

    private final String nombre;
    private final Double value;

    public Descuento(String nombre, Double value) {
        this.nombre = nombre;
        this.value = value;
    }

    @Override
    public Pros value() {
        return new Pros() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public Double value() {
                return value;
            }
        };
    }


    public interface Pros {
        String nombre();
        Double value();
    }
}
