package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Telefono;

public class CambiarTelefonoMecanico implements Command {

    private final FichaTecnicaID fichaTecnicaID;
    private final MecanicoID mecanicoID;
    private final Telefono telefono;

    public CambiarTelefonoMecanico(FichaTecnicaID fichaTecnicaID, MecanicoID mecanicoID, Telefono telefono) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.mecanicoID = mecanicoID;
        this.telefono = telefono;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public MecanicoID getMecanicoID() {
        return mecanicoID;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}

