package Lottery;

import java.util.*;

public class Lottery 
{
    private int[] winningNumbers;
    
    public Lottery(int numberOfPicks, int maximumPick)
    {
        winningNumbers = new int[numberOfPicks];
        
        Random generator = new Random();
        
        for (int i=0 ; i < numberOfPicks ; i++) 
        {
            winningNumbers[i] = generator.nextInt(maximumPick) + 1;
                
            int n = 0;
                
            while (n < i)
            {
                if (winningNumbers[n] == winningNumbers[i])
                {
                    winningNumbers[i] = generator.nextInt(maximumPick) + 1;
                        
                    n = 0;
                }
                    
                else n++;
            }
        }
    }
    
    public int checkGame(LotteryGame game)
    {
        int numbers = 0;
        
        for (int nbr : winningNumbers)
        {
            for (int i=0 ; i < game.getNumberOfPicks() ; i++)
            {
                if (game.getPick(i) == nbr)
                    numbers++;
            }
        }
        
        return numbers;
    }
    
    public String toString()
    {
        String out = "";
        
        for (int nbr : winningNumbers)
        {
            out += nbr + " ";
        }
        
        return out;
    }
}
