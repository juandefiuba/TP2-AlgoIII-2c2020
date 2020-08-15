package edu.fiuba.algo3.modelo.UnitTests.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Multiplicadores.*;
import edu.fiuba.algo3.modelo.Puntajes.*;
import edu.fiuba.algo3.modelo.Puntos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PuntajeNuloTest {
    @Test
    public void test01PuntajeNuloSeInicializaConCeroPuntos(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        assertEquals( 0 , unPuntaje.obtenerPuntos() );
    }

    @Test
    public void test02PuntajeNuloNoIncrementaPuntosAlSumarUnPuntoPositivo(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.sumarPuntos(new PuntoPositivo());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test03PuntajeNuloNoDecrementaPuntosAlSumarUnPuntoNegativo(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.sumarPuntos(new PuntoNegativo());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test04PuntajeNuloNoIncrementaPuntosAlSumarUnPuntoNulo(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.sumarPuntos(new PuntoNeutro());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test05PuntajeNuloNoIncrementaPuntosAlSumarUnPuntoEstatico(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test06PuntajeNuloNoIncrementaPuntosAlSumarUnPuntajeValidoConUnPunto(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        when(unPuntajeValidoMock.obtenerPuntos()).thenReturn(1);
        unPuntaje.sumarPuntos(unPuntajeValidoMock);
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test07PuntajeNuloNoModificaPuntosAlAplicarExclusividadSimple(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.aplicarExclusividad(new ExclusividadSimple());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test08PuntajeNuloNoModificaPuntosAlAplicarExclusividadDoble(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.aplicarExclusividad(new ExclusividadDoble());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test09PuntajeNuloNoModificaPuntosAlAplicarExclusividadCuadruple(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.aplicarExclusividad(new ExclusividadCuadruple());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test10PuntajeNuloNoModificaPuntosAlAplicarExclusividadDeEmpate(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.aplicarExclusividad(new ExclusividadDeEmpate());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test11PuntajeNuloNoModificaPuntosAlMultiplicarUnMultiplicadorDoble(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.multiplicar(new MultiplicadorDoble());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test12PuntajeNuloNoModificaPuntosAlMultiplicarUnMultiplicadorTriple(){
        PuntajeNulo unPuntaje = new PuntajeNulo();
        unPuntaje.multiplicar(new MultiplicadorTriple());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

}
