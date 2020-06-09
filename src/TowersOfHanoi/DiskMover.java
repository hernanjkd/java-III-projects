package TowersOfHanoi;

public class DiskMover 
{
    private int source;
    private int target;
    private int n;
    
    private DiskMover earlyHelper;
    private DiskMover laterHelper;
    
    private boolean beforeLargest = true;
    private boolean largest = true;
    private boolean done = false;
    
    public DiskMover(int source, int target, int n)
    {
        checkForErrors(source, target, n);
        
        this.source = source;
        this.target = target;
        this.n = n;        
        
        int other = 6 - source - target;
        
        createDiskHelpers(other);
    }
    
    public String nextMove()
    {
        if (n == 1)
        {
            done = true;
            
            return "Move disk from peg "+source+" to "+target;
        }
        
        else
        {
            if (beforeLargest)
            {
                if (earlyHelper.done) beforeLargest = false;
                
                else return earlyHelper.nextMove();
            }
        
            if (largest)
            {
                largest = false;
                
                return "Move disk from peg "+source+" to "+target;
            }
            
            String move;
            
            move = laterHelper.nextMove();
            
            if (laterHelper.done) done = true;
            
            return move;
        }
    }
    
    public boolean hasMoreMoves()
    {
        return !done;
    }
    
    private void checkForErrors(int source, int target, int n)
    {
        if (n < 1) 
            throw new TowersOfHanoiException("Can't have 0 or a negative amount of disks!");
        
        if (source < 1 || source > 3 || target < 1 || target > 3)
            throw new TowersOfHanoiException("There are only 3 pegs!");
    }
    
    private void createDiskHelpers(int other)
    {
        if (n != 1) earlyHelper = new DiskMover(source, other, n-1);
        
        if (n != 1) laterHelper = new DiskMover(other, target, n-1);
    }
    
    public static void main(String[]args)
    {
        DiskMover mover = new DiskMover(1,3,4);
   
        while(mover.hasMoreMoves()) System.out.println(mover.nextMove()); 
    }
}