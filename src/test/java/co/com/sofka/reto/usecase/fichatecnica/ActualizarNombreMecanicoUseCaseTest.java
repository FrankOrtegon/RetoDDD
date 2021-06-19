package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.ActualizarNombreMecanico;
import co.com.sofka.reto.fichatecnica.event.MecanicoAgregado;
import co.com.sofka.reto.fichatecnica.event.NombreMecanicoActualizado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarNombreMecanicoUseCaseTest {

    private ActualizarNombreMecanicoUseCase actualizarNombreMecanicoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {

        actualizarNombreMecanicoUseCase = new ActualizarNombreMecanicoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarNombreMecanicoUseCase.addRepository(repository);
    }

    @Test
    public void actualizarNombreMecanicoHappyPath() {
        var command = new ActualizarNombreMecanico(
                FichaTecnicaID.of("12"),
                MecanicoID.of("123"),
                new Nombre("Omar")
        );

        when(repository.getEventsBy("12")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("12").syncExecutor(
                        actualizarNombreMecanicoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        NombreMecanicoActualizado nombreMecanicoActualizado = (NombreMecanicoActualizado) events.get(0);

        Assertions.assertEquals("Omar", nombreMecanicoActualizado.getNombre().value());
        Assertions.assertEquals("tallercarros.fichatecnica.nombremecanicoactualizado", nombreMecanicoActualizado.type);

    }

    private List<DomainEvent> events() {
        return List.of(
                new MecanicoAgregado(MecanicoID.of("123"), new Nombre("Juan"), new Telefono("133244")),
                new NombreMecanicoActualizado(MecanicoID.of("123"), new Nombre("Daniel"))
        );
    }
}
