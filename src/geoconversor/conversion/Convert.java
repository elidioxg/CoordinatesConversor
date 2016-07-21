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
package geoconversor.conversion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elidioxg
 */
public class Convert {
    
    /**
     * Convert from decimal degrees to degrees, minutes and seconds
     * @param deg Latitude or Longitude in decimal degrees
     * @return 
     */
    public static String[] convert(String deg){        
        Double degrees = Double.parseDouble(deg);
        DMSConversion conversion = new DMSConversion();
        String dms = conversion.convertFromDegrees(degrees);
        System.out.println("DMS: "+dms);
        String Dms[] = dms.split(" ");
        return Dms;
    }

    /**
     * 
     * @param lat Latitude in decimal degrees
     * @param lon Longitude in decimal degrees
     * @return String with UTM Coordinates
     */
    public static String[] convert(String lat, String lon) {
        lat = lat.replace(",", ".");
        lon = lon.replace(",", ".");
        double latitude = Double.parseDouble(lat);
        double longitude = Double.parseDouble(lon);
        ValidateConversion vc = new ValidateConversion();
        int error = vc.validate(latitude, longitude);
        if (error == 0) {
            CoordinateConversion cc = new CoordinateConversion();
            String utm = cc.latLon2UTM(latitude, longitude);
            utm = utm.replace(",", ".");
            String strUtm[] = utm.split(" ");
            return strUtm;
        }
        return null;
    }

    /**
     * 
     * @param sector
     * @param north
     * @param east
     * @return 
     */
    public static double[] convert(String sector, String north, String east) {
        ValidateConversion vc = new ValidateConversion();
        int error = vc.validate(sector, north, east);
        if (error == 0) {
            String strSec[] = sector.split(" ");
            String strUtm = strSec[0] + " " + strSec[1] + " " + east + " " + north;
            CoordinateConversion cc = new CoordinateConversion();
            double[] latlon = cc.utm2LatLon(strUtm);
            return latlon;
        }
        return null;
    }

    public static ArrayList convert(boolean latSignal, String latGrau, String latMin,
            String latSec, boolean lonSignal, String lonGrau, String lonMin,
            String lonSec) {
        ValidateConversion vc = new ValidateConversion();
        int error = vc.validate(latGrau, latMin, latSec, lonGrau, lonMin, lonSec);
        if (error == 0) {
            DMSConversion dms = new DMSConversion();
            String latitude = dms.convertToDegrees(latSignal, latGrau, latMin, latSec);
            String longitude = dms.convertToDegrees(lonSignal, lonGrau, lonMin, lonSec);
            List aux = new ArrayList<>();
            aux.add(latitude);
            aux.add(longitude);
            return (ArrayList) aux;
        }
        return null;
    }

}
