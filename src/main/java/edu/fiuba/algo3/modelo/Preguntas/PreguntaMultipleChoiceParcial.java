package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    public PreguntaMultipleChoiceParcial(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    @Override
    public void calificarOpcion(Opcion opcion) {
        opcion.validarOpcion(this);
    }

    @Override
    public void calificarOpcion(OpcionCorrecta opcion) {
        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }
    @Override
    public void calificarOpcion(OpcionIncorrecta opcion){
        this.puntajeDelJugador = new PuntajeNeutro();
    }
}
