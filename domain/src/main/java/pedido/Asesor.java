package pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import pedido.values.AsesorId;
import pedido.values.Nombre;

public class Asesor extends Entity<AsesorId> {

    protected Nombre nombre;

    public Asesor(AsesorId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }


}
