package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.Estado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;

public class FichaTecnicaCreada extends DomainEvent {
    private final Estado estado;
    private final FichaTecnicaID fichaTecnicaID;

    public FichaTecnicaCreada(FichaTecnicaID fichaTecnicaID,Estado estado) {
        super("tallercarros.fichatecnica.fichatecnicacreada");
        this.estado = estado;
        this.fichaTecnicaID = fichaTecnicaID;
    }

    public Estado getEstado() {
        return estado;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }
}
