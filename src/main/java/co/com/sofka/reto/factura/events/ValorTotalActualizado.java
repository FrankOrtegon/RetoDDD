package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.ValorTotal;

public class ValorTotalActualizado extends DomainEvent implements Command {
    private final FacturaID facturaID;
    private final ValorTotal valorTotal;

    public ValorTotalActualizado(FacturaID facturaID, ValorTotal valorTotal) {
        super("tallercarros.factura.valortotalactualizado");
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
