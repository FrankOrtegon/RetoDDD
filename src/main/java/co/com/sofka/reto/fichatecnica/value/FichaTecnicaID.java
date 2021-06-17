package co.com.sofka.reto.fichatecnica.value;

import co.com.sofka.domain.generic.Identity;

public class FichaTecnicaID extends Identity {
    public FichaTecnicaID() {

    }

    public FichaTecnicaID(String id) {
        super(id);
    }

    public static FichaTecnicaID of(String id) {
        return new FichaTecnicaID();
    }
}
