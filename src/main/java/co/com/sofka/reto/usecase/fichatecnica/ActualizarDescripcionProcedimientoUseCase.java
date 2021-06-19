package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.commands.ActualizarDescripcionProcedimiento;

public class ActualizarDescripcionProcedimientoUseCase extends UseCase<RequestCommand<ActualizarDescripcionProcedimiento>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionProcedimiento> actualizarDescripcionProcedimientoRequestCommand) {
        var command = actualizarDescripcionProcedimientoRequestCommand.getCommand();
        var fichatecnica = FichaTecnica.from(command.getFichaTecnicaID(), retrieveEvents());

        fichatecnica.actualizarDescripcionProcedimiento(command.getProcedimientoID(), command.getDescripcionProcedimiento());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));
    }
}
