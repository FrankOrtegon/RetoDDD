package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.reto.fichatecnica.value.Estado;

import java.util.Objects;

public class Modelo implements ValueObject<String> {
    private final String value;

    public Modelo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El estado no puede estar vacio");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo that = (Modelo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}