package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.command.ActualizarValorTotal;
import co.com.sofka.reto.factura.entity.Cliente;
import co.com.sofka.reto.factura.events.FacturaCreada;
import co.com.sofka.reto.factura.events.ValorTotalActualizado;
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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarValorTotalUseCaseTest {
    private ActualizarValorTotalUseCase actualizarValorTotalUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarValorTotalUseCase = new ActualizarValorTotalUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarValorTotalUseCase.addRepository(repository);
    }

    @Test
    public void actualizarValorTotalHappyPath() {
        var facturaID = FacturaID.of("123");
        var event = new ValorTotalActualizado(
                FacturaID.of("123"),
                new ValorTotal(123000.0)
        );
        event.setAggregateRootId(facturaID.value());

        when(repository.getEventsBy("123")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(actualizarValorTotalUseCase, new TriggeredEvent<>(event))
                .orElseThrow();
        var events = response.getDomainEvents();
        ValorTotalActualizado valorTotalActualizado = (ValorTotalActualizado) events.get(0);
        Assertions.assertEquals(123000.0, valorTotalActualizado.getValorTotal().value());
    }

    public List<DomainEvent> events() {
        return List.of(
                new FacturaCreada(FacturaID.of("1234"),new Fecha(19,06,2021), new ValorTotal(1000.0), new Cliente(
                        ClienteID.of("1256"),
                        new Nombre("Daniel"),
                        new Telefono("12353465")
                ))
        );
    }
}
