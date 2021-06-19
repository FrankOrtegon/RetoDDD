package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.ActualizarEstado;

public class ActualizarEstadoUseCase extends UseCase<RequestCommand<ActualizarEstado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstado> actualizarEstadoRequestCommand) {
        var commmand = actualizarEstadoRequestCommand.getCommand();
        var fichatecnica = FichaTecnica.from(commmand.getFichaTecnicaID(), retrieveEvents());

        fichatecnica.actualizarEstado(commmand.getFichaTecnicaID(), commmand.getEstado());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));
    }
}
