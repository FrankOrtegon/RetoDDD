package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.ActualizarNombreMecanico;

public class ActualizarNombreMecanicoUseCase extends UseCase<RequestCommand<ActualizarNombreMecanico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreMecanico> actualizarNombreMecanicoRequestCommand) {
        var command = actualizarNombreMecanicoRequestCommand.getCommand();
        var fichatecnica = FichaTecnica.from(command.getFichaTecnicaID(), retrieveEvents());

        fichatecnica.actualizarNombreMecanico(command.getMecanicoID(), command.getNombre());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));

    }
}
