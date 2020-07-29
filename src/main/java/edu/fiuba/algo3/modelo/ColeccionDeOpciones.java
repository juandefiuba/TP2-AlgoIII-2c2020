package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ColeccionDeOpciones {

    protected ArrayList<Opcion> opciones;

    public ColeccionDeOpciones(int cantidadDeElementos){
        opciones = new ArrayList<>();
        for(int i = 1; i <= cantidadDeElementos; i++) {
            opciones.add( new Opcion() );    // index = [ 0 , 1 ]
        }
    }


    public int size(){
        return opciones.size();
    }

    public void agregarOpcionCorrecta(int unaPocicion){
        int elIndex = unaPocicion-1;
        opciones.get(elIndex).definirCorrecta();
    }


    public Opcion obtener(int Posicion) {
        int elIndex = Posicion-1;
        return (opciones.get(elIndex));
    }
}
