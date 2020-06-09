package SortAndSearch.MergeSort;

import java.util.ArrayList;

public class MergeSorter
{
    public static ArrayList<Integer> merge(ArrayList<Integer> one, ArrayList<Integer> two)
    {
        ArrayList list = new ArrayList<Integer>();
        
        int i1 = 0;
        int i2 = 0;
        
        while (i1 < one.size() && i2 < two.size())
        {
            if (one.get(i1) <= two.get(i2))
            {
                list.add(one.get(i1));
                i1++;
            }
            
            else
            {
                list.add(two.get(i2));
                i2++;
            }
        }
        
        while (i1 < one.size())
        {
            list.add(one.get(i1));
            i1++;
        }
        
        while (i2 < two.size())
        {
            list.add(two.get(i2));
            i2++;
        }
        
        return list;
    }
}