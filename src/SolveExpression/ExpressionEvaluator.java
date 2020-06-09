package SolveExpression;

public class ExpressionEvaluator
{
    Queue store;
    Stack operandStack;
    Stack operatorStack;
    
    public ExpressionEvaluator(Queue store)
    {
        this.store = store;
        operandStack = new Stack<Token>();
        operatorStack = new Stack<Token>();
    }
    
    public double getValue()
    {
        while (!store.empty())
        {
            Token item = (Token)store.getQ();
           
            if (item.isLeftParen())
            {
                int count = 1;
                
                Queue paren = new Queue<Token>();
                
                item = (Token)store.getQ();
                if (item.isLeftParen()) count++;
                    
                while (count != 0)
                {
                    paren.addQ(item);
                    item = (Token)store.getQ();
                    
                    if (item.isLeftParen()) count++;
                    if (item.isRightParen()) count--;
                }
                
                ExpressionEvaluator evaluator = new ExpressionEvaluator(paren);
                
                double result = evaluator.getValue();
                
                item = new Token(result);
            }
        
            if (item.isOperand()) operandStack.push(item);
            
            if (item.isOperator()) solveForOperator(item);
        }
        
        while (!operatorStack.empty()) solveEquation();
        
        return popOperand();
    }
    
    private void solveForOperator(Token operator)
    {        
        if (operatorStack.empty()) operatorStack.push(operator);
        
        else
        {
            Token previousOperator = (Token)operatorStack.peek();
            int op = operator.priority();
            int pp = previousOperator.priority();
            
            if (op < pp)
            {
                while (previousOperator != null && op < pp)
                {
                    solveEquation();
                    previousOperator = (Token)operatorStack.peek();
                    
                    if (previousOperator != null) pp = previousOperator.priority();
                }
                
                operatorStack.push(operator);
            }
            
            else operatorStack.push(operator);
        }
    }
     
    private double popOperand()
    {
        Token num = (Token)operandStack.pop();
        
        return num.doubleValue();
    }
    
    private void solveEquation()
    {
        double operand = popOperand();
        Token operator = (Token)operatorStack.pop();
        
        double result = 0;
        
        if (operator.isMinus()) result = solveEquation(operator)-operand;
        
        if (operator.isPlus()) result = solveEquation(operator)+operand;
          
        if (operator.isTimes()) result = solveEquation(operator)*operand;
        
        if (operator.isDivide()) result = solveEquation(operator)/operand;
        
        if (operator.isPower()) result = Math.pow(solveEquation(operator),operand);
        
        operandStack.push(new Token(result));
    }
    
    private double solveEquation(Token nextOperator)
    {
        double operand = popOperand();
        Token operator = (Token)operatorStack.peek();
        
        if (operator == null || operator.priority() != nextOperator.priority()) return operand;
        
        operatorStack.pop();
        
        double result = 0;
        
        if (operator.isMinus()) result = solveEquation(operator)-operand;
        
        if (operator.isPlus()) result = solveEquation(operator)+operand;
          
        if (operator.isTimes()) result = solveEquation(operator)*operand;
        
        if (operator.isDivide()) result = solveEquation(operator)/operand;
        
        if (operator.isPower()) result = Math.pow(solveEquation(operator),operand);
        
        return result;
    }
}