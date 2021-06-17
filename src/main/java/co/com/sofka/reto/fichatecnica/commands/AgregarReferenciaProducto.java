package co.com.sofka.reto.fichatecnica.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.fichatecnica.value.FichaTecnicaID;
import co.com.sofka.reto.fichatecnica.value.ProductoID;
import co.com.sofka.reto.fichatecnica.value.TipoProducto;

public class AgregarReferenciaProducto implements Command {

    private final FichaTecnicaID fichaTecnicaID;
    private final ProductoID productoID;
    private final TipoProducto tipoProducto;

    public AgregarReferenciaProducto(FichaTecnicaID fichaTecnicaID, ProductoID productoID, TipoProducto tipoProducto) {
        this.fichaTecnicaID = fichaTecnicaID;
        this.productoID = productoID;
        this.tipoProducto = tipoProducto;
    }

    public FichaTecnicaID getFichaTecnicaID() {
        return fichaTecnicaID;
    }

    public ProductoID getProductoID() {
        return productoID;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }
}
