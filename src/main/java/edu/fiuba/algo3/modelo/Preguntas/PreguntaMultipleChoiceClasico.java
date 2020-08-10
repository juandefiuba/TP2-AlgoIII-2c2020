package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;
import edu.fiuba.algo3.modelo.Puntos.PuntoEstatico;


import java.util.LinkedList;

public class PreguntaMultipleChoiceClasico extends Pregunta {


    public PreguntaMultipleChoiceClasico(LinkedList<Opcion> opciones) {
        super(opciones);
   }

   @Override
    public Puntaje puntuarJugador(Jugador jugador) {

        this.puntajeDelJugador = new Puntaje();
        LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(jugador);

        respuestaDelJugador.forEach(opcion -> this.calificarOpcion(opcion));

        LinkedList<Opcion> opcionesCorrectas = new LinkedList<>();
        opciones.forEach(opcion -> opcion.agregarOpcionesCorrectas(opcionesCorrectas));
        opcionesCorrectas.removeAll(respuestaDelJugador);
        LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador = opcionesCorrectas;

        if(!opcionesCorrectasNoElegidasPorElJugador.isEmpty()){
            this.puntajeDelJugador = new PuntajeNeutro();
        }

        return this.puntajeDelJugador;
    }

    @Override
    public void calificarOpcion(OpcionCorrecta opcion){
        this.puntajeDelJugador.sumarPuntos(new PuntoEstatico());
    }
    @Override
    public void calificarOpcion(OpcionIncorrecta opcion){
        this.puntajeDelJugador = new PuntajeNeutro();
    }
}
