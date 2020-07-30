package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Incorrecto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void testConstructorFuncionaCorrectamente() {
        /*ArrayList<String> opcionesIncorrectas = new ArrayList<String>();
        ArrayList<String> opcionesCorrectas = new ArrayList<String>();
        opcionesIncorrectas.add("Rta1");
        opcionesIncorrectas.add("Rta2");
        opcionesCorrectas.add("Rta3");
        opcionesCorrectas.add("Rta4");*/

        PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.crearConCantOpciones(4);
        assertEquals(4, preguntaPrueba.getCantidadOpciones());
        //assertEquals(Correcto.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
    }
/*
    @Test
    public void testRespondoCorrectamenteLaPreguntaGano1Punto() {
        PreguntaMultipleChoiceParcial preguntaPrueba = new PreguntaMultipleChoiceParcial(4);
        Jugador jugadorPrueba = new Jugador("NN");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(1, jugadorPrueba.getPuntos());
    }

    @Test
    public void testRespondoCorrectamenteLaPreguntaGanoMenos1Punto() {
        PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.preguntaVerdadera();
        Jugador jugadorPrueba = new Jugador("NN");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionCorrecta(0);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(-1, jugadorPrueba.getPuntos());
    }*/
}
