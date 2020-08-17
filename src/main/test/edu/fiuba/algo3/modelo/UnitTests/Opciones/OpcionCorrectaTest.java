package edu.fiuba.algo3.modelo.UnitTests.Opciones;

import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpcionCorrectaTest {

    @Test
    public void test01UnaOpcionCorrectaAlEnlistarOpcionesCorrectasAgregaLaOpcionALaLista(){
        OpcionCorrecta unaOpcionCorrecta = new OpcionCorrecta();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpcionCorrecta.enlistarOpcionesCorrectas(unaListaDeOpcionesVacia);

        assertEquals(false, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test02UnaOpcionCorrectaAlEnlistarGrupoUnoNoAgregaLaOpcionALaLista(){
        OpcionCorrecta unaOpcionCorrecta = new OpcionCorrecta();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpcionCorrecta.enlistarGrupoUno(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }

    @Test
    public void test03UnaOpcionCorrectaAlEnlistarGrupoDosNoAgregaLaOpcionALaLista(){
        OpcionCorrecta unaOpcionCorrecta = new OpcionCorrecta();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpcionCorrecta.enlistarGrupoDos(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }


    @Test
    public void test04UnaOpcionCorrectaAlValidarOpcionSeCalificaRespuestaDeLaPreguntaConRespondeBien(){
        //Arrange
        OpcionCorrecta unaOpcionCorrecta = new OpcionCorrecta();
        PreguntaVerdaderoFalso preguntaMock = mock(PreguntaVerdaderoFalso.class);

        //Act
        unaOpcionCorrecta.validarOpcion(preguntaMock);

        //Assert
        verify(preguntaMock).calificarRespuesta(any(RespondeBien.class));
    }

}
