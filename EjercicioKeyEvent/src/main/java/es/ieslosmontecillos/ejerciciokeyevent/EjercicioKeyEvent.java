package es.ieslosmontecillos.ejerciciokeyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

///@author: Corina Cordobez
///@since 02/10/2024

public class EjercicioKeyEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Crear un Pane
        Pane pane = new Pane();

        //Crear el objeto Text en las coordenadas (20, 20) con el valor "A"
        Text texto = new Text(20, 20, "A");

        //Añadir el Text al Pane
        pane.getChildren().add(texto);

        //Manejar el evento de pulsación de teclas
        pane.setOnKeyPressed(evento -> {
            handleKeyPress(evento, texto);
        });

        //Crear la escena, añadir el Pane y habilitar que reciba foco para que se puedan detectar las teclas
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Mover Texto");

        //Hacer foco en el panel para que capture eventos de teclado
        pane.requestFocus();

        //Mostrar la ventana
        primaryStage.show();
    }

    private void handleKeyPress(KeyEvent evento, Text texto) {
        //Obtener el código de la tecla presionada
        KeyCode codigo = evento.getCode();

        //Estudiar las teclas de cursor y mover el texto
        switch (codigo) {
            case DOWN:
                texto.setY(texto.getY() + 10);  //Muevo 10 píxeles hacia abajo
                break;
            case UP:
                texto.setY(texto.getY() - 10);  //Muevo 10 píxeles hacia arriba
                break;
            case RIGHT:
                texto.setX(texto.getX() + 10);  //Muevo 10 píxeles a la derecha
                break;
            case LEFT:
                texto.setX(texto.getX() - 10);  //Muevo 10 píxeles a la izquierda
                break;
            default:
                //Si se presiona una letra o un dígito, se asigna ese valor al texto
                if (codigo.isLetterKey() || codigo.isDigitKey()) {
                    texto.setText(evento.getText().toUpperCase());  //Cambiar el texto al valor de la tecla
                }
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
