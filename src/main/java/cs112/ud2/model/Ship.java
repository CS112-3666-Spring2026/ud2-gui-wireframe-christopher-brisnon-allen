package cs112.ud2.model;

import java.util.Objects;
/********************************************
 *	AUTHORS: Christopher Brinson-Allen - CBA
 *   COLLABORATORS: Nadia Arani
 *	LAST MODIFIED:	04/08/2026
 *********************************************
 *	Ship.java
 *********************************************
 *	PROGRAM DESCRIPTION:
 * Abstract base class for all ships in the Fleet
 *********************************************
 * //TODO: Object hash values are not equal even though returning equals
 *	Ship name
 *   Ship type (default working class)
 *   Ship hull (health)
 *   Mission status (default available = true)
 *********************************************/
public class Ship {
    /**********INSTANCE VARIABLES***********/
    private String name;
    private int hull;
    private MissionStatus status;

    // Work-related abilities
    private int miningPower;
    private int salvagePower;
    private int scoutPower;

    // Combat-related ability
    private int combatPower;

    /**********CONSTRUCTORS***********/
    /**
     * Default constructor that creates a basic ship with no abilities.
     */
    public Ship() {
        this.name = "Unnamed Ship";
        this.hull = 100;
        this.status = MissionStatus.AVAILABLE;
        this.miningPower = 0;
        this.salvagePower = 0;
        this.scoutPower = 0;
        this.combatPower = 0;
    }

    /**
     * Full constructor used to create a ship with chosen capabilities.
     * Mission state starts as AVAILABLE with no active mission timer.
     * Player can decide which abilities to utilize.
     *
     * @param name display name for the ship
     * @param hull hull integrity value
     * @param miningPower ability for mining operations
     * @param salvagePower ability for salvage operations
     * @param scoutPower ability for scouting operations
     * @param combatPower ability for combat operations
     */
    public Ship(String name, int hull, int miningPower, int salvagePower, int scoutPower, int combatPower) {
        setName(name);
        setHull(hull);
        this.miningPower = Math.max(0, miningPower);
        this.salvagePower = Math.max(0, salvagePower);
        this.scoutPower = Math.max(0, scoutPower);
        this.combatPower = Math.max(0, combatPower);
        this.status = MissionStatus.AVAILABLE;
    }

    /**
     * Copy constructor that duplicates another ship's current state.
     *
     * @param other ship to copy
     */
    public Ship(Ship other) {
        this.name = other.name;
        this.hull = other.hull;
        this.status = other.status;
        this.miningPower = other.miningPower;
        this.salvagePower = other.salvagePower;
        this.scoutPower = other.scoutPower;
        this.combatPower = other.combatPower;
    }

    /**********SETTERS / MUTATORS***********/
    /**
     * Sets ship name falls back to "Unnamed Ship" when input is null or blank.
     *
     * @param name ship display name
     */
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            this.name = "Unnamed Ship";
            return;
        }
        this.name = name;
    }

    /**
     * Sets hull integrity negative values are clamped to 0.
     *
     * @param hull hull integrity value
     */
    public void setHull(int hull) {
        this.hull = Math.max(0, hull);
    }

    /**
     * Sets mission status defaults to AVAILABLE when null.
     *
     * @param status current assignment state
     */
    public void setStatus(MissionStatus status) {
        this.status = (status == null) ? MissionStatus.AVAILABLE : status;
    }
    /**********GETTERS / ACCESSORS***********/
    public String getName() {
        return name;
    }

    public int getHull() {
        return hull;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public int getMiningPower() {
        return miningPower;
    }

    public int getSalvagePower() {
        return salvagePower;
    }

    public int getScoutPower() {
        return scoutPower;
    }

    public int getCombatPower() {
        return combatPower;
    }

    /********* OTHER REQUIRED METHODS *********/
    public boolean isAvailable() {
        return status == MissionStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Ship other))
            return false;

        return hull == other.hull &&
                miningPower == other.miningPower &&
                salvagePower == other.salvagePower &&
                scoutPower == other.scoutPower &&
                combatPower == other.combatPower &&
                Objects.equals(name, other.name) &&
                status == other.status;
    }
    /**
     * Builds a hash value from the same fields used in equals so hash-based
     * to check for if actually equals outside of integer value.
     *
     * @return hash code for this ship state
     * TODO: When objects equal returns true objects hash codes are different
     * I believe I want the hash codes to be equal when objects are equal
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, hull, status, miningPower, salvagePower, scoutPower, combatPower);
    }

    @Override
    public String toString() {
        return String.format(
                "Ship[name=%s, hull=%d, status=%s, mining=%d, salvage=%d, scout=%d, combat=%d]",
                name, hull, status, miningPower, salvagePower, scoutPower, combatPower
        );
    }

    /********* HELPER METHODS *********/
}

enum MissionStatus {
    AVAILABLE,
    ON_MISSION,
    DAMAGED,
    DESTROYED,
    IN_SQUAD
}