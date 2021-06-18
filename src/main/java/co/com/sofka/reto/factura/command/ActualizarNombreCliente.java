package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.valuegeneric.Nombre;

public class ActualizarNombreCliente implements Command {
    private final FacturaID facturaID;
    private final ClienteID clienteID;
    private final Nombre nombre;

    public ActualizarNombreCliente(FacturaID facturaID, ClienteID clienteID, Nombre nombre) {
        this.facturaID = facturaID;
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
