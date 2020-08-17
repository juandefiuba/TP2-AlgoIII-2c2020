package edu.fiuba.algo3.modelo.UnitTests.Opcion;

import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
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
    public void test02UnaOpcionIncorrectaAlEnlistarGrupoUnoNoAgregaLaOpcionALaLista(){
        OpcionIncorrecta unaOpcionIncorrecta = new OpcionIncorrecta();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpcionIncorrecta.enlistarGrupoUno(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test03UnaOpcionIncorrectaAlEnlistarGrupoDosNoAgregaLaOpcionALaLista(){
        OpcionIncorrecta unaOpcionIncorrecta = new OpcionIncorrecta();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpcionIncorrecta.enlistarGrupoDos(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }

    @Test
    public void test04UnaOpcionIncorrectaAlValidarOpcionLlaUnaVezAQueLaPreguntaCalifiqueUnaRespuestaMal(){
        Pregunta preguntaMock = mock(Pregunta.class);

        OpcionIncorrecta unaOpcionIncorrecta = new OpcionIncorrecta();

        unaOpcionIncorrecta.validarOpcion(preguntaMock);

        verify(preguntaMock).calificarRespuesta(any(RespondeMal.class));
    }

}
