package co.com.sofka.reto.fichatecnica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.entity.Mecanico;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.event.*;
import co.com.sofka.reto.fichatecnica.value.*;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

import java.util.*;
import java.util.Objects;

public class FichaTecnica extends AggregateEvent<FichaTecnicaID> {

    public VehiculoID vehiculoID;
    public Marca marca;
    public FichaTecnicaID fichaTecnicaID;
    public Nombre nombre;
    public Telefono telefono;
    public Modelo modelo;
    protected Vehiculo vehiculo;
    protected Estado estado;
    protected MecanicoID mecanicoID;
    protected DescripcionProcedimiento procedimientos;
    protected FacturaID facturaID;


    private FichaTecnica(FichaTecnicaID fichaTecnicaID) {
        super(fichaTecnicaID);
        subscribe(new FichaTecnicaChange(this));
    }

    public FichaTecnica(FichaTecnicaID fichaTecnicaID, Estado estado, MecanicoID mecanico, Vehiculo vehiculo) {
        super(fichaTecnicaID);
        appendChange(new FichaTecnicaCreada(fichaTecnicaID, estado, mecanico, vehiculo)).apply();
    }

    public static FichaTecnica from(FichaTecnicaID fichaTecnicaID, List<DomainEvent> events) {
        var fichaTecnica = new FichaTecnica(fichaTecnicaID);
        events.forEach(fichaTecnica::applyEvent);
        return fichaTecnica;
    }


    public void agregarMecanico(MecanicoID mecanicoID, Nombre nombre, Telefono telefono) {
        Objects.requireNonNull(mecanicoID);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(telefono);
        appendChange(new MecanicoAgregado(mecanicoID, nombre, telefono)).apply();

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

    public void actualizarEstado(FichaTecnicaID fichaTecnicaID, Estado estado) {
        Objects.requireNonNull(estado);
        Objects.requireNonNull(fichaTecnicaID);
        appendChange(new EstadoActualizado(fichaTecnicaID,estado)).apply();
    }


    public void actualizarDescripcionProcedimiento(ProcedimientoID procedimientoID, DescripcionProcedimiento descripcionProcedimiento) {
        Objects.requireNonNull(descripcionProcedimiento);
        appendChange(new DescripcionProcedimientoActualizada(procedimientoID,descripcionProcedimiento)).apply();
    }

    public void cambiarTelefonoMecanico(MecanicoID mecanicoID, Telefono telefono) {
        Objects.requireNonNull(telefono);
        appendChange(new TelefonoMecanicoCambiado(mecanicoID,telefono)).apply();
    }

    public void actualizarNombreMecanico(MecanicoID mecanicoID, Nombre nombre) {
        Objects.requireNonNull(nombre);
        appendChange(new NombreMecanicoActualizado(mecanicoID, nombre)).apply();
    }

    public FichaTecnicaID fichaTecnicaID() {
        return fichaTecnicaID;
    }

    public Estado estado() {
        return estado;
    }

    public MecanicoID mecanicoID() {
        return mecanicoID;
    }

    public DescripcionProcedimiento procedimientos() {
        return procedimientos;
    }

    public FacturaID facturaID() {
        return facturaID;
    }

    public Vehiculo vehiculo() {
        return vehiculo;
    }

}
