package edu.fiuba.algo3.modelo2.Preguntas;


import edu.fiuba.algo3.modelo2.Jugador;
import edu.fiuba.algo3.modelo2.Opcion;
import edu.fiuba.algo3.modelo2.OpcionCorrecta;
import edu.fiuba.algo3.modelo2.OpcionIncorrecta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import edu.fiuba.algo3.modelo2.Puntos.PuntajeNeutro;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;


import java.util.LinkedList;

public class PreguntaMultipleChoiceClasico extends PreguntaVerdaderoFalso {

    public PreguntaMultipleChoiceClasico(LinkedList<Opcion> opciones) {
        super(opciones);
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
