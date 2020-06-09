package LinkedList;

public class WordRecord implements Comparable
{
    private String word;
    private String lines = "";
    
    public WordRecord(String word)
    {
        this.word = clean(word).toLowerCase();
    }
    
    public void addLine(int number)
    {
        lines += " "+number;
    }
    
    public boolean hasLine(int line)
    { 
        return lines.indexOf(line+"") > 0;
    }
    
    public int compareTo(Object other)
    {
        WordRecord that = (WordRecord)other;
        
        return word.compareTo(that.word);
    }
    
    public String toString()
    {
        return word+lines;
    }
    
    private String clean(String word)
    {
        String extra = lastChar(word);
        
        if (hasPunctuation(extra)) return removeLastChar(word);
        
        else return word;
    }
    
    private String lastChar(String word)
    {
        return word.substring(word.length()-1,word.length());
    }
    
    private String removeLastChar(String word)
    {
        return word.substring(0,word.length()-1);
    }
    
    private boolean hasPunctuation(String p)
    {
        return p.equals(",") || p.equals("!") || p.equals(".") || p.equals("?");
    }
}