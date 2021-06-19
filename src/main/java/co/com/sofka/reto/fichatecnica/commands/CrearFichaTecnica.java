package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.entity.Mecanico;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.value.Estado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;

public class CrearFichaTecnica implements Command {

    private final MecanicoID mecanico;
    private final Vehiculo vehiculo;
    private final FichaTecnicaID fichaTecnicaID;
    private final Estado estado;

    public CrearFichaTecnica(FichaTecnicaID fichaTecnicaID, Estado estado, MecanicoID mecanico, Vehiculo vehiculo) {
        this.mecanico = mecanico;
        this.fichaTecnicaID = fichaTecnicaID;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public Estado getEstado() {
        return estado;
    }

    public MecanicoID getMecanicoID() {
        return mecanico;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
