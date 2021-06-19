package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.commands.ActualizarDescripcionProcedimiento;
import co.com.sofka.reto.fichatecnica.event.DescripcionProcedimientoActualizada;
import co.com.sofka.reto.fichatecnica.event.FichaTecnicaCreada;
import co.com.sofka.reto.fichatecnica.value.DescripcionProcedimiento;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.ProcedimientoID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarDescripcionProcedimientoUseCaseTest {
    private ActualizarDescripcionProcedimientoUseCase actualizarDescripcionProcedimientoUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarDescripcionProcedimientoUseCase = new ActualizarDescripcionProcedimientoUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarDescripcionProcedimientoUseCase.addRepository(repository);
    }

    @Test
    public void actualizarDescripcionProcedimientoHappyPath() {
        var command = new ActualizarDescripcionProcedimiento(
                FichaTecnicaID.of("1234"),
                ProcedimientoID.of("12"),
                new DescripcionProcedimiento("con toda :)")
        );

        when(repository.getEventsBy("1234")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1234").syncExecutor(
                        actualizarDescripcionProcedimientoUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        DescripcionProcedimientoActualizada descripcionProcedimientoActualizada = (DescripcionProcedimientoActualizada) events.get(0);

        Assertions.assertEquals("Con toda :)", descripcionProcedimientoActualizada.getdescripcionProcedimiento().value());

    }

    private List<DomainEvent> events() {
        return List.of(
                new DescripcionProcedimientoActualizada(ProcedimientoID.of("12"), new DescripcionProcedimiento("Fuerte todo"))
        );
    }
}
