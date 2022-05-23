package factura;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import factura.events.FacturaCreada;
import factura.events.PedidoAgregado;
import factura.values.ClienteId;
import factura.values.FacturaId;
import factura.values.Identificacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pedido.events.PedidoCreado;
import pedido.events.ServicioCreado;
import pedido.values.Nombre;
import pedido.values.PedidoId;
import pedido.values.Precio;
import pedido.values.ServicioId;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoAgregadoUseCaseTest {

    @InjectMocks
    private PedidoAgregadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void pedidoAgregadoHappyPass(){
        //Arr
        FacturaId facturaId = FacturaId.of("Fact1");
        var pedidoId = PedidoId.of("Pedido1");
        var command = new PedidoAgregado(pedidoId,facturaId);

        when(repository.getEventsBy("Fact1")).thenReturn(history());
        useCase.addRepository(repository);

        //Act

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(facturaId.value())
                .syncExecutor(useCase,new TriggeredEvent<>(command))
                .orElseThrow()
                .getDomainEvents();


        //Ass
        var pedido = (PedidoAgregado)events.get(0);
        System.out.println(pedido.getAggregateName());
        Assertions.assertEquals("Pedido1",pedido.getPedidoId().value());

    }

    private List<DomainEvent> history() {
        FacturaId facturaId = new FacturaId("Fact1");
    PedidoId PedidoId  = new PedidoId("Pedido1");
        Nombre nombreCliente = new Nombre("Nombre Cliente");
        Identificacion identificacion = new Identificacion("123456789","Cedula");
        Cliente cliente  = new Cliente(ClienteId.of("Cliente1"),nombreCliente,identificacion);

        String nombreServicio = "Recoleccion y Entrega";
        Double precioKm = 1000.0;
        Precio precioBase = new Precio(7000.0);
        String descripcion = "Servicio con dos tareas una para recoger y otra para entregar";

        return List.of(
                new PedidoCreado("Borrador"),
                new ServicioCreado(ServicioId.of("servicio1"),nombreServicio,precioKm,precioBase,descripcion),
                new FacturaCreada(PedidoId,cliente,facturaId)
        );
    }
}
