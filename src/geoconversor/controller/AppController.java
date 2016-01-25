
package geoconversor.controller;

import geoconversor.conversion.CoordinateConversion;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppController {

    @FXML protected TextField tfUtmSector;
    @FXML protected TextField tfUtmNorth;
    @FXML protected TextField tfUtmEast;
    @FXML protected TextField tfLatitude;
    @FXML protected TextField tfLongitude;
    
    @FXML
    protected void convertUTM(){
        tfUtmSector.lookup("tfSector");
        tfUtmNorth.lookup("tfNorth");
        tfUtmEast.lookup("tfEast");
        //validate sector format
        String strSector  = tfUtmSector.getCharacters().toString();
        String strSec[] = strSector.split(" ");
        String strNorth = tfUtmNorth.getCharacters().toString().trim();
        String strEast = tfUtmEast.getCharacters().toString().trim();
        String strUtm =strSec[0]+" "+strSec[1]+" "+strNorth+" "+strEast;
        CoordinateConversion cc = new CoordinateConversion();
        double[] latlon = cc.utm2LatLon(strUtm);    
    }
    @FXML
    protected void convertDec(){
        tfLatitude.lookup("tfLat");
        tfLongitude.lookup("tfLon");    
    }    
}
