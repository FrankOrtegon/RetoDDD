package co.com.sofka.reto.fichatecnica.value;

import co.com.sofka.domain.generic.Identity;

public class MecanicoID extends Identity {

    public MecanicoID() {

    }

    public MecanicoID(String id) {
        super(id);
    }

    public static MecanicoID of(String id) {
        return new MecanicoID();
    }
}
