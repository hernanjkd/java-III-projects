package Game;

import javax.swing.JOptionPane;
import java.util.Random;

public class TicTacToe implements GamePlayer
{
    private boolean isPlayersTurn;
    private boolean playerHasWon = false;
    
    private String t1 = "  ";
    private String t2 = "  ";
    private String t3 = "  ";
    private String t4 = "  ";
    private String t5 = "  ";
    private String t6 = "  ";
    private String t7 = "  ";
    private String t8 = "  ";
    private String t9 = "  ";
    
    public TicTacToe()
    {
        String input = JOptionPane.showInputDialog("Do you want to start? (yes/no)");
        
        isPlayersTurn = input.equalsIgnoreCase("yes");
    }
    
    public String getPlayersMove()
    {
        String ticTacToe = "[1][2][3]\n" +
                           "[4][5][6]     Player x\n" +
                           "[7][8][9]     CPU    o\n\n\n";
        
        String input = JOptionPane.showInputDialog(ticTacToe+toString());
        
        return input;
    }
    
    public boolean isValidMove(String move)
    {
        if (!isNumber(move))
            return false;
        
        int num = Integer.parseInt(move);
        
        return num >= 1 && num <= 9 && isAvailable(num);
    }
    
    public void applyPlayerMove(String move)
    {
        apply(move);
        
        if (ticTacToe())
            playerHasWon = true;
        
        isPlayersTurn = false;
    }
    
    public void applyComputerMove()
    {
        Random gen = new Random();
        
        String move;
        
        do
        {
            move = (gen.nextInt(9) + 1)+"";
        }
        while (!isValidMove(move));
        
        apply(move);
        
        isPlayersTurn = true;
    }
    
    public boolean isPlayersTurn()
    {
        return isPlayersTurn;
    }
    
    public boolean gameCompleted()
    {
        return ticTacToe() || isFull();
    }
    
    public boolean playerHasWon()
    {
        return playerHasWon;
    }
    
    public String toString()
    {
        String out = "["+t1+"]["+t2+"]["+t3+"]\n"+
                     "["+t4+"]["+t5+"]["+t6+"]\n"+
                     "["+t7+"]["+t8+"]["+t9+"]\n\n";
        
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
    
    private boolean isAvailable(int move)
    {
        switch(move)
        {
            case 1 : return t1.equals("  ");
            case 2 : return t2.equals("  ");
            case 3 : return t3.equals("  ");
            case 4 : return t4.equals("  ");
            case 5 : return t5.equals("  ");
            case 6 : return t6.equals("  ");
            case 7 : return t7.equals("  ");
            case 8 : return t8.equals("  ");
            case 9 : return t9.equals("  ");
            default : return false;
        }
    }
    
    private void apply(String move)
    {
        String n = (isPlayersTurn ? "x" : "o");
        
        switch(Integer.parseInt(move))
        {
            case 1 : t1 = n; break;
            case 2 : t2 = n; break;
            case 3 : t3 = n; break;
            case 4 : t4 = n; break;
            case 5 : t5 = n; break;
            case 6 : t6 = n; break;
            case 7 : t7 = n; break;
            case 8 : t8 = n; break;
            case 9 : t9 = n; break;
        }
    }
    
    private boolean ticTacToe()
    {
        String n = (isPlayersTurn ? "x" : "o");
                
        if (match(t1,t2,t3) || match(t4,t5,t6) || match(t7,t8,t9) || match(t1,t5,t9))
            return true;
        
        if (match(t1,t4,t7) || match(t2,t5,t8) || match(t3,t6,t9) || match(t3,t5,t7))
            return true;
                    
        return false;
    }
    
    private boolean match(String t1, String t2, String t3)
    {
        String match = t1+t2+t3;
        
        return match.equals("xxx") || match.equals("ooo");
    }
    
    private boolean isFull()
    {
        boolean row1 = !t1.equals("  ") && !t2.equals("  ") && !t3.equals("  ");
        boolean row2 = !t4.equals("  ") && !t5.equals("  ") && !t6.equals("  ");
        boolean row3 = !t7.equals("  ") && !t8.equals("  ") && !t9.equals("  ");
                
        return row1 && row2 && row3;
    }
}
