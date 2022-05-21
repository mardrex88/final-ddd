package tarea;


import tarea.commands.CrearTarea;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;


public class CrearTareaUseCase extends UseCase<RequestCommand<CrearTarea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearTarea> crearTareaRequestCommand) {
        var command = crearTareaRequestCommand.getCommand();

        var tarea = new Tarea(command.getTareaId(),"borrador");

        emit().onResponse(new ResponseEvents(tarea.getUncommittedChanges()));
    }
}
