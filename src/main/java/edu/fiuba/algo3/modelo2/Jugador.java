package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;

public class Jugador {

    String nombreJugador;
    int puntos;
    EstadoDeRespuesta estado;

    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.puntos = 0;
        this.estado = new RespondeBien();   // revisar esto, porque jugador que no responde, responde(?)
    }

    public int obtenerPuntos() {
        return puntos;
    }

    public void sumarPuntos(Pregunta pregunta){
        this.puntos = this.puntos + this.estado.obtenerPuntajeSegunRespuesta(pregunta);
    }

    public void estadoRespondioCorrecto() { this.estado = this.estado.actualizarEstado(new RespondeBien());
    }

    public void estadoRespondioIncorrecto() {
        this.estado = this.estado.actualizarEstado(new RespondeMal());
    }
}
