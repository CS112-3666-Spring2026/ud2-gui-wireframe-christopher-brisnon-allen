package cs112.ud2.model;

import java.util.ArrayList;
import java.util.List;
/********************************************
 *	AUTHORS: Christopher Brinson-Allen - CBA
 *   COLLABORATORS: Nadia Arani
 *	LAST MODIFIED:	04/08/2026
 *********************************************
 *	Fleet.java
 *********************************************
 *	PROGRAM DESCRIPTION:
 * Fleet manager, the players main ship, owns and manages collection of ships
 * this class is responsible for fleet capacity, adding ships, removing ships
 * and sending ships on missions - This is basically a container for main data
 *********************************************
 * TODO: Load/Save copy does it need to be a deep copy or will it suffice
 *	Fleet name
 *   Fleet hull (players overall health)
 *   Fleet capacity (how many total ships the fleet can have)
 *   Fleet ships (list of ships in the fleet)
 *       - helper methods to filter ships by abilities
 *********************************************/
public class Fleet {
    /**********CONSTANTS***********/
    private String name;
    private int hull;
    private int fleetCapacity;
    private List<Ship> ships;
    /**********CONSTRUCTORS***********/
    public Fleet() {
        this.name = "Unnamed Fleet";
        this.hull = 100;
        this.fleetCapacity = 10;
        this.ships = new ArrayList<>();
    }

    public Fleet(String name, int hull, int fleetCapacity) {
        setName(name);
        setHull(hull);
        this.fleetCapacity = Math.max(1, fleetCapacity);
        this.ships = new ArrayList<>();
    }
    // Copy Constructor - used to save/load
    /*TODO: I dont think this works the way I want it too, works for now.
     * I need to make this a deep copy?
     * works for now, but I will need to implement a better system for saving loading fleet info
     */
    public Fleet(Fleet other) {
        this.name = other.name;
        this.hull = other.hull;
        this.fleetCapacity = other.fleetCapacity;
        this.ships = new ArrayList<>(other.ships);
    }

    /**********SETTERS / MUTATORS***********/
    /**
     * Sets fleet name; falls back to "Unnamed Fleet" when input is null or blank.
     *
     * @param name fleet display name
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            this.name = "Unnamed Fleet";
            return;
        }
        this.name = name;
    }

    /**
     * Sets fleet hull integrity; negative values are clamped to 0.
     *
     * @param hull fleet hull value
     */
    public void setHull(int hull) {
        this.hull = Math.max(0, hull);
    }

    /**
     * Sets max fleet capacity.
     * If requested capacity is below current ship count, capacity is set to current count
     * to avoid invalid state. Minimum capacity is 1.
     *
     * @param fleetCapacity desired ship capacity
     */
    public void setFleetCapacity(int fleetCapacity) {
        if (fleetCapacity < ships.size()) {
            this.fleetCapacity = ships.size();
            return;
        }
        this.fleetCapacity = Math.max(1, fleetCapacity);
    }

    /**********GETTERS / ACCESSORS***********/
    public String getName() {
        return name;
    }

    public int getHull() {
        return hull;
    }

    public int getFleetCapacity() {
        return fleetCapacity;
    }

    public List<Ship> getFleet() {
        return getShips();
    }
    //returns copy of list so it won't be modified
    public List<Ship> getShips() {
        return new ArrayList<>(ships);
    }

    public int getCurrentShipCount() {
        return ships.size();
    }

    /********* OTHER REQUIRED METHODS *********/
    /**
     * Checks if can add another ship to fleet
     *
     * @return true if ship array is less than fleet capacity
     */
    public boolean canAddShip() {
        return ships.size() < fleetCapacity;
    }
    /**
     * Adds a ship to the fleet if there is space
     *
     * @return true if successful
     */
    public boolean addShip(Ship ship) {
        if (ship == null) {
            return false;
        }
        if (!canAddShip()) {
            return false; //at capacity
        }
        ships.add(ship);
        return true;
    }
    /********* HELPER METHODS *********/


    /****** OTHER REQUIRED METHODS ******/
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Fleet other))
            return false;

        return hull == other.hull &&
                fleetCapacity == other.fleetCapacity &&
                name.equals(other.name) &&
                ships.equals(other.ships);
    }
    @Override
    public String toString() {
        return String.format("Fleet: Name=%s, Hull=%d, Capacity=%d, Ship Count=%d",
                name, hull, fleetCapacity, ships.size());
    }
    /********* ABSTRACT METHODS *********/
}