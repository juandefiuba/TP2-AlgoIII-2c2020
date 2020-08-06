package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.*;
import edu.fiuba.algo3.modelo2.Puntos.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class PreguntaVerdaderoFalso {

    protected LinkedList<Opcion> opciones;

    public PreguntaVerdaderoFalso(LinkedList<Opcion> opcionesDeLaPregunta) {
        this.opciones = opcionesDeLaPregunta;
    }

    /*public void preguntaguardarRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuesta){
        respuestasDeJugadores.put(Jugador,respuesta);
    }*/

    public Puntaje puntuarJugador(Jugador jugador) {
        Iterator iter = opciones.iterator();
        LinkedList<Opcion> respuestaDelJugador = new LinkedList<>();
        Puntaje puntajeDelJugador = new Puntaje();

        opciones.forEach(opcion -> opcion.obtenerPuntosDelJugador(jugador,respuestaDelJugador));

        iter = respuestaDelJugador.iterator();
        Opcion opcionAuxiliar;
        while (iter.hasNext()){
            opcionAuxiliar = (Opcion)iter.next();
            this.calificarOpcion(opcionAuxiliar,puntajeDelJugador);
        }

        //respuestaDelJugador.forEach(opcion -> puntajeDelJugador.sumarPuntos(this.calificarOpcion(opcion)));



        return puntajeDelJugador;
    }

    public Iterator obtenerOpciones() {
        return opciones.iterator();
    }

    public Puntaje calificarOpcion(Opcion opcion, Puntaje puntajeDelJugador){
        return opcion.validarOpcion(this, puntajeDelJugador);
    }

    public Puntaje calificarOpcion(OpcionCorrecta opcion, Puntaje puntajeDeRespuesta){
      //  Puntaje unPuntajeDeLaOpcionElegida = new Puntaje();
        puntajeDeRespuesta.sumarPuntos(new PuntoPositivo());
        return puntajeDeRespuesta;
    }

    public Puntaje calificarOpcion(OpcionIncorrecta opcion, Puntaje puntajeDeRespuesta){
        //Puntaje unPuntajeDeLaOpcionElegida = new Puntaje();
        //unPuntajeDeLaOpcionElegida.sumarPuntos(new PuntoNeutro());
        //puntajeDeRespuesta.sumarPuntos(new punto Neutro());
        puntajeDeRespuesta = new PuntajeNeutro();
        return puntajeDeRespuesta;
    }

}
