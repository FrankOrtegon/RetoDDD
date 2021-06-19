package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.Estado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;

import java.util.UUID;

public class EstadoActualizado extends DomainEvent {


    private final FichaTecnicaID fichaTecnicaID;
    private final Estado estado;
    public EstadoActualizado(FichaTecnicaID fichaTecnicaID, Estado estado) {
        super("tallercarros.fichatecnica.estadoactualizado");
        this.fichaTecnicaID = fichaTecnicaID;
        this.estado = estado;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public Estado getEstado() {
        return estado;
    }
}
