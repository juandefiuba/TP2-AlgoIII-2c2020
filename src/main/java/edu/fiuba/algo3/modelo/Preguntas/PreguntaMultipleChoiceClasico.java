package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Respuesta;

public class PreguntaMultipleChoiceClasico extends Pregunta{

    public PreguntaMultipleChoiceClasico(int cantidadOpciones){
        super(cantidadOpciones);
    }

    @Override
    public void calificarRespuesta(Respuesta respuesta) {
        respuesta.calificarRespuestaClasica(this.opciones);
    }
    /*
    @Override
    public Puntaje obtenerPuntuacion(EstadoDeRespuesta estado) {
        return estado.devolverPuntaje(this);
    }*/
}
