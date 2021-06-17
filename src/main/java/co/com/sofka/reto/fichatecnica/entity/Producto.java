package co.com.sofka.reto.fichatecnica.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.fichatecnica.value.ProductoID;
import co.com.sofka.reto.fichatecnica.value.TipoProducto;
import co.com.sofka.reto.fichatecnica.value.ValorProducto;

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
