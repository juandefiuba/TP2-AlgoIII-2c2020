package edu.fiuba.algo3.modelo.UnitTests.Opcion;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
