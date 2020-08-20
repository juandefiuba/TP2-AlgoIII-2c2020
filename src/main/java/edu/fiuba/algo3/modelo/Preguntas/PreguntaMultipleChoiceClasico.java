package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.SobranOpcionesDeLaPreguntaException;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcial;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntos.PuntoEstatico;


import java.util.LinkedList;

public class PreguntaMultipleChoiceClasico extends PreguntaBase {


    public PreguntaMultipleChoiceClasico(LinkedList<Opcion> opciones) {
        super(opciones);
        if(opciones.size() > 5){
            throw new SobranOpcionesDeLaPreguntaException();
        }
   }

   @Override
    public Puntaje obtenerPuntajeBaseDelJugador(Jugador jugador) {

        Puntaje unPuntaje = super.obtenerPuntajeBaseDelJugador(jugador);

        LinkedList<Opcion> opcionesCorrectas = new LinkedList<>();
        opciones.forEach(opcion -> opcion.enlistarOpcionesCorrectas(opcionesCorrectas));
        opcionesCorrectas.removeAll(this.respuestasDeLosJugadores.get(jugador));

        LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador = opcionesCorrectas;

        if(!opcionesCorrectasNoElegidasPorElJugador.isEmpty()){
            this.calificarRespuesta(new RespondeMal());
        }

        return this.puntajeDelJugador;
    }

    @Override
    public void puntuarJugadores(Jugador jugador, Jugador jugador2) {

        Puntaje puntajeJugador = this.obtenerPuntajeBaseDelJugador(jugador);
        Puntaje puntajeJugador2 = this.obtenerPuntajeBaseDelJugador(jugador2);

        ExclusividadParcial exclusividad = jugador.obtenerExclusividad();
        ExclusividadParcial exclusividad2 = jugador2.obtenerExclusividad();

        ExclusividadCompuesta exclusividadTotal = exclusividad2.componerExclusividad(exclusividad);

        exclusividadTotal.aplicarExclusividadAPuntajes(puntajeJugador, puntajeJugador2);

        jugador.sumarPuntos(puntajeJugador);
        jugador2.sumarPuntos(puntajeJugador2);
    }

    @Override
    public void calificarRespuesta(RespondeBien calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoEstatico());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {
        this.puntajeDelJugador = new PuntajeNulo();
    }

}
