package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Excepciones.CantidadOpcionesInvalidaException;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceParcial;

public class PreguntaMultipleChoiceParcialTest {

	@Test
    public void testConstructorFuncionaCorrectamente() {
        PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.newPregunta(4);
        assertEquals(4, preguntaPrueba.getCantidadOpciones());
    }
    
    @Test
    public void testNoSePuedeCrearConMenosDe2Opciones() {
    	assertThrows(CantidadOpcionesInvalidaException.class, 
    			()->{
    				PreguntaMultipleChoiceParcial.newPregunta(1);
    			});
    }
    
    @Test
    public void testNoSePuedeCrearConMasDe5Opciones() {
    	assertThrows(CantidadOpcionesInvalidaException.class, 
    			()->{
    				PreguntaMultipleChoiceParcial.newPregunta(6);
    			});
    }

    @Test
    public void testRespondoCorrectamenteLaPreguntaCon1OpcionCorrectaGano1Punto() {
        PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.newPregunta(2);
        Jugador jugadorPrueba = new Jugador("Sr. Pepito");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        preguntaPrueba.agregarOpcionCorrecta(1);
        respuestaPrueba.agregarOpcionElegida(1);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(1, jugadorPrueba.getPuntos());
    }
    
    @Test
    public void testRespondoPefectoPreguntaConTodasOpcionesCorrectasGano5Pts() {
    	PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.newPregunta(5);
        Jugador jugadorPrueba = new Jugador("Sr. Pepito");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        for(int i = 1; i <= 5; i++) {
        	preguntaPrueba.agregarOpcionCorrecta(i);
        	respuestaPrueba.agregarOpcionElegida(i);
        }
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(5, jugadorPrueba.getPuntos());
    }

    @Test
    public void testRespondoUnaOpcionDe2OpcionesGano1Punto() {
    	PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.newPregunta(5);
        Jugador jugadorPrueba = new Jugador("Sra. Pepito");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.agregarOpcionCorrecta(3);
        respuestaPrueba.agregarOpcionElegida(1);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(1, jugadorPrueba.getPuntos());
    }
    
    @Test
    public void testRespondoTodasIncorrectasCuandoHayIncorrectasNoGano() {
    	PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.newPregunta(5);
        Jugador jugadorPrueba = new Jugador("Sra. Pepito");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(0, jugadorPrueba.getPuntos());
    }
    
    @Test
    public void testRespondoAlgunasBienOtrasMalNoGanoPuntos() {
    	PreguntaMultipleChoiceParcial preguntaPrueba = PreguntaMultipleChoiceParcial.newPregunta(5);
        Jugador jugadorPrueba = new Jugador("Sr. Pepito");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        for(int i = 1; i <= 4; i++) {
        	preguntaPrueba.agregarOpcionCorrecta(i);
        	respuestaPrueba.agregarOpcionElegida(i);
        }
        respuestaPrueba.agregarOpcionElegida(5);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(0, jugadorPrueba.getPuntos());
    }
    
}
