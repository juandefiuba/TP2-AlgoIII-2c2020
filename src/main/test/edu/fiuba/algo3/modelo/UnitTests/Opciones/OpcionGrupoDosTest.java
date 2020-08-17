package edu.fiuba.algo3.modelo.UnitTests.Opciones;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupoDos;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OpcionGrupoDosTest {
    @Test
    public void test01UnaOpcionGrupoDosAlEnlistarOpcionesCorrectasNoAgregaLaOpcionALaLista(){
        OpcionGrupoDos unaOpciondeGrupoDos = new OpcionGrupoDos();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpciondeGrupoDos.enlistarOpcionesCorrectas(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test02UnaOpcionGrupoDosAlEnlistarGrupoUnoNoAgregaLaOpcionALaLista(){
        OpcionGrupoDos unaOpciondeGrupoDos = new OpcionGrupoDos();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpciondeGrupoDos.enlistarGrupoUno(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test03UnaOpcionGrupoDosAlEnlistarGrupoDosAgregaLaOpcionALaLista(){
        OpcionGrupoDos unaOpciondeGrupoDos = new OpcionGrupoDos();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpciondeGrupoDos.enlistarGrupoDos(unaListaDeOpcionesVacia);

        assertEquals(false, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test04UnaOpcionGrupoDosAlValidarNoInteractuaConLaPregunta(){
        Pregunta preguntaMock = mock(Pregunta.class);

        OpcionGrupoDos unaOpcionGrupoDos= new OpcionGrupoDos();

        unaOpcionGrupoDos.validarOpcion(preguntaMock);

        verifyNoInteractions(preguntaMock);
    }

}

