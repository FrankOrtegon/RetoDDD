package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.valuegeneric.Telefono;

public class TelefonoClienteCambiado extends DomainEvent {

    private final ClienteID clienteID;
    private final Telefono telefono;

    public TelefonoClienteCambiado(ClienteID clienteID, Telefono telefono) {
        super("tallercarros.factura.telefonoclienteactualizado");
        this.clienteID = clienteID;
        this.telefono = telefono;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
