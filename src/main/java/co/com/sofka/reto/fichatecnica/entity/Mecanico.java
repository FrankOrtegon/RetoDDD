package co.com.sofka.reto.fichatecnica.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

import java.util.Objects;

public class Mecanico extends Entity<MecanicoID> {

    private Nombre nombre;
    private Telefono telefono;

    public Mecanico(MecanicoID mecanicoID, Nombre nombre, Telefono telefono) {
        super(mecanicoID);
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

