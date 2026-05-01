package cs112.ud2.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private StackPane mainContentArea;

    private GameplayController gameplayController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadGameplayView();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

            mainContentArea.getChildren().clear();
            mainContentArea.getChildren().add(gameplayView);
    }

    /**
     * Called after UI is shown to initialize test data
     */
    public void initializeData() {
        if (gameplayController != null) {
            gameplayController.setMainController(this);
        }
    }
}