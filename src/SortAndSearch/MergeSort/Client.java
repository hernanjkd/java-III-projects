package SortAndSearch.MergeSort;

import java.util.ArrayList;

public class Client 
{
    public static void main(String[]args)
    {
        ArrayList list1 = new ArrayList<Integer>();
        ArrayList list2 = new ArrayList<Integer>();
        
        for (int i=2 ; i < 40 ; i++)
        {
            list1.add(i);
            i++;
        }
        
        for (int i=1 ; i < 29 ; i++)
        {
            list2.add(i);
            i++;
        }
        
        for (int i=0 ; i < list1.size() ; i++) System.out.print(list1.get(i)+" ");
        System.out.println();
        for (int i=0 ; i < list2.size() ; i++) System.out.print(list2.get(i)+" ");
        
        System.out.println("\n"+MergeSorter.merge(list1, list2));
    }
}
