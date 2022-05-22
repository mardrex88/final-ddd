package tarea;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import tarea.commands.ActualizarTelefonoContacto;

public class ActualizarTelefonoContactoUseCase extends UseCase<RequestCommand<ActualizarTelefonoContacto>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoContacto> actualizarTelefonoContactoRequestCommand) {

        var command = actualizarTelefonoContactoRequestCommand.getCommand();

        var tarea = Tarea.from(command.getTareaId(),repository().getEventsBy(command.getTareaId().value()));

        tarea.actualizarTelefonoContacto(command.getContactoId(),command.getTelefono());
        emit().onResponse(new ResponseEvents(tarea.getUncommittedChanges()));

    }
}
