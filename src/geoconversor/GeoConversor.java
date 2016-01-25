/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoconversor;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GeoConversor extends Application {
    private static GeoConversor instance;    
    private static final String AppTitle = "GeoConversor";
    public GeoConversor(){
        instance = this;
    }
    public static GeoConversor getInstance(){
        return instance;
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("views/main.fxml"));
        GridPane grid = loader.load();                              
        
        Scene scene = new Scene(grid);
        
        primaryStage.setTitle(AppTitle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
