package edu.fiuba.algo3.modelo2;

import java.util.Iterator;
import java.util.LinkedList;

public class ColeccionDeOpciones {

    LinkedList<Opcion> opciones = new LinkedList<>();
    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
    }

    public Iterator obtenerIterador() {
        return opciones.iterator();
    }

    public void puntuar() {

            opciones.forEach( opcion -> opcion.puntuarSegunEstado());
    }


}
