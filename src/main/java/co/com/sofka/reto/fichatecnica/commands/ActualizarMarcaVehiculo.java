package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.Marca;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;

public class ActualizarMarcaVehiculo implements Command {
    private final FichaTecnicaID fichaTecnicaID;
    private final VehiculoID vehiculoID;
    private final Marca marca;

    public ActualizarMarcaVehiculo(FichaTecnicaID fichaTecnicaID, VehiculoID vehiculoID, Marca marca) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.vehiculoID = vehiculoID;
        this.marca = marca;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public VehiculoID getVehiculoID() {
        return vehiculoID;
    }

    public Marca getMarca() {
        return marca;
    }


}
