package edu.fiuba.algo3.modelo.UnitTests.Opciones;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OpcionOrdenadaTest {
    @Test
    public void test01UnaOpcionOrdenadaAlEnlistarOpcionesCorrectasNoAgregaLaOpcionALaLista(){
        //Arrange
        OpcionOrdenada unaOpcionOrdenada = new OpcionOrdenada();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        //Act
        unaOpcionOrdenada.enlistarOpcionesCorrectas(unaListaDeOpcionesVacia);

        //Assert
        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }

    @Test
    public void test02UnaOpcionOrdenadaAlValidarOpcionNoInteractuaConLaPregunta(){
        //Arrange
        OpcionOrdenada unaOpcionOrdenada = new OpcionOrdenada();
        PreguntaVerdaderoFalso preguntaMock = mock(PreguntaVerdaderoFalso.class);

        //Act
        unaOpcionOrdenada.validarOpcion(preguntaMock);

        //Assert
        verifyNoInteractions(preguntaMock);
    }
}
