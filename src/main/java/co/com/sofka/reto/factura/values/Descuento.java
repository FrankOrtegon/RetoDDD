package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.reto.fichatecnica.value.ValorProcedimiento;

import java.util.Objects;

public class Descuento implements ValueObject<Double> {
    private final Double value;

    public Descuento(Double value) {
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
        Descuento that = (Descuento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

