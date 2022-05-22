package factura.values;

import co.com.sofka.domain.generic.ValueObject;

public class Identificacion implements ValueObject<Identificacion.Pros> {
    private final String id;
    private final String tipo;

    public Identificacion(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public Identificacion.Pros value() {
        return new Pros() {
            @Override
            public String id() {
                return id;
            }

            @Override
            public String tipo() {
                return tipo;
            }
        };
    }

    public interface Pros {
        String id();
        String tipo();
    }
}
