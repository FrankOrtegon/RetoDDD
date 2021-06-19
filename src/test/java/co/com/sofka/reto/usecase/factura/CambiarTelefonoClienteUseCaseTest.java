package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.command.CambiarTelefonoCliente;
import co.com.sofka.reto.factura.events.TelefonoClienteCambiado;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.valuegeneric.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CambiarTelefonoClienteUseCaseTest {
    private CambiarTelefonoClienteUseCase cambiarTelefonoClienteUseCase;

    @Mock
    public DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        cambiarTelefonoClienteUseCase = new CambiarTelefonoClienteUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarTelefonoClienteUseCase.addRepository(repository);
    }

    @Test
    public void cambiarTelefonoClienteHappyPath() {
        var command = new CambiarTelefonoCliente(
                FacturaID.of("123"),
                ClienteID.of("321"),
                new Telefono("123456")
        );

        when(repository.getEventsBy("123")).thenReturn(events());

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("123")
                .syncExecutor(cambiarTelefonoClienteUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        TelefonoClienteCambiado telefonoClienteCambiado = (TelefonoClienteCambiado) events.get(0);
        Assertions.assertEquals("123456", telefonoClienteCambiado.getTelefono().value());
    }

    public List<DomainEvent> events() {
        return List.of(
                new TelefonoClienteCambiado(ClienteID.of("321"), new Telefono("123456"))
        );
    }
}
