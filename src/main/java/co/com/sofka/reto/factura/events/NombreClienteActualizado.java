package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.valuegeneric.Nombre;

public class NombreClienteActualizado extends DomainEvent {

    private final ClienteID clienteID;
    private final Nombre nombre;

    public NombreClienteActualizado(ClienteID clienteID, Nombre nombre) {
        super("tallercarros.factura.nombreclienteactualizado");
        this.clienteID = clienteID;
        this.nombre = nombre;
    }

    public ClienteID getClienteID() {
        return clienteID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
