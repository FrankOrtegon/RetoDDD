package co.com.sofka.reto.usecase.factura;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.factura.Factura;
import co.com.sofka.reto.factura.events.ValorTotalActualizado;
import co.com.sofka.reto.factura.values.FacturaID;

public class ActualizarValorTotalUseCase extends UseCase<TriggeredEvent<ValorTotalActualizado>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ValorTotalActualizado> valorTotalActualizadoTriggeredEvent) {
        var event = valorTotalActualizadoTriggeredEvent.getDomainEvent();
        var factura = Factura.from(FacturaID.of(event.aggregateRootId()), retrieveEvents());

        factura.actualizarValorTotal(event.getFacturaID(), event.getValorTotal());
        emit().onResponse(new ResponseEvents(factura.getUncommittedChanges()));
    }
}
