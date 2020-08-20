package edu.fiuba.algo3.modelo.UnitTests.Opciones;

import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OpcionIncorrectaTest {
    @Test
    public void test01UnaOpcionIncorrectaAlEnlistarOpcionesCorrectasNoAgregaLaOpcionALaLista(){
        OpcionIncorrecta unaOpcionIncorrecta = new OpcionIncorrecta();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpcionIncorrecta.enlistarOpcionesCorrectas(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }

    @Test
    public void test02UnaOpcionIncorrectaAlValidarOpcionLlaUnaVezAQueLaPreguntaCalifiqueUnaRespuestaMal(){
        Pregunta preguntaMock = mock(Pregunta.class);

        OpcionIncorrecta unaOpcionIncorrecta = new OpcionIncorrecta();

        unaOpcionIncorrecta.validarOpcion(preguntaMock);

        verify(preguntaMock).calificarRespuesta(any(RespondeMal.class));

    }

}
