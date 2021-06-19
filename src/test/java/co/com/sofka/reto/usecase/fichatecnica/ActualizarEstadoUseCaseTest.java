package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.ActualizarEstado;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.event.EstadoActualizado;
import co.com.sofka.reto.fichatecnica.event.FichaTecnicaCreada;
import co.com.sofka.reto.fichatecnica.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarEstadoUseCaseTest {

    private ActualizarEstadoUseCase actualizarEstadoUseCase;

    @Mock
    public DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarEstadoUseCase = new ActualizarEstadoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarEstadoUseCase.addRepository(repository);
    }

    @Test
    public void actualizarEstadoHappyPath() {
        var command = new ActualizarEstado(
                FichaTecnicaID.of("123"),
                new Estado("Sin luces")
        );

        when(repository.getEventsBy("123")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(actualizarEstadoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        EstadoActualizado estadoActualizado = (EstadoActualizado) events.get(0);

        Assertions.assertEquals("Sin luces", estadoActualizado.getEstado().value());
    }

    private List<DomainEvent> events() {
        return  List.of(
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
