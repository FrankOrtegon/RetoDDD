package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.CambiarTelefonoMecanico;

public class CambiarTelefonoMecanicoUseCase extends UseCase<RequestCommand<CambiarTelefonoMecanico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarTelefonoMecanico> cambiarTelefonoMecanicoRequestCommand) {
        var command = cambiarTelefonoMecanicoRequestCommand.getCommand();
        var fichatecnica = FichaTecnica.from(command.getFichaTecnicaID(), retrieveEvents());

        fichatecnica.cambiarTelefonoMecanico(command.getMecanicoID(),command.getTelefono());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));
    }
}
