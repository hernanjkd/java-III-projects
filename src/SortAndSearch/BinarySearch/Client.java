package SortAndSearch.BinarySearch;

public class Client
{
    public static void main(String[]args)
    {
        int[] list = new int[100];
        
        for (int i=0 ; i < 100 ; i++) list[i] = i+1;
        
        //for (int nums : list) System.out.print(nums+"  ");
        
        BinarySearcher find = new BinarySearcher(list);
        RecursiveBinarySearcher recFind = new RecursiveBinarySearcher(list);
        
        System.out.println(find.search(45));
        System.out.println(recFind.search(45));
    }
}