package cs112.ud2.controller;

import cs112.ud2.manager.GameManager;
import javafx.fxml.FXML;
/**
 * GamePlayController.java
 * Controls game state directly, currently debug test view primarily.
 */
public class GameplayController {

    private GameManager gameManager;
    private ResourceController resourceController;

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void setResourceController(ResourceController resourceController) {
        this.resourceController = resourceController;
    }

    private void refreshResources() {
        if (resourceController != null) {
            resourceController.updateAllResources();
        }
    }

    /********** RESOURCES BUTTONS **********/

    @FXML
    public void addMinerals() {
        if (gameManager != null) {
            gameManager.addMinerals(100);
            refreshResources();
        }
    }

    @FXML
    public void addSalvage() {
        if (gameManager != null) {
            gameManager.addSalvage(100);
            refreshResources();
        }
    }

    @FXML
    public void addEnergy() {
        if (gameManager != null) {
            gameManager.addEnergy(100);
            refreshResources();
        }
    }

    @FXML
    public void addCredits() {
        if (gameManager != null) {
            gameManager.addCredits(200);
            refreshResources();
        }
    }

    @FXML
    public void subtractMinerals() {
        if (gameManager != null) {
            gameManager.spendMinerals(50);
            refreshResources();
        }
    }

    @FXML
    public void subtractSalvage() {
        if (gameManager != null) {
            gameManager.spendSalvage(50);
            refreshResources();
        }
    }
    @FXML
    public void subtractEnergy() {
        if (gameManager != null) {
            gameManager.spendEnergy(50);
            refreshResources();
        }
    }
    @FXML
    public void subtractCredits() {
        if (gameManager != null) {
            gameManager.spendCredits(50);
            refreshResources();
        }
    }
}