import components.Calculator;

import exceptions.InsufficientValuesException;
import exceptions.InvalidArgumentsException;
import exceptions.MismatchedParenException;
import exceptions.TooManyValuesExpression;

public class Main {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) {
        
        String expression = "5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))";//"5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))";
        try {
            System.out.println(Calculator.calc(expression));
        } catch (MismatchedParenException e) {
            e.printStackTrace();
        } catch (InsufficientValuesException e) {
            e.printStackTrace();
        } catch (TooManyValuesExpression e) {
            e.printStackTrace();
        } catch (InvalidArgumentsException e) {
            e.printStackTrace();
        }
    }    
}
