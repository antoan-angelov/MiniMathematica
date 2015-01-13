package components;
import java.util.LinkedList;
import java.util.Stack;

import objects.Constant;
import objects.Function;
import objects.MathObject;
import objects.Number;
import objects.Operator;
import objects.Parenthesis;


import exceptions.MismatchedParenException;


public class RPNParser {

    public LinkedList<MathObject> parse(String expression) throws MismatchedParenException {
        LinkedList<MathObject> output = new LinkedList<MathObject>();
        Stack<MathObject> operators = new Stack<MathObject>();
        
        expression = expression.replace("-", "+(-1)*");
        expression = expression.replaceAll("\\s+", "");
        expression = expression.replaceAll("((^\\+)|((?<=,)\\+)|((?<=\\()\\+))", "");
        
        int n = expression.length();

        for(int i=0; i<n; i++) {

            char symbol = expression.charAt(i);
            Function f;
            Operator o;
            Constant c;

            // token is a number
            if(Character.isDigit(symbol) || (i < n-1 && symbol == '-' && Character.isDigit(expression.charAt(i+1)))) {
                
                int digitBeg = i;
                int digitEnd = i + 1;
                
                while(digitEnd < n && (expression.charAt(digitEnd) == '.' || Character.isDigit(expression.charAt(digitEnd)))) { 
                    digitEnd++;
                }
                
                i = digitEnd - 1;
                String numStr = expression.substring(digitBeg, digitEnd);
                double num = Double.parseDouble(numStr);
                output.add(new Number(num));
            }            
            // token is a function
            else if((f = Function.getFunctionToken(expression, i)) != null) {
                String name = f.getName();
                i += name.length()-1;
                operators.push(f);
            }
            // token is a constant
            else if((c = Constant.getConstantToken(expression, i)) != null) {
                String name = c.getName();
                i += name.length()-1;
                output.add(c);
            }
            // token is an operator
            else if((o = Operator.getOperatorToken(expression, i)) != null) {

                while(!operators.isEmpty() && operators.peek().getType() == MathObject.TYPE_OPERATOR) {
                    Operator o2 = (Operator) operators.peek();
                    if((o.getAssociativity() == Operator.ASSOCIATIVITY_LEFT && o.getPrecedence() <= o2.getPrecedence())
                            || (o.getAssociativity() == Operator.ASSOCIATIVITY_RIGHT && o.getPrecedence() < o2.getPrecedence())) {
                        output.add(operators.pop());
                    }
                    else {
                        break;
                    }
                }
                
                operators.push(o);
            }
            // token is an argument separator
            else if(symbol == ',') {
                
                while(!operators.isEmpty() && operators.peek().getType() != MathObject.TYPE_PARENTHESIS_LEFT) {
                    output.add(operators.pop());
                }
                
                if(operators.isEmpty()) {
                    throw new MismatchedParenException();
                }
            }
            // token is a left parenthesis
            else if(symbol == '(') {
                operators.push(Parenthesis.LEFT_PARENTHESIS);
            }
            // token is a right parenthesis
            else if(symbol == ')') {
                while(!operators.isEmpty() && operators.peek().getType() != MathObject.TYPE_PARENTHESIS_LEFT) {
                    output.add(operators.pop());
                }
                
                if(operators.isEmpty()) {
                    throw new MismatchedParenException();
                }
                
                operators.pop();
                
                if(!operators.isEmpty() && operators.peek().getType() == MathObject.TYPE_FUNCTION) {
                    output.add(operators.pop());
                }
            }
        }
        
        while(!operators.isEmpty()) {
            if(operators.peek().getType() == MathObject.TYPE_PARENTHESIS_LEFT 
                    || operators.peek().getType() == MathObject.TYPE_PARENTHESIS_RIGHT) {
                throw new MismatchedParenException();
            }
            
            output.add(operators.pop());
        }
        
        return output;
    }

}
