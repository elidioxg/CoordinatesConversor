
package geoconversor.controller;

import geoconversor.conversion.CoordinateConversion;
import geoconversor.conversion.DMSConversion;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AppController {

    @FXML protected TextField tfSector;
    @FXML protected TextField tfNorth;
    @FXML protected TextField tfEast;
    @FXML protected TextField tfLatitude;
    @FXML protected TextField tfLongitude;
    @FXML protected TextField tfLatDeg;
    @FXML protected TextField tfLatMin;
    @FXML protected TextField tfLatSec;
    @FXML protected TextField tfLonDeg;
    @FXML protected TextField tfLonMin;
    @FXML protected TextField tfLonSec;
    
    //TO DO: validate, convert to all coord. systems on button clicked
    @FXML
    protected void convertUTM(){       
        String strSector  = tfSector.getCharacters().toString();        
        String strNorth = tfNorth.getCharacters().toString().trim();
        String strEast = tfEast.getCharacters().toString().trim();
        double latlon[] = convert(strSector, strNorth,strEast);                
        tfLatitude.setText(String.format(" %.4f", latlon[0]));
        tfLongitude.setText(String.format(" %.4f", latlon[1]));
    }
    @FXML
    protected void convertDec(){
        String lat = tfLatitude.getText();
        String lon = tfLongitude.getText();
        String strUtm[] = convert(lat, lon);                
        tfSector.setText(strUtm[0]+" "+strUtm[1]);
        tfNorth.setText(strUtm[2]+" m");
        tfEast.setText(strUtm[3]+" m");
    }    
    
    @FXML 
    protected void convertDMS(){        
        DMSConversion dms = new DMSConversion();
        String latDeg = tfLatDeg.getText();
        String latMin = tfLatMin.getText();
        String latSec = tfLatSec.getText();
        // TO DO: implement checkbox with N/S and E/W
        boolean latSignal = true;
        tfLatitude.setText(dms.convertToDegrees(latSignal, latDeg, latMin, latSec));
        String lonDeg = tfLonDeg.getText();
        String lonMin = tfLonMin.getText();
        String lonSec = tfLonSec.getText();
        boolean lonSignal = true;
        tfLongitude.setText(dms.convertToDegrees(lonSignal, lonDeg, lonMin, lonSec));        
    }
    private String[] convert(String lat, String lon){
        CoordinateConversion cc = new CoordinateConversion();
        String utm = cc.latLon2UTM(Double.parseDouble(lat),
                Double.parseDouble(lon));
        utm = utm.replace(",", ".");
        String strUtm[] = utm.split(" ");
        return strUtm;
    }
    private double[] convert(String sector, String north, String east){
        String strSec[] = sector.split(" ");
        String strUtm =strSec[0]+" "+strSec[1]+" "+north+" "+east;        
        CoordinateConversion cc = new CoordinateConversion();
        double[] latlon = cc.utm2LatLon(strUtm);            
        return latlon;
    }
    
}
