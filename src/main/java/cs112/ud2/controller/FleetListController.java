package cs112.ud2.controller;

import cs112.ud2.model.Ship;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class FleetListController {

    @FXML private Button shipInventoryButton00;
    @FXML private Button shipInventoryButton01;
    @FXML private Button shipInventoryButton02;
    @FXML private Button shipInventoryButton03;
    @FXML private Button shipInventoryButton04;
    @FXML private Button shipInventoryButton05;
    @FXML private Button shipInventoryButton06;
    @FXML private Button shipInventoryButton07;
    @FXML private Button shipInventoryButton08;
    @FXML private Button shipInventoryButton09;
    @FXML private Button shipInventoryButton10;
    @FXML private Button shipInventoryButton11;
    @FXML private Button shipInventoryButton12;
    @FXML private Button shipInventoryButton13;
    @FXML private Button shipInventoryButton14;

    private ActiveShipController activeShipController;
    private Ship currentlySelectedShip = null;   // Track which ship is selected

    public void setActiveShipController(ActiveShipController controller) {
        this.activeShipController = controller;
    }

    /**
     * Updates the fleet list - shows only as many buttons as there are ships
     */
    public void setFleet(List<Ship> fleet) {
        Button[] buttons = {
                shipInventoryButton00, shipInventoryButton01, shipInventoryButton02,
                shipInventoryButton03, shipInventoryButton04, shipInventoryButton05,
                shipInventoryButton06, shipInventoryButton07, shipInventoryButton08,
                shipInventoryButton09, shipInventoryButton10, shipInventoryButton11,
                shipInventoryButton12, shipInventoryButton13, shipInventoryButton14
        };

        // Hide all buttons first
        for (Button btn : buttons) {
            btn.setVisible(false);
            btn.setGraphic(null);
            btn.setOnMouseClicked(null);
        }

        // Populate only the buttons we need
        for (int i = 0; i < fleet.size() && i < buttons.length; i++) {
            Ship ship = fleet.get(i);
            Button button = buttons[i];

            // Create placeholder icon
            ImageView icon = new ImageView();
            icon.setFitWidth(26);
            icon.setFitHeight(26);
            icon.setPreserveRatio(true);

            button.setGraphic(icon);
            button.setVisible(true);

            // Click handler with toggle logic
            final Ship currentShip = ship;
            button.setOnMouseClicked((MouseEvent e) -> {
                if (activeShipController != null) {
                    if (currentlySelectedShip == currentShip) {
                        // Clicked the same ship again → hide panel
                        activeShipController.hidePanel();
                        currentlySelectedShip = null;
                    } else {
                        // New ship selected → show/update panel
                        activeShipController.updateWithShip(currentShip);
                        currentlySelectedShip = currentShip;
                    }
                }
            });
        }
    }
}