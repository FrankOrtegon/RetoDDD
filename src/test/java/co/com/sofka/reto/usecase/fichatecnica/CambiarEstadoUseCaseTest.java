package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.ActualizarEstado;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.event.EstadoActualizado;
import co.com.sofka.reto.fichatecnica.event.FichaTecnicaCreada;
import co.com.sofka.reto.fichatecnica.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CambiarEstadoUseCaseTest {

    private CambiarEstadoUseCase cambiarEstadoUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        cambiarEstadoUseCase = new CambiarEstadoUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarEstadoUseCase.addRepository(repository);
    }

    @Test
    public void cambiarEstadoHappyPath() {
        var fichaTecnicaID = FichaTecnicaID.of("123");
        var event = new EstadoActualizado(
                FichaTecnicaID.of("123"),
                new Estado("Que bueno")
        );
        event.setAggregateRootId(fichaTecnicaID.value());

        when(repository.getEventsBy("123")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(cambiarEstadoUseCase, new TriggeredEvent<>(event))
                .orElseThrow();

        var events = response.getDomainEvents();
        EstadoActualizado estadoActualizado = (EstadoActualizado) events.get(0);
        Assertions.assertEquals("Que bueno",estadoActualizado.getEstado().value());
    }

    public List<DomainEvent> events() {
        return List.of(
                new FichaTecnicaCreada(FichaTecnicaID.of("1234"),
                        new Estado("No enciende"),
                        MecanicoID.of("324"),
                        new Vehiculo(
                                VehiculoID.of("23"),
                                new Modelo("2020"),
                                new Marca("Toyota"),
                                new Placa("123ADS"))
                ));
    }
}
