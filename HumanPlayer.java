import java.util.*;

public class HumanPlayer extends Player{
    
    public HumanPlayer (String name){
        super (name);
    }
    public Guess nextGuess(Scanner console, Board otherBoard) {
        System.out.println("Enter your guess.");
        System.out.print ("     row:");
        int choiceR = console.nextInt ();
        System.out.println();
        System.out.print("  column:");
        int choiceC = console.nextInt();
        System.out.println();
        Guess x = new Guess (choiceR,choiceC);
        return x;
    }
}
    
    