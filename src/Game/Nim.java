package Game;

import java.util.*;
import javax.swing.JOptionPane;

public class Nim implements GamePlayer
{
    private int start;
    private int stones;
    
    private boolean isPlayersTurn;
    private boolean playerHasWon = false;
    
    private int computersMove;
    private int playersMove;
    
    private int round = 0;
    
    public Nim()
    {
        String input = JOptionPane.showInputDialog("Do you want to start? (yes/no)");
                
        isPlayersTurn = input.equalsIgnoreCase("yes");
        
        do 
            input = JOptionPane.showInputDialog("Choose the number from where you will start playing.");
        
        while (!isNumber(input) || input.compareTo("1") < 0);
        
        start = Integer.parseInt(input);
        
        stones = start;
    }
    
    public String getPlayersMove()
    {        
        String input = JOptionPane.showInputDialog(start+"\n\n"+toString()+
                                                   "\n\nChoose a number between 1 and "+stones/2+".");
        
        return input;
    }
    
    public boolean isValidMove(String move)
    {
        if (!isNumber(move)) return false;
        
        int num = Integer.parseInt(move);
        
        return num >= 1 && num <= (stones/2);
    }
    
    public void applyPlayerMove(String move)
    {
        playersMove = Integer.parseInt(move);
        
        stones -= playersMove;
        
        playerHasWon = stones == 1;
        
        round++;
        
        isPlayersTurn = false;
    }
    
    public void applyComputerMove()
    {
        Random gen = new Random();
        
        computersMove = gen.nextInt(stones/2) + 1;
        
        stones -= computersMove;
        
        round++;
        
        isPlayersTurn = true;
    }
    
    public boolean isPlayersTurn()
    {
        return isPlayersTurn;
    }
        
    public boolean gameCompleted()
    {
        return stones == 1;
    }
    
    public boolean playerHasWon()
    {
        return playerHasWon;
    }
    
    public String toString()
    {
        String out; 
        
        if(round == 0) out = "Starting stones: "+stones;
        
        else out = (isPlayersTurn ? "CPU" : "Player")+": "+
                   (isPlayersTurn ? computersMove : playersMove)+"\nstones "+stones+"\n";
        
        return out;
    }
    
    private boolean isNumber(String move)
    {        
        if (move.equals("")) return false;
        
        for (int i=0 ; i < move.length() ; i++)
        {
            String next = move.substring(i, i+1);
            
            if (next.compareTo("0") < 0 || next.compareTo("9") > 0) return false;
        }
          
        return true;
    }
}
