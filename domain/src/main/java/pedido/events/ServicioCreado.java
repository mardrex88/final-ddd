package pedido.events;

import co.com.sofka.domain.generic.DomainEvent;
import pedido.values.Precio;
import pedido.values.ServicioId;

public class ServicioCreado extends DomainEvent {
    protected ServicioId servicioId;
    protected String nombre;
    protected Double precioKm;
    protected Precio precioBase;
    protected String descripcion;



    public ServicioCreado(ServicioId servicioId, String nombre, Double precioKm, Precio precioBase, String descripcion) {
        super("ServicioCreado");
        this.servicioId = servicioId;
        this.nombre = nombre;
        this.precioKm = precioKm;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecioKm() {
        return precioKm;
    }

    public Precio getPrecioBase() {
        return precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
