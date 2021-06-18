package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.Modelo;
import co.com.sofka.reto.factura.values.VehiculoID;

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
