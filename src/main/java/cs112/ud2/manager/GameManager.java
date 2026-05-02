package cs112.ud2.manager;

import cs112.ud2.model.Player;
import cs112.ud2.model.Ship;
/**
 * GameManager.java
 *    ─ Player
 *    ─ ResourceManager
 *    ─ Fleet logic
 * The main manager that controllers communicate with
 */
public class GameManager {

    private static GameManager instance;

    private final Player player;

    private GameManager() {
        this.player = new Player("Commander");

        // Starting ships for testing
        player.addShip(new Ship("Alpha Miner", 150, 45, 30, 15,0));
        player.addShip(new Ship("Beta Fighter", 200, 10, 10, 5, 50));
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public ResourceManager getResources() {
        return player.getResources();
    }

    /********** FLEET **********/
    public boolean canAddShip() {
        return player.canAddShip();
    }

    public boolean addShip(Ship ship) {
        return player.addShip(ship);
    }

    /********** RESOURCES **********/
    public void addMinerals(int amount) { player.getResources().addMinerals(amount); }
    public void addSalvage(int amount) { player.getResources().addSalvage(amount); }
    public void addEnergy(int amount) { player.getResources().addEnergy(amount); }
    public void addCredits(int amount) { player.getResources().addCredits(amount); }

    public boolean spendMinerals(int amount) {
        return player.getResources().spendMinerals(amount);
    }

    public boolean spendSalvage(int amount) {
        return player.getResources().spendSalvage(amount);
    }

    public boolean spendEnergy(int amount) {
        return player.getResources().spendEnergy(amount);
    }

    public boolean spendCredits(int amount) {
        return player.getResources().spendCredits(amount);
    }
}