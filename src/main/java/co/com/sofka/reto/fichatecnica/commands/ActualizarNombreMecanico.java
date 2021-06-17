package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Nombre;

public class ActualizarNombreMecanico implements Command {

    private final FichaTecnicaID fichaTecnicaID;
    private final MecanicoID mecanicoID;
    private final Nombre nombre;

    public ActualizarNombreMecanico(FichaTecnicaID fichaTecnicaID, MecanicoID mecanicoID, Nombre nombre) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.mecanicoID = mecanicoID;
        this.nombre = nombre;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public MecanicoID getMecanicoID() {
        return mecanicoID;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
