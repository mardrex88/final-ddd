package pedido.commands;

import co.com.sofka.domain.generic.Command;
import pedido.values.PedidoId;

public class CrearPedido extends Command {

    private final PedidoId pedidoId;
    private final String estado;


    public CrearPedido(PedidoId pedidoId,String estado) {
        this.pedidoId = pedidoId;
        this.estado = estado;
    }
    public PedidoId getPedidoId(){
        return pedidoId;
    }
    public String getEstado(){
        return estado;
    }
}
