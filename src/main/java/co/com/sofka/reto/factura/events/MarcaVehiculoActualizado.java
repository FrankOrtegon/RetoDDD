package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.Marca;
import co.com.sofka.reto.factura.values.VehiculoID;

public class MarcaVehiculoActualizado extends DomainEvent {
    private final VehiculoID vehiculoID;
    private final Marca marca;

    public MarcaVehiculoActualizado(VehiculoID vehiculoID, Marca marca) {
        super("tallercarros.factura.marcavehiculoactualizado");
        this.vehiculoID = vehiculoID;
        this.marca = marca;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Marca getMarca() {
        return marca;
    }
}
