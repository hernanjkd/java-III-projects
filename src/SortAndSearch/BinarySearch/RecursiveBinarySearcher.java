package SortAndSearch.BinarySearch;

public class RecursiveBinarySearcher 
{
    private int[] list;
    
    public RecursiveBinarySearcher(int[] array)
    {
        list = array;
    }
    
    public int search(int num)
    {
        return search(num,0,list.length-1);
    }
    
    private int search(int num, int low, int high)
    {
        int mid = (low + high) / 2;
        int diff = list[mid] - num;
        
        if (diff == 0) return mid;
        
        if (diff < 0) return search(num,mid+1,high);
            
        if (diff > 0) return search(num,low,mid-1); 
        
        return -1;
    }
}