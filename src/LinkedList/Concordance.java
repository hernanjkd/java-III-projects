package LinkedList;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Concordance
{
    private String name;
    private OrderedList list;
    
    public Concordance(String name) throws FileNotFoundException
    {
        this.name = name;
        list = new OrderedList();
         
        buildConcordance();
    }
    
    public String toString()
    {
        return list.toString();
    }
    
    private void buildConcordance() throws FileNotFoundException
    {
        FileReader text = new FileReader(name);
        
        Scanner scan = new Scanner(text);
        
        int count = 0;
        
        while (scan.hasNextLine())
        {
            Scanner line = new Scanner(scan.nextLine());
            count++;
            
            breakLine(line,count);
        }
    }
    
    private void breakLine(Scanner line, int count)
    {
        while (line.hasNext())
        {
            String token = line.next();
            WordRecord word = new WordRecord(token);
            
            if (!list.has(word)) list.insert(word);
            
            list.addLineToWR(word,count);
        }
    }
}