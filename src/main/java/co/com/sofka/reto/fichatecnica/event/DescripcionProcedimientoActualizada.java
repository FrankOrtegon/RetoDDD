package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.DescripcionProcedimiento;
import co.com.sofka.reto.fichatecnica.value.ProcedimientoID;

public class DescripcionProcedimientoActualizada extends DomainEvent {
    private final ProcedimientoID procedimientoID;
    private final DescripcionProcedimiento descripcionProcedimiento;

    public DescripcionProcedimientoActualizada(ProcedimientoID procedimientoID, DescripcionProcedimiento descripcionProcedimiento) {
        super("tallercarros.fichatecnica.descripcionprocedimientoactualizada");
        this.procedimientoID = procedimientoID;
        this.descripcionProcedimiento = descripcionProcedimiento;
    }

    public ProcedimientoID getProcedimientoID() {
        return procedimientoID;
    }

    public DescripcionProcedimiento getdescripcionProcedimiento() {
        return descripcionProcedimiento;
    }
}
