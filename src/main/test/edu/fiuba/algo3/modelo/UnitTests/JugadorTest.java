package edu.fiuba.algo3.modelo.UnitTests;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorQueNoMultiplica;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class JugadorTest {

    @Test
    public void test01ElJugadorArrancaConCeroPuntos(){
        Jugador unJugador = new Jugador();
        assertEquals( 0 , unJugador.obtenerPuntos());
    }

    @Test
    public void test02ElJugadorSumaUnPuntajeMockCorrectamente(){
        Puntaje puntajeMock = mock(Puntaje.class);
        when(puntajeMock.obtenerPuntos()).thenReturn(3);

        Jugador unJugador = new Jugador();
        unJugador.sumarPuntos(puntajeMock);

        assertEquals(3 , unJugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorActivaMultiplicadorDobleYSeLoDoyAUnPuntajeMockYMeAseguroQueMultiplique(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorDos();

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);

        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeMock);

        verify(unPuntajeMock).multiplicar(any(MultiplicadorDoble.class));
    }

    @Test
    public void test04JugadorActivaMultiplicadorTripleYSeLoDoyAUnPuntajeMockYMeAseguroQueMultiplique(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorTres();

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);
        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeMock);

        verify(unPuntajeMock).multiplicar(any(MultiplicadorTriple.class));
    }

    @Test
    public void test05JugadorActivaMultiplicadorDobleYUnaVezObtenidoYaNoSeVuelveAObtenerUnoDoble(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorDos();

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);
        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeMock);

        verify(unPuntajeMock).multiplicar(any(MultiplicadorDoble.class));
    }
    @Test
    public void test06JugadorActivaMultiplicadorTripleYUnaVezObtenidoYaNoSeVuelveAObtenerUnoTriple(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorTres();

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);
        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeMock);

        verify(unPuntajeMock).multiplicar(any(MultiplicadorTriple.class));
    }

    @Test
    public void test007JugadorActivaMultiplicadorDobleDosVecesYNoMultiplicaPuntosEnPuntaje(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorDos();
        unJugador.obtenerMultiplicador();
        unJugador.activarMultiplicadorPorDos();

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);
        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeMock);

        ;

        verify(unPuntajeMock).multiplicar(any(MultiplicadorQueNoMultiplica.class));
    }

    @Test
    public void test08JugadorActivaMultiplicadorTripleDosVecesYNoMultiplicaPuntosEnPuntaje(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorTres();
        unJugador.obtenerMultiplicador();
        unJugador.activarMultiplicadorPorTres();

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);
        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeMock);

        verify(unPuntajeMock).multiplicar(any(MultiplicadorQueNoMultiplica.class));
    }

    @Test
    public void test09JugadorActivaExclusividadYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveDosPuntos(){
        Jugador unJugador = new Jugador();
        unJugador.activarExclusividad();
        ExclusividadParcial unaExclusividadParcial = unJugador.obtenerExclusividad();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcial.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);

        exclusividadCompuesta.aplicarExclusividad(unPuntajeMock);

        verify(unPuntajeMock).aplicarExclusividad(any(ExclusividadCompuestaDoble.class));
    }

    @Test
    public void test10JugadorActivaExclusividadDosVecesYSeLoDoyAUnPuntaje(){
        Jugador unJugador = new Jugador();
        unJugador.activarExclusividad();
        unJugador.obtenerExclusividad();
        unJugador.activarExclusividad();
        ExclusividadParcial unaExclusividadParcial = unJugador.obtenerExclusividad();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcial.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);

        exclusividadCompuesta.aplicarExclusividad(unPuntajeMock);

        verify(unPuntajeMock).aplicarExclusividad(any(ExclusividadCompuestaDoble.class));
    }


    @Test
    public void test11JugadorActivaExclusividadTresVecesYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveUnPunto(){
        Jugador unJugador = new Jugador();
        unJugador.activarExclusividad();
        unJugador.obtenerExclusividad();
        unJugador.activarExclusividad();
        unJugador.obtenerExclusividad();
        unJugador.activarExclusividad();
        ExclusividadParcial unaExclusividadParcial = unJugador.obtenerExclusividad();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcial.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeMock = mock(PuntajeValido.class);

        exclusividadCompuesta.aplicarExclusividad(unPuntajeMock);

        verify(unPuntajeMock).aplicarExclusividad(any(ExclusividadCompuestaSimple.class));
    }



}
