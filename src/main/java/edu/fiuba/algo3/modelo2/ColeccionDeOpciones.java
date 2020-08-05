package edu.fiuba.algo3.modelo2;

import java.util.Iterator;
import java.util.LinkedList;

public class ColeccionDeOpciones {

    LinkedList<Opcion> opciones = new LinkedList<>();

    public void agregarOpcion(Opcion opcion) {
        this.opciones.add(opcion);
    }

    public Iterator obtenerIterador() {
        return this.opciones.iterator();
    }

    public void asignaEstadosDeRespuestasDeJugadores() {
        //this.opciones.forEach( opcion -> opcion.actualizarEstadoDeRespuestaAJugadores());
    }

    public void inscribirJugador(Jugador jugador) {
        //this.opciones.forEach(opcion -> opcion.inscribirJugador(jugador));
        //esto se puede hacer aca, y si no gusta se puede hacer en pregunta.obtenerIterador, que mande una copia
        //de los jugadores registrado, ver que onda, que gusta mas?
    }
}
