package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.factura.Factura;
import co.com.sofka.reto.factura.command.ActualizarNombreCliente;

public class ActualizarNombreClienteUseCase extends UseCase<RequestCommand<ActualizarNombreCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCliente> actualizarNombreClienteRequestCommand) {
        var command = actualizarNombreClienteRequestCommand.getCommand();
        var factura = Factura.from(command.getFacturaID(), retrieveEvents(command.getFacturaID().value()));

        factura.actualizarNombreCliente(command.getClienteID(), command.getNombre());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }

}
