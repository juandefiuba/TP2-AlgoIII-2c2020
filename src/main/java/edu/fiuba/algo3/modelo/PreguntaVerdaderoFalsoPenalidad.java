package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad() {
        super();
    }


    public static PreguntaVerdaderoFalsoPenalidad preguntaVerdadera(){
        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad();
        pregunta.agregarOpcionCorrecta(1);
        return pregunta;
    }

    public static PreguntaVerdaderoFalsoPenalidad preguntaFalsa(){
        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad();
        pregunta.agregarOpcionCorrecta(2);
        return pregunta;
    }

    @Override
    public Puntaje obtenerPuntuacion(EstadoDeRespuesta estado) {
        return estado.devolverPuntaje(this);
    }

}
