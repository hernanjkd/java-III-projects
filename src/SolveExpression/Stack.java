package SolveExpression;

import java.util.ArrayList;

public class Stack<T>
{
    private ArrayList list;
    
    public Stack()
    {
        list = new ArrayList<T>();
    }
     
    public boolean empty()
    {
        return list.isEmpty();
    }
    
    public void push(T item)
    {
        list.add(0,item);
    }
    
    public T pop()
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