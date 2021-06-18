package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Fecha;
import co.com.sofka.reto.factura.values.ValorTotal;

public class CrearFactura implements Command {

    private final FacturaID facturaID;
    private final Fecha fecha;
    private final ValorTotal valorTotal;

    public CrearFactura(FacturaID facturaID, Fecha fecha, ValorTotal valorTotal) {
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
