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
            fichaTecnica.procedimientos = new HashSet<>();


        });

        apply((EstadoActualizado event) -> {
            fichaTecnica.estado = event.getEstado();
        });

        apply((DescripcionProcedimientoActualizada event) -> {
           var procedimiento = fichaTecnica.getProcedimientoPorID(event.getProcedimientoID())
                   .orElseThrow(() -> new IllegalArgumentException("No se encuentra el procedimiento"));
           procedimiento.actualizarDescripcion(event.getdescripcionProcedimiento());
        });

        apply((MecanicoAgregado event) -> {
            var numMecanico = fichaTecnica.mecanico().size();
            if(numMecanico == 2) {
                throw new IllegalArgumentException("No se puede agregar mas de un mecanico por ficha tecnica");
            }

            fichaTecnica.mecanico.add(new Mecanico(
                    event.mecanicoID(),
                    event.nombre(),
                    event.telefono()
            ));
        });

        apply((NombreMecanicoActualizado event) -> {
            var nombre = fichaTecnica.getMecanicoPorID(event.getMecanicoID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el mecanico"));
            nombre.actualizarNombre(event.getNombre());
        });

        apply((TelefonoMecanicoCambiado event) -> {
            var telefono = fichaTecnica.getMecanicoPorID(event.getMecanicoID())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el mecanico"));
            telefono.cambiarTelefono(event.getTelefono());
        });

        apply((MarcaVehiculoActualizado event) -> {
            fichaTecnica.vehiculo.actualizarMarca(event.getMarca());
        });

        apply((ModeloVehiculoActualizado event) -> {
            fichaTecnica.vehiculo.actualizarModelo(event.getModelo());
        });


    }
}
