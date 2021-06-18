package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.Identity;

public class VehiculoID extends Identity {

    public VehiculoID() {
    }

    public VehiculoID(String id) {
        super(id);
    }

    public static VehiculoID of(String id) {
        return new VehiculoID();
    }
}
