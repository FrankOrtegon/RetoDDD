package co.com.sofka.reto.fichatecnica.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.value.ProductoID;
import co.com.sofka.reto.fichatecnica.value.TipoProducto;
import co.com.sofka.reto.fichatecnica.value.ValorProducto;

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

