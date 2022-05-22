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
import pedido.commands.AgregarTarea;
import pedido.events.AsesorCreado;
import pedido.events.PedidoCreado;
import pedido.events.TareaCreada;
import pedido.values.PedidoId;
import tarea.values.TareaId;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarTareaUseCaseTest {

    @InjectMocks
    private AgregarTareaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarTareaHappyPass(){
        //arrange
        PedidoId pedidoId = PedidoId.of("0001");
        String estado = "Borrador";
        TareaId tareaId = new TareaId("Tarea1");

        var command = new AgregarTarea(pedidoId,tareaId,estado);


        when(repository.getEventsBy("0001")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TareaCreada)events.get(0);
        Assertions.assertEquals("Tarea1", event.getTareaId().value());


    }

    private List<DomainEvent> history() {
        var event = new PedidoCreado("Borrador");
        //  event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
