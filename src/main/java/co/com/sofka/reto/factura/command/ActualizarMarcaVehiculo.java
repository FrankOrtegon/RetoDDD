package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.Marca;
import co.com.sofka.reto.factura.values.VehiculoID;

public class ActualizarMarcaVehiculo implements Command {
    private final FacturaID facturaID;
    private final VehiculoID vehiculoID;
    private final Marca marca;

    public ActualizarMarcaVehiculo(FacturaID facturaID, VehiculoID vehiculoID, Marca marca) {
        this.facturaID = facturaID;
        this.vehiculoID = vehiculoID;
        this.marca = marca;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Marca getMarca() {
        return marca;
    }
}
