package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

public class MecanicoAgregado extends DomainEvent {
    private final MecanicoID mecanicoID;
    private final Nombre nombre;
    private final Telefono telefono;

    public MecanicoAgregado(MecanicoID mecanicoID, Nombre nombre, Telefono telefono) {
        super("tallercarros.fichatecnica.mecanicoagregado");
        this.mecanicoID = mecanicoID;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public MecanicoID mecanicoID() {
        return mecanicoID;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Telefono telefono() {
        return telefono;
    }
}
