package tarea;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import tarea.commands.AgregarContacto;


public class AgregarContactoUseCase extends UseCase<RequestCommand<AgregarContacto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarContacto> agregarContactoRequestCommand) {

        var command = agregarContactoRequestCommand.getCommand();

        var tarea =  Tarea.from(command.getTareaId(),repository().getEventsBy(command.getTareaId().value()));

        tarea.agregarContacto(
                       command.getTelefono(),
                        command.getNombre()
        );

        emit().onResponse(new ResponseEvents(tarea.getUncommittedChanges()));
    }
}
