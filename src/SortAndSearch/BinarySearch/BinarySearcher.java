package SortAndSearch.BinarySearch;

public class BinarySearcher 
{
    private int[] list;
    
    public BinarySearcher(int[] array)
    {
        list = array;
    }
    
    public int search(int num)
    {
        int low = 0;
        int high = list.length - 1;
        
        while (low <= high)
        {
            int mid = (low + high) / 2;
            int diff = list[mid] - num;
            
            if (diff == 0) return mid;
            
            else if (diff < 0) low = mid+1;
            
            else high = mid-1;
        }
        
        return -1;
    }
}