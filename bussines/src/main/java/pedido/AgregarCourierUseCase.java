package pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import pedido.commands.AgregarCourier;


public class AgregarCourierUseCase extends UseCase<RequestCommand<AgregarCourier>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarCourier> agregarCourierRequestCommand) {

        var command = agregarCourierRequestCommand.getCommand();

        var pedido =  Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.agregarCourier(command.getNombre(),command.getVehiculo());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
