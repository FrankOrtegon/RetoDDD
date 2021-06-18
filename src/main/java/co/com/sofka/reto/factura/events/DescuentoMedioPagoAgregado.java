package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.Descuento;
import co.com.sofka.reto.factura.values.MedioPagoID;

import java.util.UUID;

public class DescuentoMedioPagoAgregado extends DomainEvent {

    private final MedioPagoID medioPagoID;
    private final Descuento descuento;

    public DescuentoMedioPagoAgregado(MedioPagoID medioPagoID, Descuento descuento) {
        super("tallercarros.factura.descuentomediopagoagregado");
        this.medioPagoID = medioPagoID;
        this.descuento = descuento;
    }

    public MedioPagoID getMedioPagoID() {
        return medioPagoID;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
