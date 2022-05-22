package factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import factura.commands.CrearFactura;
import factura.events.FacturaCreada;
import factura.values.ClienteId;
import factura.values.FacturaId;
import factura.values.Identificacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pedido.CrearPedidoUseCase;
import pedido.commands.CrearPedido;
import pedido.events.PedidoCreado;
import pedido.values.Nombre;
import pedido.values.PedidoId;

public class CrearFacturaUseCaseTest {

    private CrearFacturaUseCase useCase;

    @BeforeEach
    public void setup(){useCase = new CrearFacturaUseCase(); }

    @Test
    public void crearFacturaHappyPass(){
        //arr
        FacturaId facturaId = FacturaId.of("Fact1");

        Nombre nombreCliente = new Nombre("Nombre Cliente");
        Identificacion identificacion = new Identificacion("123456789","Cedula");
        Cliente cliente  = new Cliente(new ClienteId(),nombreCliente,identificacion);


        var command = new CrearFactura(facturaId,cliente);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //ass
        var facturaCreada = (FacturaCreada)events.get(0);
        Assertions.assertEquals("Fact1",facturaCreada.aggregateRootId());
    }
}
