package co.com.sofka.reto.factura.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.factura.values.ClienteID;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

import java.util.Objects;

public class Cliente extends Entity<ClienteID> {

    private Nombre nombre;
    private Telefono telefono;

    public Cliente(ClienteID clienteID, Nombre nombre, Telefono telefono) {
        super(clienteID);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void cambiarTelefono(Telefono telefono) {

        this.telefono = Objects.requireNonNull(telefono);
    }

    public void actualizarNombre(Nombre nombre) {

        this.nombre = Objects.requireNonNull(nombre);
    }
    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }
}
