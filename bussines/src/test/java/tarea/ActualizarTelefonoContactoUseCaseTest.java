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
import tarea.commands.ActualizarTelefonoContacto;
import tarea.commands.AgregarContacto;
import tarea.events.ContactoCreado;
import tarea.events.TareaCreada;
import tarea.events.TelefonoContactoActualizado;
import tarea.values.ContactoId;
import tarea.values.TareaId;
import tarea.values.Telefono;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarTelefonoContactoUseCaseTest {

    @InjectMocks
    private ActualizarTelefonoContactoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarTelefonoContactoHappyPass(){

        TareaId tareaId = TareaId.of("tarea1");
        ContactoId contactoId = ContactoId.of("contact1");
        Telefono nuevoTelefono = new Telefono("3000000000"); //este seria el nuevo telefono

        var command = new ActualizarTelefonoContacto(tareaId,contactoId,nuevoTelefono);

        when(repository.getEventsBy("tarea1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTareaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (TelefonoContactoActualizado)events.get(0);
        Assertions.assertEquals("3000000000", event.getTelefono().value());
    }


    private List<DomainEvent> history() {
        var event = new TareaCreada("Borrador");

          var event2 = new ContactoCreado(
                ContactoId.of("Contact1"),
                new Telefono("3503656565"),
                "nombre del Contacto"
                );

        event.setAggregateRootId("xxxxx");
        return List.of(event,event2);
    }
}
