package co.com.sofka.reto.factura;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.factura.entity.MedioPago;
import co.com.sofka.reto.factura.events.*;


import java.util.ArrayList;
import java.util.Set;

public class FacturaChange extends EventChange {

    public FacturaChange(Factura factura) {

        apply((FacturaCreada event) -> {
            factura.valorTotal = event.getValorTotal();
            factura.facturaID = event.getFacturaID();
            factura.fecha = event.getFecha();
            factura.productos = new ArrayList<>();
        });

        apply((DescuentoMedioPagoAgregado event) -> {
            factura.medioPagoID = event.getMedioPagoID();
             var numDescuentos = factura.descuento;
             if(numDescuentos.equals(2)) {
                 throw new IllegalArgumentException("No se puede agregar mas de dos descuentos a una misma factura");
             }
             factura.medioPagos = (Set<MedioPago>) new MedioPago(
                     event.getMedioPagoID(),
                     event.getDescuento()
             );
        });

        apply((NombreClienteActualizado event) -> {
            factura.nombre = event.getNombre();
        });

        apply((TelefonoClienteCambiado event) -> {
            factura.cliente.cambiarTelefono(event.getTelefono());
        });

        apply((ValorTotalAgregado event) -> {
            factura.valorTotal = event.getValorTotal();
        });


        apply((ReferenciaProductoAgregada event) ->{
            var producto = factura.getProductoPorID(event.getProductoID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el producto"));
            producto.agregarReferenciaProducto(event.getTipoProducto());
        });

    }
}
