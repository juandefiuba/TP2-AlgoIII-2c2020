package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class PreguntaMultipleChoiceClasico extends Pregunta{

    public PreguntaMultipleChoiceClasico(int cantidadOpciones){
        super(cantidadOpciones);
    }

    @Override
    public void calificarRespuesta(Respuesta respuesta) {
        respuesta.calificarMismaRespuesta(this.opciones);
    }

    @Override
    public Puntaje obtenerPuntuacion(EstadoDeRespuesta estado) {
        return estado.devolverPuntaje(this);
    }
}
