package edu.fiuba.algo3.modelo.UnitTests.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaCuadruple;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaSimple;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PuntajeValidoTests {

    @Test
    public void test01PuntajeValidoSeInicializaConCeroPuntos(){
        PuntajeValido unPuntaje = new PuntajeValido();
        assertEquals( 0 , unPuntaje.obtenerPuntos() );
    }

    @Test
    public void test02PuntajeValidoIncrementaUnPuntoAlSumarUnPuntoPositivo(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoPositivo());
        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test03PuntajeValidoDecrementaUnPuntoAlSumarUnPuntoNegativo(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoNegativo());
        assertEquals( -1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test04PuntajeValidoNoIncrementaPuntosAlSumarUnPuntoNeutro(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoNeutro());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test05PuntajeValidoIncrementaUnPuntoAlSumarUnPuntoEstatico(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test06PuntajeValidoIncrementaUnPuntoAlSumarDosPuntoEstatico(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.sumarPuntos(new PuntoEstatico());
        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test07PuntajeValidoIncrementaUnPuntoAlSumarUnPuntajeValidoConUnPunto(){
        PuntajeValido unPuntaje = new PuntajeValido();

        PuntajeValido otroPuntaje = new PuntajeValido();
        otroPuntaje.sumarPuntos(new PuntoEstatico());

        unPuntaje.sumarPuntos(otroPuntaje);

        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test08PuntajeValidoMantieneSusPuntosAlSumarUnPuntajeNeutro(){
        PuntajeValido unPuntaje = new PuntajeValido();
        PuntajeNulo unPuntajeNuloMock = mock(PuntajeNulo.class);

        when(unPuntajeNuloMock.obtenerPuntos()).thenReturn(0);

        unPuntaje.sumarPuntos(unPuntajeNuloMock);

        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test09PuntajeValidoMantieneSusPuntosAlAplicarExclusividadSimple(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadCompuestaSimple());
        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test10PuntajeValidoDuplicaSusPuntosAlAplicarExclusividadDoble(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadCompuestaDoble());
        assertEquals( 2 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test11PuntajeValidoCuatriplaSusPuntosAlAplicarExclusividadCuadruple(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadCompuestaCuadruple());
        assertEquals( 4 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test12PuntajeValidoVuelveCeroSusPuntosAlAplicarExclusividadInvalida(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadInvalida());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }


    @Test
    public void test13PuntajeValidoDuplicaSusPuntosMultiplicarConMultiplicadorDoble(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.multiplicar(new MultiplicadorDoble());
        assertEquals( 2 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test14PuntajeValidotriplicaSusPuntosMultiplicarConMultiplicadorTriple() {
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.multiplicar(new MultiplicadorTriple());
        assertEquals(3, unPuntaje.obtenerPuntos());
    }
}
