package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.ActualizarModeloVehiculo;

public class ActualizarModeloVehiculoUseCase extends UseCase<RequestCommand<ActualizarModeloVehiculo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarModeloVehiculo> actualizarModeloVehiculoRequestCommand) {
        var command = actualizarModeloVehiculoRequestCommand.getCommand();
        var fichatecnica = FichaTecnica.from(command.getFichaTecnicaID(), retrieveEvents());

        fichatecnica.actualizarModeloVehiculo(command.getVehiculoID(), command.getModelo());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));

    }
}
