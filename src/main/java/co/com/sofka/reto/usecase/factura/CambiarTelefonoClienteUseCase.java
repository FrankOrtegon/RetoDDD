package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.factura.Factura;
import co.com.sofka.reto.factura.command.CambiarTelefonoCliente;

public class CambiarTelefonoClienteUseCase extends UseCase<RequestCommand<CambiarTelefonoCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoCliente> cambiarTelefonoClienteRequestCommand) {
        var command = cambiarTelefonoClienteRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaID(), retrieveEvents());

        factura.cambiarTelefonoCliente(command.getClienteID(),command.getTelefono());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
