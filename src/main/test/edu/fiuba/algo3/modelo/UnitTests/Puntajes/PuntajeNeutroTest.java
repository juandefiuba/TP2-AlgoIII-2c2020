package edu.fiuba.algo3.modelo.UnitTests.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCuadruple;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDeEmpate;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadSimple;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PuntajeNeutroTest {
    @Test
    public void test01PuntajeNeutroSeInicializaConCeroPuntos(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        assertEquals( 0 , unPuntaje.obtenerPuntos() );
    }

    @Test
    public void test02PuntajeNeutroNoIncrementaPuntosAlSumarUnPuntoPositivo(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.sumarPuntos(new PuntoPositivo());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test03PuntajeNeutroNoDecrementaPuntosAlSumarUnPuntoNegativo(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.sumarPuntos(new PuntoNegativo());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test04PuntajeNeutroNoIncrementaPuntosAlSumarUnPuntoNeutro(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.sumarPuntos(new PuntoNeutro());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test05PuntajeNeutroNoIncrementaPuntosAlSumarUnPuntoEstatico(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test06PuntajeNeutroNoIncrementaPuntosAlSumarUnPuntajeValidoConUnPunto(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        when(unPuntajeValidoMock.obtenerPuntos()).thenReturn(1);
        unPuntaje.sumarPuntos(unPuntajeValidoMock);
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test07PuntajeNeutroNoModificaPuntosAlAplicarExclusividadSimple(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.aplicarExclusividad(new ExclusividadSimple());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test08PuntajeNeutroNoModificaPuntosAlAplicarExclusividadDoble(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.aplicarExclusividad(new ExclusividadDoble());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test09PuntajeNeutroNoModificaPuntosAlAplicarExclusividadCuadruple(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.aplicarExclusividad(new ExclusividadCuadruple());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test10PuntajeNeutroNoModificaPuntosAlAplicarExclusividadDeEmpate(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.aplicarExclusividad(new ExclusividadDeEmpate());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test11PuntajeNeutroNoModificaPuntosAlMultiplicarUnMultiplicadorDoble(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.multiplicar(new MultiplicadorDoble());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test12PuntajeNeutroNoModificaPuntosAlMultiplicarUnMultiplicadorTriple(){
        PuntajeNeutro unPuntaje = new PuntajeNeutro();
        unPuntaje.multiplicar(new MultiplicadorTriple());
        assertEquals( 0 , unPuntaje.obtenerPuntos());
    }

}
