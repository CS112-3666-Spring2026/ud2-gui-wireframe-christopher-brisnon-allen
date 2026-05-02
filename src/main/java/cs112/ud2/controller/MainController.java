package cs112.ud2.controller;

import cs112.ud2.manager.GameManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import java.io.IOException;
/**
 * MainController.java
 *    - FleetListController
 *    - ActiveShipController
 *    - GameplayController
 *    - ResourceController
 *      -> Calls initializeData() which sets up GameManager
 * Loads panels, connects controllers, initializes game, primarily
 * button logic
 */
public class MainController {

    @FXML
    private StackPane mainContentArea;
    @FXML
    private GameplayController gameplayController;
    @FXML
    private ResourceController resourceViewController;

    @FXML
    public void initialize() throws IOException {
        loadGameplayView();
    }

    /**
     * Loads the gameplay-view into the main content area
     */
    private void loadGameplayView() throws IOException {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/cs112/ud2/gameplay-view.fxml")
            );

            javafx.scene.Parent gameplayView = loader.load();
            gameplayController = loader.getController();

            // Add the view to the screen
            mainContentArea.getChildren().clear();
            mainContentArea.getChildren().add(gameplayView);
    }

    /**
     * Called after UI is shown to initialize game data
     */
    public void initializeData() {
        GameManager gm = GameManager.getInstance();

        // Connect GameplayController
        if (gameplayController != null) {
            gameplayController.setGameManager(gm);
            gameplayController.setResourceController(resourceViewController);
        }

        // Connect ResourceController
        if (resourceViewController != null) {
            resourceViewController.setGameManager(gm);
        }
    }
}