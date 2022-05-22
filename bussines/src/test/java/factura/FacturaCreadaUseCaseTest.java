package factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import factura.events.FacturaCreada;
import factura.values.ClienteId;
import factura.values.FacturaId;
import factura.values.Identificacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pedido.events.PedidoCreado;
import pedido.values.Nombre;
import pedido.values.PedidoId;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class FacturaCreadaUseCaseTest {


    @InjectMocks
    private FacturaCreadaUseCase useCase;


    @Mock
    private DomainEventRepository repository;


    @Test
    void facturaCreadaHappyPass(){
        //arr
        Nombre nombreCliente = new Nombre("Nombre Cliente");
        Identificacion identificacion = new Identificacion("123456789","Cedula");
        Cliente cliente  = new Cliente(ClienteId.of("Cliente1"),nombreCliente,identificacion);

        var pedidoId = PedidoId.of("Pedido1");
        var facturaId = FacturaId.of("Factura1");

        var command = new FacturaCreada(pedidoId,cliente,facturaId);


        when(repository.getEventsBy("Pedido1")).thenReturn(history());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(pedidoId.value())
                .syncExecutor(useCase,new TriggeredEvent<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var factura = (FacturaCreada)events.get(0);
        Assertions.assertEquals("Nombre Cliente", factura.getCliente().nombre.value());
    }

    private List<DomainEvent> history() {
        var event = new PedidoCreado("Borrador");
        return List.of(event);
    }
}
