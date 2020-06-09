package LinkedList;

public class OrderedList
{
    private Node first;
    
    public OrderedList()
    {
        first = null;
    }
    
    public void insert(Comparable item)
    {
        if (first == null) first = new Node(item);
        
        else insertInOrder(item);
    }
    
    public void remove(Comparable item)
    {
        Node front = first;
        Node back = null;
            
        boolean done = false;
            
        while (!done && front != null)
        {
            if (item.compareTo(front.data) == 0)
            {
                if (back == null) first = front.next;
                else back.next = front.next;
                
                done = true;
            }
                
            else if (item.compareTo(front.data) < 0) done = true;
                
            else
            {
                back = front;
                front = front.next;
            }
        }
    }
    
    public Comparable lookUp(Comparable item)
    {
        if (first == null) return null;
        
        Node pointer = first;
        
        while (pointer != null)
        {
            if (item.compareTo(pointer.data) == 0) return pointer.data;
            
            if (item.compareTo(pointer.data) < 0) return null;
            
            pointer = pointer.next;
        }
        
        return null;
    }
    
    public int size()
    {
        if (first == null) return 0;
        
        int nodes = 0;
        
        Node counter = first;
        
        while (counter != null)
        {
            nodes++;
            counter = counter.next;
        }
        
        return nodes;
    }
    
    public boolean has(Comparable item)
    {
        if (first == null) return false;
        
        Node pointer = first;
        
        while (pointer != null)
        {
            if (item.compareTo(pointer.data) == 0) return true;
            
            pointer = pointer.next;
        }
        
        return false;
    }
    
    public void addLineToWR(Comparable word, int line)
    {
        Node pointer = first;
        Node back = null;
        
        while (word.compareTo(pointer.data) != 0) 
        {
            back = pointer;
            pointer = pointer.next;
        }
        
        WordRecord record = (WordRecord)pointer.data;
        
        if (!record.hasLine(line))
        {
            record.addLine(line);
        
            Node newNode = new Node(record);
        
            if (back == null) first = newNode;
            else back.next = newNode;
             
            newNode.next = pointer.next;
        }
    }
    
    public String toString()
    {
        if (first == null) return "Empty";
        
        String image = "";
        
        Node pointer = first;
        
        while (pointer != null)
        {
            image += pointer.data+"\n";
            pointer = pointer.next;
        }
        
        return image;
    }
    
    private void insertInOrder(Comparable item)
    {
        Node newNode = new Node(item);
        
        Node front = first;
        Node back = null;
            
        boolean done = false;
        
        while (!done && front != null)
        {
            if (item.compareTo(front.data) < 0)
            {
                if (back == null) first = newNode;
                else back.next = newNode;
                
                newNode.next = front;
                done = true;
            }
            
            else
            {
                back = front;
                front = front.next;
            }
        }
        
        if (front == null) back.next = newNode;
    }
    
    private class Node
    {
        public Comparable data;
        public Node next;
        
        public Node(Comparable data)
        {
            this.data = data;
            next = null;
        }
    }
}