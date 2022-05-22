package pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import pedido.commands.AgregarTarea;
import tarea.Tarea;

public class AgregarTareaUseCase extends UseCase<RequestCommand<AgregarTarea>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AgregarTarea> agregarTareaRequestCommand) {

        var command = agregarTareaRequestCommand.getCommand();

        var pedido = Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.agregarTarea(command.getTareaId(),command.getEstado());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));


    }
}
