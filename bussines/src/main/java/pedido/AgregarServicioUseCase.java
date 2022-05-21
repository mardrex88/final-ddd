package pedido;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import pedido.commands.AgregarAsesor;
import pedido.commands.AgregarServicio;
import pedido.values.Precio;

public class AgregarServicioUseCase extends UseCase<RequestCommand<AgregarServicio>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarServicio> agregarServicioRequestCommand) {

        var command = agregarServicioRequestCommand.getCommand();

        var pedido =  Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.agregarServicio(command.getNombre(),command.getPrecioKm(), command.getPrecioBase(), command.getDescripcion());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
