package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Excepciones.PosicionInvalidaException;

public class ColeccionDeOpcionesTest {

	@Test
	public void testCrear() {
		ColeccionDeOpciones coleccionPrueba = new ColeccionDeOpciones(5);
		assertEquals(5, coleccionPrueba.size());
	}
	
	@Test
	public void testTildarOpcion() {
		ColeccionDeOpciones coleccionPrueba = new ColeccionDeOpciones(5);
		coleccionPrueba.tildarOpcion(3);
		Opcion opcionPrueba = coleccionPrueba.get(3);
		assertTrue(opcionPrueba.esCorrecta());
	}
	
	@Test
	public void testNoSePuedeTildarEnPosicionesInvalidas() {
		ColeccionDeOpciones coleccionPrueba = new ColeccionDeOpciones(5);
		assertThrows(PosicionInvalidaException.class,
				()->{
					/* primer posicion es 1 */
					coleccionPrueba.tildarOpcion(0);
				});
		assertThrows(PosicionInvalidaException.class,
				()->{
					coleccionPrueba.tildarOpcion(-1);
				});
		assertThrows(PosicionInvalidaException.class,
				()->{
					/* mayor a size() */
					coleccionPrueba.tildarOpcion(6);
				});
	}
	
	@Test
	public void testGetOpcion() {
		ColeccionDeOpciones coleccionPrueba = new ColeccionDeOpciones(5);
		coleccionPrueba.tildarOpcion(3);
		Opcion opcionPrueba1 = coleccionPrueba.get(3);
		Opcion opcionPrueba2 = coleccionPrueba.get(4);
		assertTrue(opcionPrueba1.esCorrecta());
		assertFalse(opcionPrueba2.esCorrecta());
	}
	
	@Test
	public void testNoSePuedeHacerGetEnPosicionesInvalidas() {
		ColeccionDeOpciones coleccionPrueba = new ColeccionDeOpciones(5);
		assertThrows(PosicionInvalidaException.class,
				()->{
					/* primer posicion es 1 */
					coleccionPrueba.get(0);
				});
		assertThrows(PosicionInvalidaException.class,
				()->{
					coleccionPrueba.get(-1);
				});
		assertThrows(PosicionInvalidaException.class,
				()->{
					/* mayor a size() */
					coleccionPrueba.get(6);
				});
	}

}
