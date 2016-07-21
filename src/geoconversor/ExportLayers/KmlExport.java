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
package geoconversor.ExportLayers;

import geoconversor.Models.PointModel;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author elidioxg
 */
public class KmlExport {

    /**
     * Create a KML layer with points geometry
     *
     * @param filename
     * @param points
     */
    public static void kmlPointLayer(String filename, ArrayList<PointModel> points) {
        PrintWriter pw = null;
        String altitude;
        try {
            pw = new PrintWriter(filename);
            BufferedWriter bw = new BufferedWriter(pw);
            bw.write("<?xml version='1.0' encoding='UTF-8'?>");
            bw.newLine();
            bw.write("<kml xmlns='http://www.opengis.net/kml/2.2'>");
            bw.newLine();
            bw.write("<Document>");
            bw.newLine();
            bw.write("<name> GeoConversor </name>");
            if (points != null) {
                for (int i = 0; i < points.size(); i++) {
                    bw.write("  <Placemark>");
                    bw.newLine();
                    bw.write("    <name> " + points.get(i).getName() + " </name>");
                    bw.newLine();
                    bw.write("    <visibility>1</visibility>");
                    bw.newLine();
                    bw.write("    <description> " + points.get(i).getDescription() + "</description>");
                    bw.newLine();
                    bw.write("    <Point>");
                    if (points.get(i).getAltitude().isEmpty()) {
                        altitude = "0";
                    } else {
                        altitude = points.get(i).getAltitude();
                    }
                    bw.write("      <coordinates>" + points.get(i).getLongitude()
                            + "," + points.get(i).getLatitude() + ","
                            + altitude + "</coordinates>");
                    bw.write("    </Point>");
                    bw.newLine();
                    bw.write("</Placemark>");
                    bw.newLine();
                }
            }
            bw.write("</Document>");
            bw.newLine();
            bw.write("</kml>");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
