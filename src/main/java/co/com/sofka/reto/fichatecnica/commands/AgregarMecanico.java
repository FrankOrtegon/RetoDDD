package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.MecanicoID;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

public class AgregarMecanico implements Command {

    private final FichaTecnicaID fichaTecnicaID;
    private final MecanicoID mecanicoID;
    private final Nombre nombre;
    private final Telefono telefono;

    public AgregarMecanico(FichaTecnicaID fichaTecnicaID, MecanicoID mecanicoID, Nombre nombre, Telefono telefono) {
        this.mecanicoID = mecanicoID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fichaTecnicaID = fichaTecnicaID;
    }

    public MecanicoID getMecanicoID() {
        return mecanicoID;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }
}
