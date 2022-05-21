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
import pedido.commands.AgregarAsesor;
import pedido.commands.AgregarServicio;
import pedido.events.AsesorCreado;
import pedido.events.PedidoCreado;
import pedido.events.ServicioCreado;
import pedido.values.Nombre;
import pedido.values.PedidoId;
import pedido.values.Precio;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarServicioUseCaseTest {

    @InjectMocks
    private AgregarServicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnServicioHappyPass(){

        //arrange
        PedidoId pedidoId = PedidoId.of("0001");
         String nombre = "Recoleccion y Entrega";
         Double precioKm = 1000.0;
         Precio precioBase = new Precio(7000.0);
         String descripcion = "Servicio con dos tareas una para recoger y otra para entregar";
        var command = new AgregarServicio(pedidoId, nombre, precioKm, precioBase, descripcion);

        when(repository.getEventsBy("0001")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getPedidoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (ServicioCreado)events.get(0);
        Assertions.assertEquals("Servicio con dos tareas una para recoger y otra para entregar", event.getDescripcion());
    }


    private List<DomainEvent> history() {
        var event = new PedidoCreado("Borrador");
      //  event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
