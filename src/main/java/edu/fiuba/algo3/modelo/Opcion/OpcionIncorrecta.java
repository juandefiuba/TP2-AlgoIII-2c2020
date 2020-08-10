package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionIncorrecta implements Opcion{
    LinkedList<Jugador> jugadoresQueEligieronEstaOpcion;

    public OpcionIncorrecta() {
        jugadoresQueEligieronEstaOpcion = new LinkedList<>();
    }

    @Override
    public void agregarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {
    }

    @Override
    public void agregarJugadorQueLaEligio(Jugador jugador) {
        this.jugadoresQueEligieronEstaOpcion.add(jugador);
    }


    @Override
    public void validarOpcion(Pregunta pregunta) {
        pregunta.calificarRespuesta(new RespondeMal());
    }

}
