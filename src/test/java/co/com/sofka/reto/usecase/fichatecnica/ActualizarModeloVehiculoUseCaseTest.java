package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.ActualizarModeloVehiculo;
import co.com.sofka.reto.fichatecnica.event.ModeloVehiculoActualizado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.Modelo;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarModeloVehiculoUseCaseTest {

    private ActualizarModeloVehiculoUseCase actualizarModeloVehiculoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    private void setup() {
        actualizarModeloVehiculoUseCase = new ActualizarModeloVehiculoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarModeloVehiculoUseCase.addRepository(repository);
    }

    @Test
    public void actualizarModeloVehiculoHappyPath() {
        var command = new ActualizarModeloVehiculo(
                FichaTecnicaID.of("123"),
                VehiculoID.of("345"),
                new Modelo("2020")
        );

        when(repository.getEventsBy("123")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(actualizarModeloVehiculoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        ModeloVehiculoActualizado modeloVehiculoActualizado = (ModeloVehiculoActualizado) events.get(0);

        Assertions.assertEquals("2020", modeloVehiculoActualizado.getModelo().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new ModeloVehiculoActualizado(VehiculoID.of("345"), new Modelo("2019"))
        );
    }
}
