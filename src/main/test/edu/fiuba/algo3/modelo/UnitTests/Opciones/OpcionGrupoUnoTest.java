package edu.fiuba.algo3.modelo.UnitTests.Opciones;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionGrupoUno;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

public class OpcionGrupoUnoTest {
    @Test
    public void test01UnaOpcionGrupoUnoAlEnlistarOpcionesCorrectasNoAgregaLaOpcionALaLista(){
        OpcionGrupoUno unaOpciondeGrupoUno = new OpcionGrupoUno();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpciondeGrupoUno.enlistarOpcionesCorrectas(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test02UnaOpcionGrupoUnoAlEnlistarGrupoUnoNoAgregaLaOpcionALaLista(){
        OpcionGrupoUno unaOpciondeGrupoUno = new OpcionGrupoUno();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpciondeGrupoUno.enlistarGrupoUno(unaListaDeOpcionesVacia);

        assertEquals(false, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test03UnaOpcionGrupoUnoAlEnlistarGrupoDosAgregaLaOpcionALaLista(){
        OpcionGrupoUno unaOpciondeGrupoUno = new OpcionGrupoUno();
        LinkedList<Opcion> unaListaDeOpcionesVacia = new LinkedList<>();

        unaOpciondeGrupoUno.enlistarGrupoDos(unaListaDeOpcionesVacia);

        assertEquals(true, unaListaDeOpcionesVacia.isEmpty());
    }
    @Test
    public void test04UnaOpcionGrupoUnoAlValidarNoInteractuaConLaPregunta(){
        Pregunta preguntaMock = mock(Pregunta.class);

        OpcionGrupoUno unaOpciondeGrupoUno = new OpcionGrupoUno();

        unaOpciondeGrupoUno.validarOpcion(preguntaMock);

        verifyNoInteractions(preguntaMock);
    }
}
