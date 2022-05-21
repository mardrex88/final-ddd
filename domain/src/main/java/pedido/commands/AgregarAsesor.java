package pedido.commands;

import co.com.sofka.domain.generic.Command;
import pedido.values.AsesorId;
import pedido.values.Nombre;
import pedido.values.PedidoId;

public class AgregarAsesor extends Command {
    protected PedidoId pedidoId;
    protected Nombre nombre;
    protected String sede;

    public AgregarAsesor(PedidoId pedidoId, Nombre nombre,String sede) {
        this.pedidoId = pedidoId;
        this.nombre = nombre;
        this.sede = sede;

    }
    public PedidoId getPedidoId(){
        return pedidoId;
    }
    public Nombre getNombre(){ return nombre; }

    public String getSede() {
        return sede;
    }
}
