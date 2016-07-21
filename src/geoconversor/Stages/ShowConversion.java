/*
 * Copyright (C) 2016 elidioxg
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package geoconversor.Stages;

import geoconversor.GeoConversor;
import geoconversor.Models.PointModel;
import geoconversor.controller.AppController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elidioxg
 */
public class ShowConversion {
    
    /**
     * Create a stage to visualize the coordinates converted
     * @param point 
     */
    public void createStage(PointModel point){
       
        try{
            FXMLLoader loader = new FXMLLoader(
              GeoConversor.class.getResource("views/stageViewPoint.fxml"));
            
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            AppController controller;
            
            controller = loader.getController();
            controller.setLabelTexts(point);
            stage.setTitle("Coordinates Converted");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
