package tarea;

import tarea.commands.CrearTarea;
import tarea.events.TareaCreada;
import tarea.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearTareaUseCaseTest {

    private CrearTareaUseCase useCase;

    @BeforeEach
    public void setup(){useCase = new CrearTareaUseCase(); }

    @Test
    public void crearTareahappyPass(){
        //arr
        TareaId tareaId = TareaId.of("0001");

        var command = new CrearTarea(
                tareaId,
                new Contacto(
                        new ContactoId(),
                        new Telefono("300764964"),
                        "Pepito Perez"),
                new Destino(new DestinoId(),new Direccion("Boston con el centro"),new Coordenadas(-75.000,24.752)),
                "Creada");

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ass
        var tareaCreada = (TareaCreada)events.get(0);
        Assertions.assertEquals("0001",tareaCreada.aggregateRootId());
    }
}
