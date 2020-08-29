package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.MoverOpcionesAGrupo;
import edu.fiuba.algo3.vista.handlers.SeleccionarOpcionGroupChoice;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOkGroupChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Iterator;

public class ContenedorPreguntaGroupChoice extends ContenedorPregunta {

    public ContenedorPreguntaGroupChoice(double segundos, String tipoDePregunta, Stage stage, Kahoot kahoot, boolean yaRespondioJugador, HBox botonesBonus, String rutaFondo) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador, segundos, tipoDePregunta, rutaFondo);
    }

    @Override
    protected Pane inicializarContenedorOpciones() {
        //inicializacion
        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesGrupo1 = new VBox();
        VBox vboxOpcionesGrupo2 = new VBox();
        HBox menuInteractivo = new HBox();
        Button botonPasarAGrupo1 = new Button("<-");
        Button botonPasarAGrupo2 = new Button("->");
        HashMap botonYOpcionSelecc = new HashMap();

        //comportamiento
        this.cambiarComportamientoBotonOk(new BotonOkGroupChoice(kahoot, stage, yaRespondioUnJugador, vboxOpcionesDadas));
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = iteradorDeOpciones.next();
            agregarBotonOpcion(opcion, vboxOpcionesDadas, vboxOpcionesGrupo1, vboxOpcionesGrupo2, botonPasarAGrupo1, botonPasarAGrupo2, botonOk, botonYOpcionSelecc);
        }
        randomizarVBox(vboxOpcionesDadas);
        botonPasarAGrupo1.setOnAction(new MoverOpcionesAGrupo(botonYOpcionSelecc, vboxOpcionesDadas, vboxOpcionesGrupo1, botonOk, kahoot, true));
        botonPasarAGrupo2.setOnAction(new MoverOpcionesAGrupo(botonYOpcionSelecc, vboxOpcionesDadas, vboxOpcionesGrupo2, botonOk, kahoot, false));

        //seteo de contenedores
        VBox opciones = new VBox();
        opciones.getChildren().addAll(menuInteractivo);
        opciones.setAlignment(Pos.CENTER);
        menuInteractivo.getChildren().addAll(vboxOpcionesGrupo1, botonPasarAGrupo1, vboxOpcionesDadas, botonPasarAGrupo2, vboxOpcionesGrupo2);
        menuInteractivo.setAlignment(Pos.CENTER);
        menuInteractivo.setSpacing(50);
        return opciones;
    }

    void agregarBotonOpcion(Opcion opcion, VBox grupoDado, VBox grupo1, VBox grupo2, Button pasarAGrupo1, Button pasarAGrupo2, Button botonOk, HashMap botonYOpcion){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        grupoDado.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        botonOpcion.setOnAction(new SeleccionarOpcionGroupChoice(botonOpcion, pasarAGrupo1, pasarAGrupo2, grupo1, grupo2, grupoDado, botonOk, opcion, kahoot, botonYOpcion));
    }



}