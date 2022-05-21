package pedido;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import pedido.values.AsesorId;
import pedido.values.Nombre;

public class Asesor extends Entity<AsesorId> {

    protected Nombre nombre;
    protected String sede;

    public Asesor(AsesorId entityId, Nombre nombre, String sede) {
        super(entityId);
        this.nombre = nombre;
        this.sede = sede;
    }

    public void actualizarSede(String sede){
        this.sede = sede;
    }

}
