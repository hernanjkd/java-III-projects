package LinkedList;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;

public class Client 
{
    public static void main(String[]args) throws FileNotFoundException
    {
        boolean done = false;
        
        while (!done)
        {
            try 
            {
                String fileName = JOptionPane.showInputDialog(null,
                                                "Name of file for concordance?");

                Concordance spot = new Concordance(fileName);
		
                done = true;
                
                System.out.println(spot);
            }
        
            catch (FileNotFoundException exception)
            {
                System.out.println(exception.getMessage());
            }
        }
    }
}