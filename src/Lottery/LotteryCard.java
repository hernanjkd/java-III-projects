package Lottery;

import java.util.*;

public class LotteryCard 
{
    private ArrayList gameList = new ArrayList<LotteryGame>();
    
    public LotteryCard(int nbrQuickPicks, int nbrSelfPicks, int numberOfPicks, int maximumPick)
    {
        for (int i=0 ; i < nbrQuickPicks ; i++)
        {
            LotteryGame randomGame = new LotteryGame(numberOfPicks, maximumPick, true);
            
            gameList.add(randomGame);
        }
        
        for (int i=0 ; i < nbrSelfPicks ; i++)
        {
            LotteryGame selfGame = new LotteryGame(numberOfPicks, maximumPick, false);
            
            gameList.add(selfGame);
        }
    }
    
    public int getNumberOfGames()
    {
        return gameList.size();
    }
    
    public LotteryGame getGame(int gameNumber)
    {
        return (LotteryGame)gameList.get(gameNumber);
    }
}
