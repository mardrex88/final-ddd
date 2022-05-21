package tarea;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import tarea.commands.AgregarContacto;
import tarea.commands.AgregarDestino;


public class AgregarDestinoUseCase extends UseCase<RequestCommand<AgregarDestino>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDestino> agregarDestinoRequestCommand) {

        var command = agregarDestinoRequestCommand.getCommand();

        var tarea =  Tarea.from(command.getTareaId(),repository().getEventsBy(command.getTareaId().value()));
        tarea.agregarDestino(
                command.getDireccion(),
                command.getCoordenadas()
        );


        emit().onResponse(new ResponseEvents(tarea.getUncommittedChanges()));
    }
}
