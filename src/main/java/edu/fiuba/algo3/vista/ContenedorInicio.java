package edu.fiuba.algo3.vista;


import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorInicio extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorInicio(Stage stage) {
        this.setMenu(stage);
    }


    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }


    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}