package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Fecha implements ValueObject<String> {
    private final String Fecha;

    public Fecha(){
        this.Fecha = Objects.requireNonNull(dateandhours());
    }

    public String dateandhours() {
        Fecha dateandhours = new Fecha();
        SimpleDateFormat Format = new SimpleDateFormat("YYYY/MM/DD '-' HH:mm:ss");
        return Format.format(dateandhours);
    }

    public String value(){
        return Fecha;
    }
}

