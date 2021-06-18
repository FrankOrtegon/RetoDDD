package co.com.sofka.reto.factura.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.values.ProductoID;
import co.com.sofka.reto.factura.values.TipoProducto;

public class ReferenciaProductoAgregada extends DomainEvent {
    private final ProductoID productoID;
    private final TipoProducto tipoProducto;

    public ReferenciaProductoAgregada(ProductoID productoID, TipoProducto tipoProducto) {
            super("tallercarros.fichatecnica.referenciaproductoagregada");
            this.productoID = productoID;
            this.tipoProducto = tipoProducto;

        }

    public ProductoID getProductoID() {
        return productoID;
    }


    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }


}

