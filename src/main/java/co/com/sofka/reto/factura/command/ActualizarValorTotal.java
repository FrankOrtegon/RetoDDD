package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.ValorTotal;

public class ActualizarValorTotal implements Command {
    private final FacturaID facturaID;
    private final ValorTotal valorTotal;

    public ActualizarValorTotal(FacturaID facturaID, ValorTotal valorTotal) {
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
