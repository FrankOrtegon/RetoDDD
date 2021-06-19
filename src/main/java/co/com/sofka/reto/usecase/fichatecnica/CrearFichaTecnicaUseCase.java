package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.CrearFichaTecnica;

public class CrearFichaTecnicaUseCase extends UseCase<RequestCommand<CrearFichaTecnica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearFichaTecnica> crearFichaTecnicaRequestCommand) {
        var command = crearFichaTecnicaRequestCommand.getCommand();
        var fichatecnica = new FichaTecnica(command.getFichaTecnicaID(), command.getEstado(), command.getMecanicoID(), command.getVehiculo());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));
    }
}
