package Tarea.values;

import co.com.sofka.domain.generic.ValueObject;
import com.sun.jdi.Value;

public class Coordenadas implements ValueObject<Coordenadas.Pros> {

    private final Double latitud;
    private final Double longitud;

    public Coordenadas(Double latitud, Double longitud) {
        //TODO:Agregar Validaciones
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public Pros value() {
        return new Pros(){

            @Override
            public Double latitud() {
                return latitud;
            }

            @Override
            public Double longitud() {
                return longitud;
            }
        };
    }

    public interface Pros {
        Double latitud();
        Double longitud();
    }
}
