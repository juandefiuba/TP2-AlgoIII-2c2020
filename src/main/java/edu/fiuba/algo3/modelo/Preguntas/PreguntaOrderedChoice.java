package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opcion.*;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PreguntaOrderedChoice extends Pregunta{

    public PreguntaOrderedChoice(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    @Override
    public Puntaje puntuarJugador(Jugador jugador) {
        this.puntajeDelJugador = new PuntajeValido();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(jugador);
        Iterator iterOpciones = this.opciones.iterator();
        Iterator iterRespuesta = respuestaDelJugador.iterator();
        try {
            while (iterOpciones.hasNext()) {
                if (iterOpciones.next() != iterRespuesta.next()) {
                    this.calificarRespuesta(new RespondeMal());
                }
            }
        }catch (NoSuchElementException nse){
            this.calificarRespuesta(new RespondeMal());
        }
        this.calificarRespuesta(new RespondeBien());
        return this.puntajeDelJugador;
    }

    @Override
    public void calificarRespuesta(RespondeBien calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {
    this.puntajeDelJugador = new PuntajeNulo();
    }
}
