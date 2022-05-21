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
import tarea.commands.AgregarDestino;
import tarea.events.DestinoCreado;
import tarea.events.TareaCreada;
import tarea.values.Coordenadas;
import tarea.values.Direccion;
import tarea.values.TareaId;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgregarDestinoUseCaseTest {

    @InjectMocks
    private AgregarDestinoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUnDestinoHappyPass(){
        TareaId tareaId = TareaId.of("tarea1");
        Direccion direccion = new Direccion("Carrera con calle");
        Coordenadas coordenadas = new Coordenadas(-75.6465664,24.65165165);

        var command = new AgregarDestino(tareaId,direccion,coordenadas);

        when(repository.getEventsBy("tarea1")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTareaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (DestinoCreado)events.get(0);
        Assertions.assertEquals("Carrera con calle", event.getDireccion().value());
    }


    private List<DomainEvent> history() {
        var event = new TareaCreada("Borrador");
          return List.of(event);
    }
}
