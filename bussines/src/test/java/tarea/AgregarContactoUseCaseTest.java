package tarea;

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
import pedido.AgregarAsesorUseCase;
import pedido.events.AsesorCreado;
import pedido.events.PedidoCreado;
import tarea.commands.AgregarContacto;
import tarea.events.ContactoCreado;
import tarea.events.TareaCreada;
import tarea.values.TareaId;
import tarea.values.Telefono;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarContactoUseCaseTest {

    @InjectMocks
    private AgregarContactoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnContactoHappyPass(){
        TareaId tareaId = TareaId.of("tarea1");
        Telefono telefono = new Telefono("325161323");
        String nombre = "Nombre Contacto";

        var command = new AgregarContacto(tareaId,telefono,nombre);

        when(repository.getEventsBy("tarea1")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTareaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (ContactoCreado)events.get(0);
        Assertions.assertEquals("Nombre Contacto", event.getNombre());
    }


    private List<DomainEvent> history() {
        var event = new TareaCreada("Borrador");
          return List.of(event);
    }
}
