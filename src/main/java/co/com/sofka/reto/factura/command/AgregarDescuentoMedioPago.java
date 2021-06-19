package co.com.sofka.reto.factura.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.factura.values.Descuento;
import co.com.sofka.reto.factura.values.FacturaID;
import co.com.sofka.reto.factura.values.MedioPagoID;

public class AgregarDescuentoMedioPago implements Command {
    private final FacturaID facturaID;
    private final MedioPagoID medioPagoID;
    private final Descuento descuento;

    public AgregarDescuentoMedioPago(FacturaID facturaID, MedioPagoID medioPagoID, Descuento descuento) {
        this.facturaID = facturaID;
        this.medioPagoID = medioPagoID;
        this.descuento = descuento;
    }

    public FacturaID getFacturaID() {
        return facturaID;
    }

    public MedioPagoID getMedioPagoID() {
        return medioPagoID;
    }

    public Descuento getDescuento() {
        return descuento;
    }
}
