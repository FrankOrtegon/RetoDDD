package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.Estado;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;

public class CrearFichaTecnica implements Command {

    private final FichaTecnicaID fichaTecnicaID;
    private final Estado estado;

    public CrearFichaTecnica(FichaTecnicaID fichaTecnicaID, Estado estado) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.estado = estado;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public Estado getEstado() {
        return estado;
    }
}
