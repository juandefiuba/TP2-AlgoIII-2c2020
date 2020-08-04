package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;

public class Jugador {

    String nombreJugador;
    private Puntaje puntaje;
    private EstadoDeRespuesta estado;

    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.puntaje = new Puntaje();
        this.estado = new RespondeBien();   // revisar esto, porque jugador que no responde, responde(?)
    }

    public int obtenerPuntos() {
        return puntaje.obtenerPuntos();
    }

    public void sumarPuntos(Pregunta pregunta){
        this.puntaje.sumarPuntos(this.estado.obtenerPuntajeSegunRespuesta(pregunta));
    }


    //suma puntos
    public void estadoRespondioBien() {
        this.estado = this.estado.actualizarEstado(new RespondeBien());
    }

    //no suma puntos
    public void estadoRespondioIncorrecto() {
        this.estado = this.estado.actualizarEstado(new RespondeMal());
    }

    //ya está Moriste asi tiro a tiro con la gorra porque no te cabe una
    public void estadoRespondioMal() {
        this.estado = new RespondeMal();
    }
}
