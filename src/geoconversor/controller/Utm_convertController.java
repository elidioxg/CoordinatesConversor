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

import geoconversor.Models.PointModel;
import geoconversor.conversion.Convert;
import static geoconversor.conversion.Convert.convert;
import geoconversor.Stages.ShowConversion;
import geoconversor.Utils.GetTime;
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
public class Utm_convertController implements Initializable {

    private final String formatString = "%.5f";
    @FXML protected TextField tfSector;
    @FXML protected TextField tfNorth;
    @FXML protected TextField tfEast;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    protected void convertUTM(){       
        String strSector  = tfSector.getCharacters().toString();    
        String strNorth = tfNorth.getCharacters().toString().trim();
        String strEast = tfEast.getCharacters().toString().trim();

        double latlon[] = convert(strSector, strNorth,strEast); 
        
        String[] latDms = Convert.convert(String.format(formatString, latlon[0]));
        String[] lonDms = Convert.convert(String.format(formatString, latlon[1]));
        
        
        PointModel pm = new PointModel();
        pm.setLatidude(String.format(formatString, latlon[0]));
        pm.setLongitude(String.format(formatString, latlon[1]));
        pm.setSector(strSector);
        pm.setNorth(strNorth);
        pm.setEast(strEast);
        pm.setLatDms(latDms[0]+" "+latDms[1]+" "+latDms[2]);
        pm.setLonDms(lonDms[0]+" "+lonDms[1]+" "+lonDms[2]);
        pm.setTime(GetTime.getTimeFmt());
               
        ShowConversion show = new ShowConversion();
        show.createStage(pm);
    }
    
}
