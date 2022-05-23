package pedido;

import co.com.sofka.domain.generic.Entity;
import pedido.values.CourierId;
import pedido.values.Nombre;
import pedido.values.Vehiculo;

public class Courier extends Entity<CourierId> {
    protected Vehiculo vehiculo;
    protected Nombre nombre;


    public Courier(CourierId entityId, Vehiculo vehiculo, Nombre nombre) {
        super(entityId);
        this.vehiculo = vehiculo;
        this.nombre = nombre;
    }


}
