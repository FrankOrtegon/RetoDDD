package co.com.sofka.reto.fichatecnica;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.fichatecnica.entity.Mecanico;
import co.com.sofka.reto.fichatecnica.entity.Procedimiento;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.event.*;
import co.com.sofka.reto.fichatecnica.value.*;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;

import java.util.*;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class FichaTecnica extends AggregateEvent<FichaTecnicaID> {

    public VehiculoID vehiculoID;
    public Marca marca;
    public FichaTecnicaID fichaTecnicaID;
    public Vehiculo vehiculo;
    protected Estado estado;
    protected Set<Mecanico> mecanico;
    protected Set<Procedimiento> procedimientos;
    protected FacturaID facturaID;


    public FichaTecnica(FichaTecnicaID fichaTecnicaID, Estado estado) {
        super(fichaTecnicaID);
        appendChange(new FichaTecnicaCreada(fichaTecnicaID, estado)).apply();
    }

    private FichaTecnica(FichaTecnicaID fichaTecnicaID) {
        super(fichaTecnicaID);
        subscribe(new FichaTecnicaChange(this));
    }

    public static FichaTecnica from(FichaTecnicaID fichaTecnicaID, List<DomainEvent> events) {
        var fichaTecnica = new FichaTecnica(fichaTecnicaID);
        events.forEach(fichaTecnica::applyEvent);
        return fichaTecnica;
    }

    public Optional<Mecanico> getMecanicoPorID(MecanicoID mecanicoID) {
        return mecanico()
                .stream()
                .filter(mecanico -> mecanico.identity().equals(mecanicoID))
                .findFirst();
    }

    public Optional<Procedimiento> getProcedimientoPorID(ProcedimientoID procedimientoID) {
        return procedimientos()
                .stream()
                .filter(procedimiento -> procedimiento.identity().equals(procedimientoID))
                .findFirst();
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

    public void actualizarEstado(Estado estado) {
        Objects.requireNonNull(estado);
        appendChange(new EstadoActualizado(estado)).apply();
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

    public Set<Mecanico> mecanico() {
        return mecanico;
    }

    public Set<Procedimiento> procedimientos() {
        return procedimientos;
    }

    public FacturaID facturaID() {
        return facturaID;
    }

    public Vehiculo vehiculo() {
        return vehiculo;
    }

}
