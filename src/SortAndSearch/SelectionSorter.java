package SortAndSearch;

import java.util.ArrayList;

public class SelectionSorter
{
    ArrayList list;
    
    public SelectionSorter(ArrayList list)
    {
        this.list = list;
    }
    
    public void sort()
    {
        if (list.size() > 1)
        {
            String largest = findLargest();
            
            list.remove(largest);
            
            sort();
            
            list.add(largest);
        }
    }
    
    private String findLargest()
    {
        int max = 0;
        
        for (int i=1 ; i < list.size() ; i++)
        {
            String word = (String)list.get(max);
            String word2 = (String)list.get(i);
            
            if (word.compareTo(word2) < 0) max = i;
        }
         
        return (String)list.get(max);
    }
}