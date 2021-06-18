package co.com.sofka.reto.factura.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


public class Fecha implements ValueObject<String> {

    private final LocalDate date;
    private final String value;

    public Fecha(int day, int month, int year) {
        try{
            date = LocalDate.of(year,month,day);
            if(date.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("Fecha es anterior a la actual");            }
        }catch (DateTimeException ex){
            throw  new IllegalArgumentException(ex.getMessage());
        }
        value = generarFormato();
    }

    private String generarFormato(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha = (Fecha) o;
        return Objects.equals(date, fecha.date) && Objects.equals(value, fecha.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, value);
    }
}
