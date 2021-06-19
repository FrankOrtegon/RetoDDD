package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.CambiarTelefonoMecanico;
import co.com.sofka.reto.fichatecnica.event.MecanicoAgregado;
import co.com.sofka.reto.fichatecnica.event.TelefonoMecanicoCambiado;
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

public class CambiarTelefonoMecanicoUseCaseTest {

    private CambiarTelefonoMecanicoUseCase cambiarTelefonoMecanicoUseCase;

    @Mock
    public DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        cambiarTelefonoMecanicoUseCase = new CambiarTelefonoMecanicoUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarTelefonoMecanicoUseCase.addRepository(repository);
    }

    @Test
    public void cambiarTelefonoMecanico() {
        var command = new CambiarTelefonoMecanico(
                FichaTecnicaID.of("123"),
                MecanicoID.of("134"),
                new Telefono("3124435456")
        );

        when(repository.getEventsBy("123")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(cambiarTelefonoMecanicoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        TelefonoMecanicoCambiado telefonoMecanicoCambiado = (TelefonoMecanicoCambiado) events.get(0);

        Assertions.assertEquals("3124435456", telefonoMecanicoCambiado.getTelefono().value());
    }

    private List<DomainEvent> events() {
        return List.of(
                new MecanicoAgregado(MecanicoID.of("123"), new Nombre("Juan"), new Telefono("133244"))
        );

    }

}
