package co.com.sofka.reto.factura.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.factura.values.Descuento;
import co.com.sofka.reto.factura.values.MedioPagoID;

import java.util.Objects;

public class MedioPago extends Entity<MedioPagoID> {
    private Descuento descuento;

    public MedioPago(MedioPagoID medioPagoID, Descuento descuento) {
        super(medioPagoID);
        this.descuento = descuento;
    }

    public void agregarDescuento(Descuento descuento) {
        this.descuento = Objects.requireNonNull(descuento);
    }

    public Descuento descuento() {
        return descuento;
    }
}
