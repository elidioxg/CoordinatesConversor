/*
 * Copyright (C) 2016 exg
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

import static geoconversor.conversion.Convert.convert;
import geoconversor.conversion.DMSConversion;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author exg
 */
public class Dms_convertController implements Initializable {
        
    @FXML protected TextField tfLatDeg;
    @FXML protected TextField tfLatMin;
    @FXML protected TextField tfLatSec;
    @FXML protected TextField tfLonDeg;
    @FXML protected TextField tfLonMin;
    @FXML protected TextField tfLonSec;
            
    @FXML protected RadioButton rbLatitude;
    @FXML protected RadioButton rbLongitude;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML 
    protected void convertDMS(){        
        DMSConversion dms = new DMSConversion();
        String latDeg = tfLatDeg.getText();
        String latMin = tfLatMin.getText();
        String latSec = tfLatSec.getText();
        String lonDeg = tfLonDeg.getText();
        String lonMin = tfLonMin.getText();
        String lonSec = tfLonSec.getText();
        boolean latSignal = true;
        if(!rbLatitude.isSelected()){ 
            latSignal = false;
        }        
        boolean lonSignal = true;
        if(!rbLongitude.isSelected()){
            lonSignal = false;
        }
        List list = new ArrayList<>();
        list = convert(latSignal,latDeg, latMin, latSec, lonSignal,lonDeg, lonMin, lonSec);        
        //tfLatitude.setText(list.get(0).toString());       
        //tfLongitude.setText(list.get(1).toString());
    }
}
