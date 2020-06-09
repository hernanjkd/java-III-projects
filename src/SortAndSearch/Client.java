package SortAndSearch;

import java.util.*;

public class Client
{
    public static void main(String[]args)
    {
        ArrayList list = new ArrayList<String>();
        Random gen = new Random();
        
        for (int i=0 ; i < 20 ; i++) list.add(gen.nextInt(90)+10+"");
        
        for (int i=0 ; i < list.size() ; i++) System.out.print(list.get(i)+" ");
        
        SelectionSorter sSorter = new SelectionSorter(list);
        InsertionSorter iSorter = new InsertionSorter(list);
        //sSorter.sort();
        iSorter.sort();
        System.out.println("\n");

        for (int i=0 ; i < list.size() ; i++) System.out.print(list.get(i)+" ");
    }
}