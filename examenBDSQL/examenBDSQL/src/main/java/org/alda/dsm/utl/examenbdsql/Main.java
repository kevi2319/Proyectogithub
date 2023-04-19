package org.alda.dsm.utl.examenbdsql;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root= FXMLLoader.load(Main.class.getResource("formularioAlumno.fxml"));
        Scene scene=new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Alumno");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
