package pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import pedido.commands.AgregarAsesor;
import pedido.values.AsesorId;
import pedido.values.Nombre;

public class AgregarAsesorUseCase extends UseCase<RequestCommand<AgregarAsesor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarAsesor> agregarAsesorRequestCommand) {

        var command = agregarAsesorRequestCommand.getCommand();

        var pedido =  Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.agregarAsesor(command.getNombre());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
