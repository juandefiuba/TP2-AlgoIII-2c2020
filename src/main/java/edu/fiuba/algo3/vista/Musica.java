package edu.fiuba.algo3.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Musica {

    private static MediaPlayer mediaPlayer = null;
    private static boolean  estaPausado;

    public static void musicaPlay(String rutaArchivoMusica) {
        if(mediaPlayer != null) { mediaPlayer.stop(); }
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);

        //LOOP MÚSICA
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        estaPausado = false;
        mediaPlayer.play();
    }


    public static void musicaPlayOPausa() {
        if (estaPausado) {
            musicaReanudar();
        } else {
            musicaPause();
        }
    }

    public static void musicaPause() {
        mediaPlayer.pause();
        estaPausado = true;
    }

    //Debe tener un archivo cargado antes desde musicaPlay
    public static void musicaReanudar() {
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        estaPausado = false;
    }

}
