package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;
import edu.fiuba.algo3.modelo.Puntos.PuntoEstatico;


import java.util.Iterator;
import java.util.LinkedList;

public class PreguntaMultipleChoiceClasico extends Pregunta {

    public PreguntaMultipleChoiceClasico(LinkedList<Opcion> opciones) {
        super(opciones);
   }

    public Puntaje puntuarJugador(Jugador jugador) {
        LinkedList<Opcion> respuestaDelJugador = new LinkedList<>();
        LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador = new LinkedList<>();
        Puntaje puntajeDelJugador = new Puntaje();

        opciones.forEach(opcion -> opcion.obtenerLRespuestaDelJugador(jugador, respuestaDelJugador));
        opciones.forEach(opcion -> opcion.agregarOpcionesCorrectasNoElegidas(jugador, opcionesCorrectasNoElegidasPorElJugador));
        Iterator iter = respuestaDelJugador.iterator();

        while (iter.hasNext()){
            Opcion opcionAuxiliar = (Opcion)iter.next();
            puntajeDelJugador = this.calificarOpcion(opcionAuxiliar, puntajeDelJugador);
        }

        Iterator iter2 = opcionesCorrectasNoElegidasPorElJugador.iterator();

        while (iter2.hasNext()){
            iter2.next();
            puntajeDelJugador = this.calificarOpcion(new OpcionIncorrecta(), puntajeDelJugador);
        }

        return puntajeDelJugador;
    }

    public Puntaje calificarOpcion(Opcion opcion, Puntaje puntajeDelJugador){
        return opcion.validarOpcion(this, puntajeDelJugador);
    }

    public Puntaje calificarOpcion(OpcionCorrecta opcion, Puntaje puntajeDeRespuesta){
        puntajeDeRespuesta.sumarPuntos(new PuntoEstatico());
        return puntajeDeRespuesta;
    }

    public Puntaje calificarOpcion(OpcionIncorrecta opcion, Puntaje puntajeDeRespuesta){
        puntajeDeRespuesta = new PuntajeNeutro();
        return puntajeDeRespuesta;
    }
}