package co.com.sofka.reto.fichatecnica.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ValorProcedimiento implements ValueObject<Double> {
    private final Double value;

    public ValorProcedimiento(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.equals(0)){
            throw new IllegalArgumentException("El valor del procedimiento no debe estar en blanco");
        }
    }

    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorProcedimiento that = (ValorProcedimiento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}