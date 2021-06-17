package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Telefono;

import java.util.UUID;

public class TelefonoMecanicoCambiado extends DomainEvent {

    private final MecanicoID mecanicoID;
    private final Telefono telefono;

    public TelefonoMecanicoCambiado(MecanicoID mecanicoID, Telefono telefono) {
        super("tallercarros.fichatecnica.telefonomecanicocambiado");
        this.mecanicoID = mecanicoID;
        this.telefono = telefono;
    }

    public MecanicoID getMecanicoID() {
        return mecanicoID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
