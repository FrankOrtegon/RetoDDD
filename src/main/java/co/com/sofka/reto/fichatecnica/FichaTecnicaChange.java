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
            fichaTecnica.mecanico = event.mecanicoID();

        });

        apply((NombreMecanicoActualizado event) -> {
            fichaTecnica.nombre = event.getNombre();
        });

        apply((TelefonoMecanicoCambiado event) -> {
          fichaTecnica.telefono = event.getTelefono();
        });

        apply((MarcaVehiculoActualizado event) -> {
            fichaTecnica.vehiculo.actualizarMarca(event.getMarca());
        });

        apply((ModeloVehiculoActualizado event) -> {
            fichaTecnica.vehiculo.actualizarModelo(event.getModelo());
        });


    }
}
