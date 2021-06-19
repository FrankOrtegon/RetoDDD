package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.ValorTotal;

public class ValorTotalAgregado extends DomainEvent {
    private final FacturaID facturaID;
    private final ValorTotal valorTotal;

    public ValorTotalAgregado(FacturaID facturaID, ValorTotal valorTotal) {
        super("tallercarros.factura.valortotalcalculado");
        this.facturaID = facturaID;
        this.valorTotal = valorTotal;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public ValorTotal getValorTotal() {
        return valorTotal;
    }
}
