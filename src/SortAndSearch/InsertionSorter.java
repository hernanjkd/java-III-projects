package SortAndSearch;

import java.util.ArrayList;

public class InsertionSorter
{
    ArrayList list;
    
    public InsertionSorter(ArrayList<String> list)
    {
        this.list = list;
    }
    
    public void sort()
    {
        if (list.size() > 1)
        {
            String lastItem = (String)list.remove(list.size()-1);
            
            sort();
            
            insert(lastItem);
        }
    }
    
    private void insert(String item)
    {
        int i = 0;
        
        while (i < list.size() && item.compareTo((String)list.get(i)) > 0) i++;
        
        list.add(i,item);
    }
}