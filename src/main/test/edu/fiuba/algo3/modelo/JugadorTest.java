package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadParcial;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadParcialSimple;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void test01JugadorActivaMultiplicadorDobleYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveDosPuntos(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorDos();

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeConUnPunto);

        assertEquals(2 , unPuntajeConUnPunto.obtenerPuntos());
    }

    @Test
    public void test02JugadorActivaMultiplicadorTripleYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveTresPuntos(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorTres();

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador.multiplicar(unPuntajeConUnPunto);

        assertEquals(3 , unPuntajeConUnPunto.obtenerPuntos());
    }

    @Test
    public void test03JugadorActivaMultiplicadorDobleYUnaVezObtenidoYaNoSeVuelveAObtenerUnoDoble(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorDos();

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador = unJugador.obtenerMultiplicador();

        unMultiplicador.multiplicar(unPuntajeConUnPunto);

        assertEquals(1 , unPuntajeConUnPunto.obtenerPuntos());
    }
    @Test
    public void test04JugadorActivaMultiplicadorTripleYUnaVezObtenidoYaNoSeVuelveAObtenerUnoTriple(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorTres();

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();
        unMultiplicador = unJugador.obtenerMultiplicador();

        unMultiplicador.multiplicar(unPuntajeConUnPunto);

        assertEquals(1 , unPuntajeConUnPunto.obtenerPuntos());
    }

    @Test
    public void test05JugadorActivaMultiplicadorDobleDosVecesYNoMultiplicaPuntosEnPuntaje(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorDos();
        unJugador.obtenerMultiplicador();
        unJugador.activarMultiplicadorPorDos();

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());


        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();


        unMultiplicador.multiplicar(unPuntajeConUnPunto);

        assertEquals(1 , unPuntajeConUnPunto.obtenerPuntos());
    }

    @Test
    public void test06JugadorActivaMultiplicadorTripleDosVecesYNoMultiplicaPuntosEnPuntaje(){
        Jugador unJugador = new Jugador();
        unJugador.activarMultiplicadorPorTres();
        unJugador.obtenerMultiplicador();
        unJugador.activarMultiplicadorPorTres();

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());


        Multiplicador unMultiplicador = unJugador.obtenerMultiplicador();

        unMultiplicador.multiplicar(unPuntajeConUnPunto);

        assertEquals(1 , unPuntajeConUnPunto.obtenerPuntos());
    }

    @Test
    public void test07JugadorActivaExclusividadYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveDosPuntos(){
        Jugador unJugador = new Jugador();
        unJugador.activarExclusividad();
        ExclusividadParcial unaExclusividadParcial = unJugador.obtenerExclusividad();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcial.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        unPuntajeConUnPunto.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(2 , unPuntajeConUnPunto.obtenerPuntos());
    }

    @Test
    public void test08JugadorActivaExclusividadDosVecesYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveDosPuntos(){
        Jugador unJugador = new Jugador();
        unJugador.activarExclusividad();
        unJugador.obtenerExclusividad();
        unJugador.activarExclusividad();
        ExclusividadParcial unaExclusividadParcial = unJugador.obtenerExclusividad();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcial.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        unPuntajeConUnPunto.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(2 , unPuntajeConUnPunto.obtenerPuntos());
    }


    @Test
    public void test09JugadorActivaExclusividadTresVecesYSeLoDoyAUnPuntajeConUnPuntoYEsteDevuelveUnPunto(){
        Jugador unJugador = new Jugador();
        unJugador.activarExclusividad();
        unJugador.obtenerExclusividad();
        unJugador.activarExclusividad();
        unJugador.obtenerExclusividad();
        unJugador.activarExclusividad();
        ExclusividadParcial unaExclusividadParcial = unJugador.obtenerExclusividad();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcial.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeConUnPunto = new PuntajeValido();
        unPuntajeConUnPunto.sumarPuntos(new PuntoPositivo());

        unPuntajeConUnPunto.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(1 , unPuntajeConUnPunto.obtenerPuntos());
    }



}
