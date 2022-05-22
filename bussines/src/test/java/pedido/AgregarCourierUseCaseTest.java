package pedido;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pedido.commands.AgregarCourier;
import pedido.events.CourierCreado;
import pedido.events.PedidoCreado;
import pedido.values.Nombre;
import pedido.values.PedidoId;
import pedido.values.Vehiculo;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarCourierUseCaseTest {

    @InjectMocks
    private AgregarCourierUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnCourierHappyPass(){

        //arrange
        PedidoId pedidoId = PedidoId.of("0001");
        Nombre nombre = new Nombre("Courier 1");
        Vehiculo vehiculo = new Vehiculo("XXX215","Rojo");
        var command = new AgregarCourier(pedidoId,nombre,vehiculo);

        when(repository.getEventsBy("0001")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (CourierCreado)events.get(0);
        Assertions.assertEquals("Courier 1", event.getNombre().value());
    }


    private List<DomainEvent> history() {
        var event = new PedidoCreado("Borrador");
      //  event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
