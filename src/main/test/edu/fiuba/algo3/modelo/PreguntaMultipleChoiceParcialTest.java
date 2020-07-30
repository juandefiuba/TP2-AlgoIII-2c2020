package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Incorrecto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void testConstructorFuncionaCorrectamente() {
        PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.crearConCantOpciones(4);
        assertEquals(4, preguntaPrueba.getCantidadOpciones());
    }
    
    @Test
    public void testNoSePuedeCrearConMenosDe2Opciones() {
    	assertThrows(CantidadDeOpcionesInvalidaException.class, 
    			()->{
    				PreguntaMultipleChoiceParcial.crearConCantOpciones(1);
    			});
    }
    
    @Test
    public void testNoSePuedeCrearConMasDe5Opciones() {
    	assertThrows(CantidadDeOpcionesInvalidaException.class, 
    			()->{
    				PreguntaMultipleChoiceParcial.crearConCantOpciones(6);
    			});
    }

    @Test
    public void testRespondoCorrectamenteLaPreguntaGano1Punto() {
        PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.crearConCantOpciones(4);
        Jugador jugadorPrueba = new Jugador("Sr. Pepito");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        preguntaPrueba.agregarOpcionCorrecta(1);
        respuestaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(1, jugadorPrueba.getPuntos());
    }

/*
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
