package co.com.sofka.reto.fichatecnica.value;

import co.com.sofka.domain.generic.Identity;

public class ProcedimientoID extends Identity {

    public ProcedimientoID() {

    }

    public ProcedimientoID(String id) {
        super(id);
    }

    public static ProcedimientoID of(String id) {
        return new ProcedimientoID();
    }
}
