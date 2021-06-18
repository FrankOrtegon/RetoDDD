package co.com.sofka.reto.factura;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.factura.entity.MedioPago;
import co.com.sofka.reto.factura.events.*;

public class FacturaChange extends EventChange {

    public FacturaChange(Factura factura) {

        apply((FacturaCreada event) -> {
            factura.valorTotal = event.getValorTotal();
            factura.facturaID = event.getFacturaID();
            factura.fecha = event.getFecha();
        });

        apply((DescuentoMedioPagoAgregado event) -> {
            factura.medioPagoID = event.getMedioPagoID();
             var numDescuentos = factura.descuento;
             if(numDescuentos.equals(2)) {
                 throw new IllegalArgumentException("No se puede agregar mas de dos descuentos a una misma factura");
             }
             factura.medioPagos.add(new MedioPago(
                     event.getMedioPagoID(),
                     event.getDescuento()
             ));
        });

        apply((MarcaVehiculoActualizado event) -> {
         factura.vehiculo.actualizarMarca(event.getMarca());
        });

        apply((ModeloVehiculoActualizado event) -> {
            factura.vehiculo.actualizarModelo(event.getModelo());
        });

        apply((NombreClienteActualizado event) -> {
            factura.cliente.actualizarNombre(event.getNombre());
        });

        apply((TelefonoClienteCambiado event) -> {
            factura.cliente.cambiarTelefono(event.getTelefono());
        });

        apply((ValorTotalCalculado event) -> {
            factura.valorTotal = event.getValorTotal();
        });

    }
}
