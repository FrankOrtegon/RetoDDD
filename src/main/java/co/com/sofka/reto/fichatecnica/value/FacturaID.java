package co.com.sofka.reto.fichatecnica.value;

import co.com.sofka.domain.generic.Identity;

public class FacturaID extends Identity {

    public FacturaID() {

    }

    public FacturaID(String id) {
        super(id);
    }

    public static FacturaID of(String id) {
        return new FacturaID();
    }
}
