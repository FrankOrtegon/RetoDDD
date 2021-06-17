package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.Estado;

import java.util.UUID;

public class EstadoActualizado extends DomainEvent {

    private final Estado estado;
    public EstadoActualizado(Estado estado) {
        super("tallercarros.fichatecnica.estadoactualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
