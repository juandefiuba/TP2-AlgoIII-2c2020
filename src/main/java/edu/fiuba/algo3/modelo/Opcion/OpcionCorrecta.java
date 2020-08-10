package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionCorrecta implements Opcion{

    LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;

    public OpcionCorrecta() {
        jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
    }

    @Override
    public void agregarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {
        opcionesCorrectas.add(this);
    }

    @Override
    public void validarOpcion(Pregunta pregunta) {
        pregunta.calificarRespuesta(new RespondeBien());
    }

}
