package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.fichatecnica.value.Modelo;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;

public class ActualizarModeloVehiculo {
    private final FacturaID facturaID;
    private final VehiculoID vehiculoID;
    private final Modelo modelo;

    public ActualizarModeloVehiculo(FacturaID facturaID, VehiculoID vehiculoID, Modelo modelo) {
        this.facturaID = facturaID;
        this.vehiculoID = vehiculoID;
        this.modelo = modelo;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Modelo getModelo() {
        return modelo;
    }
}

