package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.command.CrearFactura;
import co.com.sofka.reto.factura.events.FacturaCreada;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Fecha;
import co.com.sofka.reto.factura.values.ValorTotal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearFacturaUseCaseTest {

    private CrearFacturaUseCase crearFacturaUseCase;
    private DomainEventRepository repository;


    @BeforeEach
    public void setup() {

        crearFacturaUseCase = new CrearFacturaUseCase();
        repository =mock(DomainEventRepository.class);
        crearFacturaUseCase.addRepository(repository);
    }

    @Test
    public void crearFacturaHappyPath() {

        var command = new CrearFactura(
                FacturaID.of("24"),
                new Fecha(18, 06, 2021),
                new ValorTotal(15000.0)
        );




        var response = UseCaseHandler.getInstance().syncExecutor(
                crearFacturaUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        List<DomainEvent> events = response.getDomainEvents();

        FacturaCreada facturaCreada = (FacturaCreada) events.get(0);
        //Assertions.assertEquals("24", facturaCreada.getFacturaID().value());
        Assertions.assertEquals(18, 06, 2021, facturaCreada.getFecha().value());
        Assertions.assertEquals(15000.0, facturaCreada.getValorTotal().value());

    }
}
