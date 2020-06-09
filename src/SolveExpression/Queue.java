package SolveExpression;

import java.util.ArrayList;

public class Queue<T> 
{
    private ArrayList list;
    
    public Queue()
    {
        list = new ArrayList<T>();
    }
     
    public boolean empty()
    {
        return list.isEmpty();
    }
    
    public void addQ(T item)
    {
        list.add(item);
    }
    
    public T getQ()
    {
        if (empty()) return null;
        
        return (T)list.remove(0);
    }
    
    public T peek()
    {
        if (empty()) return null;
        
        return (T)list.get(0);
    }
}