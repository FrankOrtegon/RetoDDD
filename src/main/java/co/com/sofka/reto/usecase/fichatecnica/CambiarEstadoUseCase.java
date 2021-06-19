package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.fichatecnica.FichaTecnica;
import co.com.sofka.reto.fichatecnica.event.EstadoActualizado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;

public class CambiarEstadoUseCase extends UseCase<TriggeredEvent<EstadoActualizado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<EstadoActualizado> estadoActualizadoTriggeredEvent) {
        var event = estadoActualizadoTriggeredEvent.getDomainEvent();
        var fichatecnica = FichaTecnica.from(FichaTecnicaID.of(event.aggregateRootId()), retrieveEvents());

        fichatecnica.actualizarEstado(event.getFichaTecnicaID(),event.getEstado());
        emit().onResponse(new ResponseEvents(fichatecnica.getUncommittedChanges()));
    }
}
