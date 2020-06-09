package Game;

public interface GamePlayer
{
    String getPlayersMove();

    boolean isValidMove(String move);
    
    void applyPlayerMove(String move);
    
    void applyComputerMove();
    
    boolean isPlayersTurn();
    
    boolean gameCompleted();
    
    boolean playerHasWon();
    
    @Override
    String toString();
}
