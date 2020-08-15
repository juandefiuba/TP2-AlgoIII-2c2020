package edu.fiuba.algo3.modelo.UnitTests.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCuadruple;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDeEmpate;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadSimple;
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
        unPuntaje.aplicarExclusividad(new ExclusividadSimple());
        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test10PuntajeValidoDuplicaSusPuntosAlAplicarExclusividadDoble(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadDoble());
        assertEquals( 2 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test11PuntajeValidoCuatriplaSusPuntosAlAplicarExclusividadCuadruple(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadCuadruple());
        assertEquals( 4 , unPuntaje.obtenerPuntos());
    }

    @Test
    public void test12PuntajeValidoVuelveCeroSusPuntosAlAplicarExclusividadDeEmpate(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.aplicarExclusividad(new ExclusividadDeEmpate());
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
    public void test14PuntajeValidotriplicaSusPuntosMultiplicarConMultiplicadorTriple(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoEstatico());
        unPuntaje.multiplicar(new MultiplicadorTriple());
        assertEquals( 3 , unPuntaje.obtenerPuntos());
    }

/*
        @Test
        public void elConductorLaBardeo() {

            IVehiculo vehiculoMock = mock(IVehiculo.class);

            when(vehiculoMock.tocarBocina()).thenReturn(true);
            when(vehiculoMock.frenar()).thenReturn(true);

            Conductor conductor = new Conductor(vehiculoMock);

            boolean ofendido = true;

            Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));

            verify(vehiculoMock,times(1)).tocarBocina();
            verify(vehiculoMock,times(1)).frenar();
        }


        @Test
        public void elConductorEstaTranquilo() {

            IVehiculo vehiculoMock = mock(IVehiculo.class);

            when(vehiculoMock.tocarBocina()).thenReturn(true);
            when(vehiculoMock.frenar()).thenReturn(true);

            Conductor conductor = new Conductor(vehiculoMock);

            boolean ofendido = false;

            Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));

            verify(vehiculoMock,never()).tocarBocina();
            verify(vehiculoMock,times(1)).frenar();
        }*/

}
