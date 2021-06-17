package co.com.sofka.reto.fichatecnica.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.fichatecnica.event.DescripcionProcedimientoActualizada;
import co.com.sofka.reto.fichatecnica.value.DescripcionProcedimiento;
import co.com.sofka.reto.fichatecnica.value.ProcedimientoID;
import co.com.sofka.reto.fichatecnica.value.ValorProcedimiento;

import java.util.Objects;

public class Procedimiento extends Entity<ProcedimientoID> {

    private DescripcionProcedimiento descripcionProcedimiento;
    private ValorProcedimiento valorProcedimiento;

    public Procedimiento(ProcedimientoID procedimientoID, DescripcionProcedimiento descripcionProcedimiento, ValorProcedimiento valorProcedimiento) {
        super(procedimientoID);
        this.descripcionProcedimiento = descripcionProcedimiento;
        this.valorProcedimiento = valorProcedimiento;
    }

    public void actualizarDescripcion(ProcedimientoID descripcionProcedimiento) {
        this.descripcionProcedimiento = Objects.requireNonNull(descripcionProcedimiento);
    }

    public DescripcionProcedimiento descripcionProcedimiento() {
        return descripcionProcedimiento;
    }

    public ValorProcedimiento valorProcedimiento() {
        return valorProcedimiento;
    }
}
