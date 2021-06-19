package co.com.sofka.reto.usecase.fichatecnica;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.factura.events.FacturaCreada;
import co.com.sofka.reto.fichatecnica.commands.CrearFichaTecnica;
import co.com.sofka.reto.fichatecnica.entity.Mecanico;
import co.com.sofka.reto.fichatecnica.entity.Vehiculo;
import co.com.sofka.reto.fichatecnica.event.FichaTecnicaCreada;
import co.com.sofka.reto.fichatecnica.value.*;
import co.com.sofka.reto.valuegeneric.Nombre;
import co.com.sofka.reto.valuegeneric.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CrearFichaTecnicaUseCaseTest {

    private CrearFichaTecnicaUseCase crearFichaTecnicaUseCase;

    @BeforeEach
    public void setup(){
        crearFichaTecnicaUseCase = new CrearFichaTecnicaUseCase();
    }

    @Test
    public void crearFichaTecnicaHappyPath() {
        var command = new CrearFichaTecnica(
          FichaTecnicaID.of("1234"),
          new Estado("No enciende"),
          MecanicoID.of("324"),
          new Vehiculo(
                  VehiculoID.of("23"),
                  new Modelo("2020"),
                  new Marca("Toyota"),
                  new Placa("123ADS"))
        );
       var response = UseCaseHandler.getInstance().syncExecutor(
               crearFichaTecnicaUseCase, new RequestCommand<>(command)
       ).orElseThrow();


        var events = response.getDomainEvents();

        FichaTecnicaCreada fichaTecnicaCreada = (FichaTecnicaCreada) events.get(0);

        Assertions.assertEquals("No enciende", fichaTecnicaCreada.getEstado().value());
        Assertions.assertEquals("Toyota", fichaTecnicaCreada.getVehiculo().marca().value());
        Assertions.assertEquals("2020",fichaTecnicaCreada.getVehiculo().modelo().value());
        Assertions.assertEquals("123ADS", fichaTecnicaCreada.getVehiculo().placa().value());
    }
}
