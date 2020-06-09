package SortAndSearch.MergeSort;

import java.util.ArrayList;

public class RecursiveMergeSorter
{
    private static ArrayList list = new ArrayList<Integer>();
    
    public static ArrayList<Integer> merge(ArrayList<Integer> one, ArrayList<Integer> two)
    {
        if (one.isEmpty()) recurseTwo(one,two);
        
        if (two.isEmpty()) recurseOne(one,two);
        
        if (one.get(0) < two.get(0)) recurseOne(one,two);
        
        else recurseTwo(one,two);
        
        return list;
    }
    
    private static void recurseOne(ArrayList<Integer> one, ArrayList<Integer> two)
    {
        list.add(one.get(0));
        one.remove(0);
        merge(one,two);
    }
    
    private static void recurseTwo(ArrayList<Integer> one, ArrayList<Integer> two)
    {
        list.add(two.get(0));
        two.remove(0);
        merge(one,two);
    }
}