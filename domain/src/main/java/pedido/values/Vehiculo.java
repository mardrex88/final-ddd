package pedido.values;

import co.com.sofka.domain.generic.ValueObject;
import tarea.values.Coordenadas;

public class Vehiculo implements ValueObject<Vehiculo.Pros> {

    private final String placa;
    private final String color;

    public Vehiculo(String placa, String color) {
        this.placa = placa;
        this.color = color;
    }


    @Override
    public Pros value() {
       return new Pros() {
           @Override
           public String placa() {
               return placa;
           }

           @Override
           public String color() {
               return color;
           }
       };
    }

    public interface Pros {
        String placa();
        String color();
    }
}
