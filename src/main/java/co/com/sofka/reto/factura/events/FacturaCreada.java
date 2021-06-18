package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Fecha;
import co.com.sofka.reto.factura.values.ValorTotal;

public class FacturaCreada extends DomainEvent {
    private final FacturaID facturaID;
    private final Fecha fecha;
    private final ValorTotal valorTotal;

    public FacturaCreada(FacturaID facturaID, Fecha fecha, ValorTotal valorTotal) {
        super("tallercarros.factura.facturacreada");
        this.facturaID = facturaID;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
