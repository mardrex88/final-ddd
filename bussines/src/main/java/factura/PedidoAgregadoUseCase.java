package factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import factura.events.PedidoAgregado;

public class PedidoAgregadoUseCase extends UseCase<TriggeredEvent<PedidoAgregado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PedidoAgregado> pedidoAgregadoTriggeredEvent) {

        var command = pedidoAgregadoTriggeredEvent.getDomainEvent();

        var factura = Factura.from(command.getFacturaId(),repository().getEventsBy(command.getFacturaId().value()));

        factura.agregarPedidoAFactura(command.getPedidoId(),command.getFacturaId());


        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
