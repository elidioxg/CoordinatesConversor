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

import static geoconversor.conversion.Convert.convert;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author elidioxg
 */
public class Latlon_convertController implements Initializable {

    @FXML protected TextField tfLatitude;
    @FXML protected TextField tfLongitude;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    protected void convertDec(){
        String lat = tfLatitude.getText();
        String lon = tfLongitude.getText();
        String strUtm[] = convert(lat, lon);                
        //tfSector.setText(strUtm[0]+" "+strUtm[1]);
        //tfNorth.setText(strUtm[2]+" m");
        //tfEast.setText(strUtm[3]+" m");
    }    
    
}
