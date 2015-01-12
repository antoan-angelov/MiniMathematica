package components;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import objects.MathObject;
import objects.Number;
import objects.OperatorBase;


import exceptions.InsufficientValuesException;
import exceptions.InvalidArgumentsException;
import exceptions.MismatchedParenException;
import exceptions.TooManyValuesExpression;

public class Calculator {

    public static double calc(String expression)
            throws MismatchedParenException, InsufficientValuesException, TooManyValuesExpression, InvalidArgumentsException {

        RPNParser parser = new RPNParser();

        LinkedList<MathObject> output = parser.parse(expression);
        Stack<Double> stack = new Stack<Double>();

        while (!output.isEmpty()) {

            MathObject operator = output.pop();

            if (operator.getType() == MathObject.TYPE_NUMBER 
                    || operator.getType() == MathObject.TYPE_CONSTANT) {
                stack.add(((Number) operator).getValue());
            } else {
                OperatorBase operatorBase = (OperatorBase) operator;
                int numArguments = operatorBase.getNumArguments();
                ArrayList<Double> arguments = new ArrayList<>();

                for (; numArguments > 0; numArguments--) {
                    
                    if (stack.isEmpty()) {
                        throw new InsufficientValuesException();
                    }

                    double number = stack.pop();
                    arguments.add(number);                    
                }
                
                Collections.reverse(arguments);

                double result = operatorBase.eval(arguments);
                if (result != Double.NaN) {
                    stack.add(result);
                }
            }
        }

        if (stack.size() > 1) {
            throw new TooManyValuesExpression();
        }
        
        return stack.pop();
    }
}
