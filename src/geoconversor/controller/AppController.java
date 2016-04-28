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
package geoconversor.controller;

/**
 * FXML Controller class
 *
 * @author elidioxg
 */

import geoconversor.GeoConversor;
import geoconversor.Models.PointModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

public class AppController implements Initializable{
    
    @FXML 
    protected TextArea taName, taDescription, taLatitude, taLongitude, taSector, 
            taEast, taNorth, taLatDeg, taLatMin, taLatSeg, taLonDeg, taLonMin, 
            taLonSeg;
    
    @FXML Button bAddToList;
    
    /**
     * Get the properties of point to add to ListView
     * This handle the action for "Button Add Point"
     */
    @FXML
    protected void getPointProperties(){
        PointModel pm = new PointModel();
        pm.setName(taName.getText());
        pm.setDescription(taDescription.getText());
        pm.setLatidude(taLatitude.getText());
        pm.setLongitude(taLongitude.getText());
        pm.setSector(taSector.getText());
        pm.setNorth(taNorth.getText());
        pm.setEast(taEast.getText());
        GeoConversor.getInstance().addToList(pm);
    }
    
    /**
     * Add converted coordinates to TextAreas
     * @param point 
     */
    public void setLabelTexts(PointModel point){
        taLatitude.setText(point.getLatitude());
        taLongitude.setText(point.getLongitude());
        taSector.setText(point.getSector());
        taNorth.setText(point.getNorth());
        taEast.setText(point.getEast());
    }
    
    @FXML
    protected ListView lvPoints;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvPoints.setCellFactory(new Callback<ListView<PointModel>, 
                ListCell<PointModel>>() {
            @Override
            public ListCell<PointModel> call(ListView<PointModel> param) {
                ListCell<PointModel> cell = new ListCell<PointModel>(){
                
                }
            }
        });
    }
        
}
