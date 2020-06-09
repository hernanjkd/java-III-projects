package Lottery;

public class LotteryClient
{
	public static void main(String[] args)
	{
		//Set the game parameters
		int nbrPicks = 6;	//# picks per card
		int maxPick  = 52;//Highest pick allowed
		
	
		//Create a game card with 8 quick-picks & 1 self-pick
		LotteryCard card = new LotteryCard(8, 1, nbrPicks, maxPick);
		
		//Generate & display the winning numbers
		Lottery lotto = new Lottery(nbrPicks, maxPick);
		System.out.println("WINNING NUMBERS  " + lotto);
			
		//Compare each game card with the winning numbers		
		for (int k = 1; k <= card.getNumberOfGames(); k++)
		{
			System.out.println("GAME  " + k + " NUMBERS  " + card.getGame(k)
										+ " : " + lotto.checkGame(card.getGame(k))
										+ " Numbers");
		}
	}
}