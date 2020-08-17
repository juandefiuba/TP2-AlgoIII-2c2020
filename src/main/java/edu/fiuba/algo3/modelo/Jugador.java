package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcial;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcialDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcialSimple;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorQueNoMultiplica;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;

import java.util.Iterator;
import java.util.LinkedList;

public class Jugador {

    String nombreJugador;
    private PuntajeValido puntaje;
    Multiplicador multiplicadorDoble;
    Multiplicador multiplicadorTriple;
    Multiplicador multiplicadorActual;
    Iterator iteradorDeExclusividades;
    LinkedList<ExclusividadParcial> exclusividadesDelJugador;
    ExclusividadParcial exclusividad;

    public Jugador() {
        this.puntaje = new PuntajeValido();
        this.multiplicadorDoble = new MultiplicadorDoble();
        this.multiplicadorTriple = new MultiplicadorTriple();
        this.multiplicadorActual = new MultiplicadorQueNoMultiplica();

        this.exclusividadesDelJugador = new LinkedList<>();
        this.exclusividadesDelJugador.add(new ExclusividadParcialDoble());
        this.exclusividadesDelJugador.add(new ExclusividadParcialDoble());

        this.iteradorDeExclusividades = this.exclusividadesDelJugador.iterator();
        this.exclusividad = new ExclusividadParcialSimple();
    }
    public void asignarNombreAlJugador(String unNombre){
        this.nombreJugador = unNombre;
    }

    public int obtenerPuntos() {
        return puntaje.obtenerPuntos();
    }

    public void sumarPuntos(Puntaje unPuntaje){
        this.puntaje.sumarPuntos(unPuntaje);
    }

    public void activarMultiplicadorPorDos() {
        this.multiplicadorActual = this.multiplicadorDoble;
        this.multiplicadorDoble = new MultiplicadorQueNoMultiplica();
    }

    public void activarMultiplicadorPorTres() {
        this.multiplicadorActual = this.multiplicadorTriple;
        this.multiplicadorTriple = new MultiplicadorQueNoMultiplica();
    }

    public Multiplicador obtenerMultiplicador(){
        Multiplicador multiplicadorAUsar = this.multiplicadorActual;
        this.multiplicadorActual = new MultiplicadorQueNoMultiplica();
        return multiplicadorAUsar;
    }

    public void activarExclusividad() {
        if (this.iteradorDeExclusividades.hasNext()){
            this.exclusividad = (ExclusividadParcial) this.iteradorDeExclusividades.next();
        }
    }

    public ExclusividadParcial obtenerExclusividad() {
        ExclusividadParcial exclusividadADevolver = this.exclusividad;
        this.exclusividad = new ExclusividadParcialSimple();
        return exclusividadADevolver;
    }
}
