package pedido.values;

import co.com.sofka.domain.generic.Identity;

public class PedidoId extends Identity {

    public PedidoId(String uuid) {
        super(uuid);
    }

    public static PedidoId of(String id){ return new PedidoId(id);}
}
