package Lottery;

import java.util.*;
import javax.swing.*;

public class LotteryGame 
{
    private static int[] nbrList;
    
    public LotteryGame(int numberOfPicks, int maximumPick, boolean isQuickPick)
    {
        if (maximumPick < numberOfPicks)
            throw new RuntimeException("Maximum pick must be larger"+
                    " or equal to the number of picks.");
        
        nbrList = new int[numberOfPicks];
        
        if (isQuickPick)
        {
            Random generator = new Random();
            
            for (int i=0 ; i < numberOfPicks ; i++)
            {
                nbrList[i] = generator.nextInt(maximumPick) + 1;
                
                if (!isUnique(nbrList[i]))
                    i--;
            }
        }
        
        else 
        {
            String input = JOptionPane.showInputDialog("Choose "+numberOfPicks+
                    " numbers from 1 through "+maximumPick);
            
            Scanner scan = new Scanner(input);
           
            for (int i=0 ; scan.hasNext() ; i++)
            {
                nbrList[i] = scan.nextInt();
            }
        }
    }
    
    private boolean isUnique(int pick)
    {
        boolean uniqueness = true;
        
        for (int i=0 ; i < nbrList.length ; i++)
        {
            if (nbrList[i] == pick)
                uniqueness = false;
        }
        
        return uniqueness;
    }
    
    public int getNumberOfPicks()
    {
        return nbrList.length;
    }
    
    public int getPick(int pickNbr)
    {
        return nbrList[pickNbr];
    }
    
    public String toString()
    {
        String out = "";
        
        for (int nbr : nbrList)
        {
            out += nbr + " ";
        }
        
        return out;
    }
    
    public static void main(String[]args)
    {
        LotteryGame game = new LotteryGame(6,6,true);
        
        System.out.println(game);
    }
}
