package factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

import factura.events.FacturaCreada;
import pedido.Pedido;

public class FacturaCreadaUseCase extends UseCase<TriggeredEvent<FacturaCreada>,ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<FacturaCreada> facturaCreadaTriggeredEvent) {

        var command = facturaCreadaTriggeredEvent.getDomainEvent();

        var pedido =  Pedido.from(command.getPedidoId(),repository().getEventsBy(command.getPedidoId().value()));

        pedido.crearFactura(command.getPedidoId(),command.getCliente());

        emit().onResponse(new ResponseEvents(pedido.getUncommittedChanges()));
    }
}
