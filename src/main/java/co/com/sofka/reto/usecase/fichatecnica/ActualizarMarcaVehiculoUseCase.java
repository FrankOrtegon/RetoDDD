package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.ActualizarMarcaVehiculo;

public class ActualizarMarcaVehiculoUseCase extends UseCase<RequestCommand<ActualizarMarcaVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarMarcaVehiculo> actualizarMarcaVehiculoRequestCommand) {
        var command = actualizarMarcaVehiculoRequestCommand.getCommand();
        var fichatecnica = FichaTecnica.from(command.getFichaTecnicaID(), retrieveEvents());

        fichatecnica.actualizarMarcaVehiculo(command.getVehiculoID(), command.getMarca());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));
    }
}
