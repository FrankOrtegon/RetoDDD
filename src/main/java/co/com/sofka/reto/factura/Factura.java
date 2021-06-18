package co.com.sofka.reto.factura;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.entity.Cliente;
import co.com.sofka.reto.factura.entity.MedioPago;
import co.com.sofka.reto.factura.entity.Vehiculo;
import co.com.sofka.reto.factura.events.*;
import co.com.sofka.reto.factura.values.*;


import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

import java.util.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Factura extends AggregateEvent<FacturaID> {

    public MedioPagoID medioPagoID;
    public Descuento descuento;
    public VehiculoID vehiculoID;
    public Marca marca;
    protected FacturaID facturaID;
    protected Fecha fecha;
    protected ValorTotal valorTotal;
    protected Cliente cliente;
    protected Set<MedioPago> medioPagos;
    protected Vehiculo vehiculo;

    public Factura(FacturaID facturaID, Fecha fecha, ValorTotal valorTotal) {
        super(facturaID);
        appendChange(new FacturaCreada(facturaID, fecha, valorTotal)).apply();
    }

    private Factura(FacturaID facturaID) {
        super(facturaID);
        subscribe(new FacturaChange(this));
    }

    public static Factura from(FacturaID facturaID, List<DomainEvent> events) {
        var factura = new Factura(facturaID);
        events.forEach(factura::applyEvent);
        return factura;
    }

    public Optional<MedioPago> getMedioPagoPorID(MedioPagoID medioPagoID) {
        return medioPagos()
                .stream()
                .filter(medioPago -> medioPago.identity().equals(medioPagoID))
                .findFirst();
    }

    public void actualizarMarcaVehiculo(VehiculoID vehiculoID, Marca marca){
        Objects.requireNonNull(vehiculoID);
        Objects.requireNonNull(marca);
        appendChange(new MarcaVehiculoActualizado(vehiculoID, marca)).apply();
    }

    public void actualizarModeloVehiculo(VehiculoID vehiculoID, Modelo modelo) {
        Objects.requireNonNull(vehiculoID);
        Objects.requireNonNull(modelo);
        appendChange(new ModeloVehiculoActualizado(vehiculoID,modelo)).apply();
    }

    public void actualizarNombreCliente(ClienteID clienteID, Nombre nombre) {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(nombre);
        appendChange(new NombreClienteActualizado(clienteID,nombre)).apply();
    }

    public void agregarDescuentoMedioPago(MedioPagoID medioPagoID, Descuento descuento) {
        Objects.requireNonNull(medioPagoID);
        Objects.requireNonNull(descuento);
        appendChange(new DescuentoMedioPagoAgregado(medioPagoID,descuento)).apply();
    }

    public void calcularValorTotal(FacturaID facturaID, ValorTotal valorTotal) {
        Objects.requireNonNull(facturaID);
        Objects.requireNonNull(valorTotal);
        appendChange(new ValorTotalCalculado(facturaID,valorTotal)).apply();
    }

    public void cambiarTelefonoCliente(ClienteID clienteID, Telefono telefono)  {
        Objects.requireNonNull(clienteID);
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoClienteCambiado(clienteID,telefono)).apply();
    }


    public FacturaID facturaID() {
        return facturaID;
    }

    public Fecha fecha() {
        return fecha;
    }

    public ValorTotal valorTotal() {
        return valorTotal;
    }

    public Cliente cliente() {
        return cliente;
    }

    public Set<MedioPago> medioPagos() {
        return medioPagos;
    }

    public Vehiculo vehiculo() {
        return vehiculo;
    }
}
