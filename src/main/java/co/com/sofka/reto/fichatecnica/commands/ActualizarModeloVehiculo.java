package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.Modelo;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;

public class ActualizarModeloVehiculo implements Command {
    private final FichaTecnicaID fichaTecnicaID;
    private final VehiculoID vehiculoID;
    private final Modelo modelo;

    public ActualizarModeloVehiculo(FichaTecnicaID fichaTecnicaID, VehiculoID vehiculoID, Modelo modelo) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.vehiculoID = vehiculoID;
        this.modelo = modelo;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Modelo getModelo() {
        return modelo;
    }
}

