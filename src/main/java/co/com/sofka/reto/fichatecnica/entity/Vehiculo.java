package co.com.sofka.reto.fichatecnica.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.fichatecnica.value.Marca;
import co.com.sofka.reto.fichatecnica.value.Modelo;
import co.com.sofka.reto.fichatecnica.value.Placa;
import co.com.sofka.reto.fichatecnica.value.VehiculoID;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoID> {
    private Modelo modelo;
    private Marca marca;
    private Placa placa;

    public Vehiculo(VehiculoID vehiculoID, Modelo modelo, Marca marca, Placa placa) {
        super(vehiculoID);
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
    }

    public void actualizarModelo(Modelo modelo) {
        this.modelo = Objects.requireNonNull(modelo);
    }

    public void actualizarMarca(Marca marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    public Modelo modelo() {
        return modelo;
    }

    public Marca marca() {
        return marca;
    }

    public Placa placa() {
        return placa;
    }
}
