package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.factura.Factura;
import co.com.sofka.reto.factura.command.CrearFactura;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFactura> crearFacturaRequestCommand) {
        var command = crearFacturaRequestCommand.getCommand();
        var factura = new Factura(command.getFacturaID(), command.getFecha(), command.getValorTotal());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
