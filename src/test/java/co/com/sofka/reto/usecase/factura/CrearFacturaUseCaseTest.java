package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.command.CrearFactura;
import co.com.sofka.reto.factura.entity.Cliente;
import co.com.sofka.reto.factura.events.FacturaCreada;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Fecha;
import co.com.sofka.reto.factura.values.ValorTotal;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class CrearFacturaUseCaseTest {

    private CrearFacturaUseCase crearFacturaUseCase;



    @BeforeEach
    public void setup() {
        crearFacturaUseCase = new CrearFacturaUseCase();
    }

    @Test
    public void crearFacturaHappyPath() {
        var command = new CrearFactura(
                FacturaID.of("24"),
                new Fecha(19, 06, 2021),
                new ValorTotal(15000.0),
                new Cliente(
                        new ClienteID("1"),
                        new Nombre("Juan"),
                        new Telefono("123456"))
        );

        var response = UseCaseHandler.getInstance().syncExecutor(
                crearFacturaUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        List<DomainEvent> events = response.getDomainEvents();

        FacturaCreada facturaCreada = (FacturaCreada) events.get(0);
        Assertions.assertEquals(19, 06, 2021, facturaCreada.getFecha().value());
        Assertions.assertEquals(15000.0, facturaCreada.getValorTotal().value());
        Assertions.assertEquals("Juan", facturaCreada.getCliente().nombre().value());
        Assertions.assertEquals("123456", facturaCreada.getCliente().telefono().value());

    }
}
