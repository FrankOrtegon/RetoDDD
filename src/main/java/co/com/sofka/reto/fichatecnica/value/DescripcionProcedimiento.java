package co.com.sofka.reto.fichatecnica.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionProcedimiento implements ValueObject<String> {

    private final String value;

    public DescripcionProcedimiento(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescripcionProcedimiento that = (DescripcionProcedimiento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
