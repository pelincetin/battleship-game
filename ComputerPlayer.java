import java.util.*;

public class ComputerPlayer extends Player {
    private Guess guess;
    private int count;
    private int numHit;
    private Guess previousGuess;
    private int row;
    private int col;
    
    
    /*
     * This is the constructor of the class
     */
    public ComputerPlayer (String name) {
        super (name);
        this.count = count;
        this.numHit = numHit;
        this.row = 0;
        this.col = 0;
        this.previousGuess = new Guess (row,col);
        count = 0;
    }
    
    /* 
     * This method is responsible for the next guess of the computer.
     */
    public Guess nextGuess (Scanner console, Board otherBoard){        
        //this if statement is for the first guess
        if (count == 0){
            row = Board.RAND.nextInt(otherBoard.getDimension());
            col = Board.RAND.nextInt(otherBoard.getDimension());
            previousGuess = new Guess (row,col);
            count++;
        }else if(otherBoard.previousHit (row,col)){        //if the first guess is a hit
            previousGuess = adjacent(otherBoard);
            return previousGuess;
        }else if (otherBoard.previousMiss (row,col)){      //if the first guess is a miss
            return super.nextGuess (console, otherBoard);
        }else if (otherBoard.sunkShipAt (row,col)){
            return super.nextGuess (console, otherBoard);  // if the ship is sunk
        }
        return previousGuess;
    }
    
    /*
     * This method is tomake the next guess an adjacent of the previous guess
     */
    public Guess adjacent (Board otherBoard){
        Guess guess = new Guess(row, col);
        int choice1 = this.previousGuess.getRow()-1;
        int choice2 = this.previousGuess.getRow()+1;
        int choice3 = this.previousGuess.getColumn() -1;
        int choice4 = this.previousGuess.getColumn()+1;
        if (choice1 +1 >-1 && 8>choice1 +1 && col>-1 && 8>col &&!otherBoard.hasBeenTried (choice1, col)){
            row--;
        }else if (choice2 +1 <8 && 1 + choice2>-1 && col>-1 && 8>col && !otherBoard.hasBeenTried (choice2, col)){
            row++;
        }else if (choice3 + 1 > -1 && 8>choice3 +1 && row>-1 && 8>row &&!otherBoard.hasBeenTried (row, choice3)){
            col--;
        }else if (1 + choice4 <8 && 1+ choice4>-1 && row>-1 && 8>row &&!otherBoard.hasBeenTried (row, choice4)){
            col++;
        }   
        return guess;
    }
}