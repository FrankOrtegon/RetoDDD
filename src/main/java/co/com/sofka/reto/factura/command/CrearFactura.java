package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.entity.Cliente;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Fecha;
import co.com.sofka.reto.factura.values.ValorTotal;

public class CrearFactura implements Command {

    private final Cliente cliente;
    private final FacturaID facturaID;
    private final Fecha fecha;
    private final ValorTotal valorTotal;

    public CrearFactura(FacturaID facturaID, Fecha fecha, ValorTotal valorTotal, Cliente cliente) {
        this.facturaID = facturaID;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }
}
