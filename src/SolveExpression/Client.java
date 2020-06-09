package SolveExpression;

import javax.swing.JOptionPane;

public class Client 
{ 
    public static void main(String[]args)
    {
        String input = JOptionPane.showInputDialog(
                "Enter equation.                                          "+
                "                                                         ");
        
        while (input!= null) 
        {
            Queue list = new Queue<Token>();
            
            while (input.length() != 0) 
            {
                String item = input.substring(0,1);
                input = input.substring(1);
                
                Token newToken = new Token(item);
                
                boolean done = false;
                
                if (!newToken.isOperand()) done = true;
                
                while (input.length() != 0 && !done)
                {
                    String item2 = input.substring(0,1);
                    Token newToken2 = new Token(item2);
                    
                    if (newToken2.isOperand())
                    {
                        item += item2;
                        input = input.substring(1);
                    }
                   
                    else done = true;
                }
                        
                list.addQ(new Token(item));
            }
        
            ExpressionEvaluator evaluator = new ExpressionEvaluator(list);
        
            JOptionPane.showMessageDialog(null,evaluator.getValue());
            
            input = JOptionPane.showInputDialog(
                "Enter equation.                                          "+
                "                                                         ");
        }
    } 
}