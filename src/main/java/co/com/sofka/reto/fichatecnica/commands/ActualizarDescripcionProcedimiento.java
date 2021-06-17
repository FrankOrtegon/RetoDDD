package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.DescripcionProcedimiento;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.ProcedimientoID;

public class ActualizarDescripcionProcedimiento implements Command {

    private final FichaTecnicaID fichaTecnicaID;
    private final ProcedimientoID procedimientoID;
    private final DescripcionProcedimiento descripcionProcedimiento;

    public ActualizarDescripcionProcedimiento(FichaTecnicaID fichaTecnicaID, ProcedimientoID procedimientoID, DescripcionProcedimiento descripcionProcedimiento) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.procedimientoID = procedimientoID;
        this.descripcionProcedimiento = descripcionProcedimiento;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public ProcedimientoID getProcedimientoID() {
        return procedimientoID;
    }

    public DescripcionProcedimiento getDescripcionProcedimiento() {
        return descripcionProcedimiento;
    }
}
