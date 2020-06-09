package Game;

import javax.swing.JOptionPane;

public class Game
{
	public static void main(String[] args)
	{
		String gameName =
			JOptionPane.showInputDialog("What game do you wish to play?");
			
		GamePlayer game;
		if ( gameName.equalsIgnoreCase("TicTacToe") )
			game = new TicTacToe();
		else
                    if ( gameName.equalsIgnoreCase("Nim") )
			game = new Nim();
		else
 			throw new RuntimeException(gameName + " is not available");
			 
		System.out.println( game ); 

		while ( !game.gameCompleted() )  
		{ 
			if ( game.isPlayersTurn() )
			{  
				String move;  
				do 
				{   
					move = game.getPlayersMove();
				} while ( !game.isValidMove(move) );
				game.applyPlayerMove(move);
			}
			else
				game.applyComputerMove();
			System.out.println( game );
		}
		
		JOptionPane.showMessageDialog(null,
					(game.playerHasWon() ?
					 "Bien torti, Ganaste!" : "No importa, next time. =)") );
	}
}