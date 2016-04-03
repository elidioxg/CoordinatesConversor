
package geoconversor.controller;

import geoconversor.conversion.CoordinateConversion;
import geoconversor.conversion.DMSConversion;
import geoconversor.conversion.ValidateConversion;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAttribute;
import javafx.scene.control.RadioButton;
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
    
    @FXML protected RadioButton rbLatitude;
    @FXML protected RadioButton rbLongitude;
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
        tfLatitude.setText(list.get(0).toString());       
        tfLongitude.setText(list.get(1).toString());
    }
    private String[] convert(String lat, String lon){
        lat = lat.replace(",", ".");
        lon = lon.replace(",", ".");
        double latitude = Double.parseDouble(lat);
        double longitude = Double.parseDouble(lon);
        ValidateConversion vc = new ValidateConversion();
        int error = vc.validate(latitude, longitude);
        if(error==0){
            CoordinateConversion cc = new CoordinateConversion();
            String utm = cc.latLon2UTM(latitude, longitude);
            utm = utm.replace(",", ".");
            String strUtm[] = utm.split(" ");
            return strUtm;
        }
        return null;
    }
    private double[] convert(String sector, String north, String east){
        ValidateConversion vc = new ValidateConversion();
        int error = vc.validate(sector, north, east);
        if(error ==0){
            String strSec[] = sector.split(" ");
            String strUtm =strSec[0]+" "+strSec[1]+" "+north+" "+east;        
            CoordinateConversion cc = new CoordinateConversion();
            double[] latlon = cc.utm2LatLon(strUtm);            
            return latlon;
        }
        return null;
    }

    private ArrayList convert(boolean latSignal, String latGrau, String latMin, 
            String latSec, boolean lonSignal, String lonGrau, String lonMin, 
            String lonSec){
        ValidateConversion vc = new ValidateConversion();
        int error = vc.validate(latGrau, latMin, latSec, lonGrau, lonMin, lonSec);
        if(error == 0){
            DMSConversion dms = new DMSConversion();
            String latitude = dms.convertToDegrees(latSignal, latGrau, latMin, latSec);                      
            String longitude = dms.convertToDegrees(lonSignal, lonGrau, lonMin, lonSec);    
            List aux = new ArrayList<>();
            aux.add(latitude);
            aux.add(longitude);
            return (ArrayList)aux;
            
        }        
        return null;
    }
}
