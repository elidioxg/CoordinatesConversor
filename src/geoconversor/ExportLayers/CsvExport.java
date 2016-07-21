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
package geoconversor.ExportLayers;

import geoconversor.Models.PointModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author elidioxg
 */
public class CsvExport {

    /**
     *
     * @param filename
     * @param sep
     * @param pm
     */
    public static void csvLayer(String filename, String sep,
            ArrayList<PointModel> points) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(filename);
            BufferedWriter bw = new BufferedWriter(pw);
            bw.write("name, latitude, longitude, altitude, date, sector, north, east, "
                    + "description");
            if (points != null) {
                for (int i = 0; i < points.size(); i++) {
                    bw.write(points.get(i).getName() + sep);
                    bw.write(points.get(i).getLatitude() + sep);
                    bw.write(points.get(i).getLongitude() + sep);
                    bw.write(points.get(i).getAltitude() + sep);
                    bw.write(points.get(i).getData() + sep);
                    bw.write(points.get(i).getSector() + sep);
                    bw.write(points.get(i).getNorth() + sep);
                    bw.write(points.get(i).getEast() + sep);
                    bw.write(points.get(i).getDescription());
                    bw.newLine();
                }
            }
            bw.close();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
