package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.value.Estado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;

public class FichaTecnicaCreada extends DomainEvent {
    private final MecanicoID mecanicoID;
    private final Vehiculo vehiculo;
    private final Estado estado;
    private final FichaTecnicaID fichaTecnicaID;

    public FichaTecnicaCreada(FichaTecnicaID fichaTecnicaID, Estado estado, MecanicoID mecanicoID, Vehiculo vehiculo) {
        super("tallercarros.fichatecnica.fichatecnicacreada");
        this.mecanicoID = mecanicoID;
        this.estado = estado;
        this.fichaTecnicaID = fichaTecnicaID;
        this.vehiculo = vehiculo;
    }

    public Estado getEstado() {
        return estado;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public MecanicoID getMecanico() {
        return mecanicoID;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
