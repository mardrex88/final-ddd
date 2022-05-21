package pedido.commands;

import co.com.sofka.domain.generic.Command;
import pedido.values.PedidoId;
import pedido.values.Precio;
import pedido.values.ServicioId;

public class AgregarServicio extends Command {

    protected PedidoId pedidoId;
    protected String nombre;
    protected Double precioKm;
    protected Precio precioBase;
    protected String descripcion;

    public AgregarServicio(PedidoId pedidoId, String nombre, Double precioKm, Precio precioBase, String descripcion) {
        this.pedidoId = pedidoId;
        this.nombre = nombre;
        this.precioKm = precioKm;
        this.precioBase = precioBase;
        this.descripcion = descripcion;
    }

    public PedidoId getPedidoId() {
        return pedidoId;
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
