package edu.fiuba.algo3.vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.nio.file.Paths;

public class Musica {
    private static MediaPlayer mediaPlayer;


    public static void musicaPlay(String rutaArchivoMusica) {
        Media media = new Media(Paths.get(rutaArchivoMusica).toUri().toString());
        mediaPlayer = new MediaPlayer(media);

        //LOOP MÚSICA
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));

        mediaPlayer.play();
    }

    public static void musicaStop() {
        mediaPlayer.stop();
    }
}
