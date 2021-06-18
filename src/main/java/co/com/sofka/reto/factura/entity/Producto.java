package co.com.sofka.reto.factura.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.factura.values.ProductoID;
import co.com.sofka.reto.factura.values.TipoProducto;

import java.util.Objects;

public class Producto extends Entity<ProductoID> {

        private TipoProducto tipoProducto;


    public Producto(ProductoID productoID, TipoProducto tipoProducto) {
        super(productoID);
        this.tipoProducto = tipoProducto;

    }

    public void agregarReferenciaProducto(TipoProducto tipoProducto) {
        this.tipoProducto = Objects.requireNonNull(tipoProducto);

    }

    public TipoProducto tipoProducto() {
        return tipoProducto;
    }




}
