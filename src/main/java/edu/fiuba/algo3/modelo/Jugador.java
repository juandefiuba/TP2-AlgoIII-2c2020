package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadSimple;
import edu.fiuba.algo3.modelo.Multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorQueNoMultiplica;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeValido;

public class Jugador {

    String nombreJugador;
    private PuntajeValido puntaje;
    Multiplicador multiplicadorDoble;
    Multiplicador multiplicadorTriple;
    Multiplicador multiplicadorActual;
    Exclusividad exclusividad;

    public Jugador(String nombre) {
        this.nombreJugador = nombre;
        this.puntaje = new PuntajeValido();
        this.multiplicadorDoble = new MultiplicadorDoble();
        this.multiplicadorTriple = new MultiplicadorTriple();
        this.multiplicadorActual = new MultiplicadorQueNoMultiplica();
        this.exclusividad = new ExclusividadSimple();
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
        this.exclusividad = new ExclusividadDoble();
    }

    public Exclusividad obtenerExclusividad() {
        Exclusividad exclusividadADevolver = this.exclusividad;
        this.exclusividad = new ExclusividadSimple();
        return exclusividadADevolver;
    }
}
