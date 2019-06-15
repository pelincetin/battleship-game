/*
 * Player.java - blueprint class for objects that represent a single
 * "random" player in the game of Battleship.
 * 
 * Computer Science S-111, Harvard University
 */

import java.util.*;

public class Player {
    // a constant for the maximum number of ships per player
    public static final int SHIPS_PER_PLAYER = 5; 
    
    // fields
    private String name;
    private Ship [] ships;
    private int numShips;
    
    // PS 5: add the fields for the player's collection of ships
    
    
    /*
     * constructor for a Player with the specified name
     */
    public Player(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("name must have at least one character");
        }
        this.name = name;
        this.ships = new Ship [SHIPS_PER_PLAYER];
        this.numShips = numShips;
        numShips = 0;
    }
    
    /*
     * getName - returns the name of the player
     */
    public String getName() {
        return this.name;
    }
    
    /*
     * addShip - add the specified ship to the player's collection of ships
     */
    public void addShip(Ship s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        if (numShips == ships.length){
            throw new IllegalStateException("You have maximum number of ships.");
        }
        for (int i = 0;i<ships.length; i++){
            if (ships[i] == null){
                ships[i] = s;
                numShips ++;
                break;
            }
        }
    }
    
    /*
     * removeShip - removes the specified ship from the player's collection of ships
     */
    public void removeShip(Ship s) {
        if (s == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        for (int i = 0;i<ships.length; i++){
            if (ships[i].equals(s)){
                ships[i] = null;
                Ship removed = ships [numShips-1];
                ships [i] = removed;
                ships [numShips-1] = null;
                numShips --;
                break;
            }
        }
       return; 
    }
    
    /*
     * printShips - prints whatever ships remain in the player's collection
     */
    public void printShips() {
        for (int i =0; i<numShips; i ++){
            System.out.println(ships[i].toString());
        }
    }
    
    /*
     * hasLost - has this player lost the game?
     * Returns true if this is the case, and false otherwise.
     */
    public boolean hasLost() {
        if(this.numShips == 0){
            return true;
        }else{
            return false;
        }
    }
    
    /*
     * nextGuess - returns a Guess object representing the player's
     * next guess for the location of a ship on the board specified
     * by the parameter otherBoard.
     */
    public Guess nextGuess(Scanner console, Board otherBoard) {
        int row;
        int col;
        
        // Keep randomly selecting coordinates until we get 
        // a position that has not already been tried.
        do {
            row = Board.RAND.nextInt(otherBoard.getDimension());
            col = Board.RAND.nextInt(otherBoard.getDimension());
        } while (otherBoard.hasBeenTried(row, col));
        
        Guess guess = new Guess(row, col);
        return guess;
    }
    
    /*
     * toString - returns a string representation of the player
     */
    public String toString() {
        return this.name;
    }
}