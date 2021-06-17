package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Nombre;

public class NombreMecanicoActualizado extends DomainEvent {
    private final MecanicoID mecanicoID;
    private final Nombre nombre;

    public NombreMecanicoActualizado(MecanicoID mecanicoID, Nombre nombre) {
        super("tallercarros.fichatecnica.nombremecanicoactualizado");
        this.mecanicoID = mecanicoID;
        this.nombre = nombre;
    }

    public MecanicoID getMecanicoID() {
        return mecanicoID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
