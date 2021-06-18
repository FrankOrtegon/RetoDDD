package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.valuegeneric.Telefono;

public class CambiarTelefonoCliente implements Command {
        private final FacturaID facturaID;
        private final ClienteID clienteID;
        private final Telefono telefono;

        public CambiarTelefonoCliente(FacturaID facturaID, ClienteID clienteID, Telefono telefono) {
            this.facturaID = facturaID;
            this.clienteID = clienteID;
            this.telefono = telefono;
        }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Telefono getTelefono() {
            return telefono;
        }
}
