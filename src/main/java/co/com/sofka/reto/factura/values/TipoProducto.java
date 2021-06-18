package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoProducto implements ValueObject<String> {
    private final String value;

    public TipoProducto(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("Este campo no puede estar vacio");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoProducto that = (TipoProducto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
