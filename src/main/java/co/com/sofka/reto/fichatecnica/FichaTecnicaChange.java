package co.com.sofka.reto.fichatecnica;

import co.com.sofka.domain.generic.EventChange;

import co.com.sofka.reto.fichatecnica.entity.Mecanico;
import co.com.sofka.reto.fichatecnica.event.*;


import java.util.HashSet;


public class FichaTecnicaChange extends EventChange {

    public FichaTecnicaChange(FichaTecnica fichaTecnica) {

        apply((FichaTecnicaCreada event ) -> {
            fichaTecnica.estado = event.getEstado();
            fichaTecnica.fichaTecnicaID = event.getFichaTecnicaID();

        });

        apply((EstadoActualizado event) -> {
            fichaTecnica.estado = event.getEstado();
        });

        apply((DescripcionProcedimientoActualizada event) -> {
            fichaTecnica.procedimientos = event.getdescripcionProcedimiento();
        });

        apply((MecanicoAgregado event) -> {
            fichaTecnica.mecanicoID = event.mecanicoID();

        });

        apply((NombreMecanicoActualizado event) -> {
            fichaTecnica.nombre = event.getNombre();
        });

        apply((TelefonoMecanicoCambiado event) -> {
          fichaTecnica.telefono = event.getTelefono();
        });

        apply((MarcaVehiculoActualizado event) -> {
            fichaTecnica.marca = event.getMarca();
        });

        apply((ModeloVehiculoActualizado event) -> {
            fichaTecnica.modelo = event.getModelo();
        });


    }
}
