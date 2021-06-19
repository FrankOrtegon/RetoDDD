package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.command.ActualizarNombreCliente;
import co.com.sofka.reto.factura.entity.Cliente;
import co.com.sofka.reto.factura.events.FacturaCreada;
import co.com.sofka.reto.factura.events.NombreClienteActualizado;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Fecha;
import co.com.sofka.reto.factura.values.ValorTotal;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarNombreClienteUseCaseTest {

    private ActualizarNombreClienteUseCase actualizarNombreClienteUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {

        actualizarNombreClienteUseCase = new ActualizarNombreClienteUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarNombreClienteUseCase.addRepository(repository);
    }

    @Test
    public void actualizarNombreClienteHappyPath() {
        var command = new ActualizarNombreCliente(
                FacturaID.of("1234"),
                ClienteID.of("1256"),
                new Nombre("Frank")
        );

        when(repository.getEventsBy("1234")).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1234")
                .syncExecutor(
                        actualizarNombreClienteUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();
        NombreClienteActualizado nombreClienteActualizado = (NombreClienteActualizado) events.get(0);

        Assertions.assertEquals("Frank",nombreClienteActualizado.getNombre().value());
        Assertions.assertEquals("tallercarros.factura.nombreclienteactualizado", nombreClienteActualizado.type);
    }

    private List<DomainEvent> events() {
        return List.of(
                new FacturaCreada(FacturaID.of("1234"),new Fecha(18,06,2021), new ValorTotal(1000.0), new Cliente(
                        ClienteID.of("1256"),
                        new Nombre("Daniel"),
                        new Telefono("12353465")
                ))
        );
    }

}
