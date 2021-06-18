package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.Modelo;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;

public class ModeloVehiculoActualizado extends DomainEvent {
    private final VehiculoID vehiculoID;
    private final Modelo modelo;

    public ModeloVehiculoActualizado(VehiculoID vehiculoID, Modelo modelo) {
        super("tallercarros.factura.modelovehiculoactualizado");
        this.vehiculoID = vehiculoID;
        this.modelo = modelo;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Modelo getModelo() {
        return modelo;
    }
}
