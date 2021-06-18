package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.Identity;

public class MedioPagoID extends Identity {
    public MedioPagoID() {

    }

    public MedioPagoID(String id) {
        super(id);
    }

    public static MedioPagoID of(String id) {
        return new MedioPagoID();
    }
}
