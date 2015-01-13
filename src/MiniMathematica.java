import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import components.Calculator;

import exceptions.InsufficientValuesException;
import exceptions.InvalidArgumentsException;
import exceptions.MismatchedParenException;
import exceptions.TooManyValuesExpression;

public class MiniMathematica {

    public static void main(String[] args) {
        
        String expression = null;
        
        if(args.length > 0) {
            expression = args[0];
        }
        else {
            System.out.print("Enter an expression: ");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                expression = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            double result = Calculator.calc(expression);
            System.out.println("Result is " + result);
        } catch (MismatchedParenException e) {
            System.out.print("Expression contains mismatched parenthesis.");
        } catch (InsufficientValuesException e) {
            System.out.print("Expression contains insufficient values.");
        } catch (TooManyValuesExpression e) {
            System.out.print("Expression contains too many.");
        } catch (InvalidArgumentsException e) {
            System.out.print("Expression contains invalid arguments.");
        }
    }    
}
