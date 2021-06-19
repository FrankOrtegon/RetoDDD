package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.ActualizarMarcaVehiculo;
import co.com.sofka.reto.fichatecnica.event.MarcaVehiculoActualizado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.Marca;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarMarcaVehiculoUseCaseTest {

    private ActualizarMarcaVehiculoUseCase actualizarMarcaVehiculoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarMarcaVehiculoUseCase = new ActualizarMarcaVehiculoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarMarcaVehiculoUseCase.addRepository(repository);
    }

    @Test
    public void actualizarMarcaVehiculoHappyPath() {
        var command = new ActualizarMarcaVehiculo(
                FichaTecnicaID.of("12343"),
                VehiculoID.of("123"),
                new Marca("Toyota")
        );

        when(repository.getEventsBy("12343")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("12343")
                .syncExecutor(actualizarMarcaVehiculoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        MarcaVehiculoActualizado marcaVehiculoActualizado = (MarcaVehiculoActualizado) events.get(0);

        Assertions.assertEquals("Toyota",marcaVehiculoActualizado.getMarca().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new MarcaVehiculoActualizado(VehiculoID.of("123"), new Marca("Renault"))
        );
    }
}
