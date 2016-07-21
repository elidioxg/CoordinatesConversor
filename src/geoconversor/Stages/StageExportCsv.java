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
package geoconversor.Stages;

import geoconversor.GeoConversor;
import geoconversor.Models.PointModel;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elidioxg
 */
public class StageExportCsv {

    /**
     * 
     * @param points 
     */
    public void createStage(ArrayList<PointModel> points) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    GeoConversor.class.getResource("views/stageCsvExport.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("GeoConversor - Export to CSV file");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {

        }
    }

}
