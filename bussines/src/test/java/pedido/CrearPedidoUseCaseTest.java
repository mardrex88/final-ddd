package pedido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pedido.commands.CrearPedido;
import pedido.events.PedidoCreado;
import pedido.values.PedidoId;

public class CrearPedidoUseCaseTest {

    private CrearPedidoUseCase useCase;

    @BeforeEach
    public void setup(){useCase = new CrearPedidoUseCase(); }

    @Test
    public void crearPedidohappyPass(){
        //arr
        PedidoId pedidoId = PedidoId.of("0001");

        var command = new CrearPedido(pedidoId,"Borrador");

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ass
        var pedidoCreado = (PedidoCreado)events.get(0);
        Assertions.assertEquals("0001",pedidoCreado.aggregateRootId());
    }
}
