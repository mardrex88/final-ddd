package pedido;

import co.com.sofka.domain.generic.Entity;
import pedido.values.Precio;
import pedido.values.ServicioId;

public class Servicio extends Entity<ServicioId> {

    protected String nombre;
    protected Double precioKm;
    protected Precio precioBase;
    protected String descripcion;


    public Servicio(ServicioId entityId) {
        super(entityId);
    }

    public Servicio(ServicioId entityId, String nombre, Double precioKm, Precio precioBase, String descripcion) {
        super(entityId);
        this.nombre = nombre;
        this.precioKm = precioKm;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
    }
}
