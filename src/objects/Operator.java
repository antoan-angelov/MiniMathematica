package objects;
import java.util.ArrayList;

import exceptions.InvalidArgumentsException;

public abstract class Operator extends OperatorBase {
    
    private final static ArrayList<Operator> OPERATORS = new ArrayList<>();
    
    public final static Operator OPERATOR_POWER = new Operator("^", 4, Operator.ASSOCIATIVITY_RIGHT) {
        @Override
        public double performEval(ArrayList<Double> arguments) throws InvalidArgumentsException {
            if(arguments.get(0) == 0 && arguments.get(1) == 0) {
                throw new InvalidArgumentsException();
            }
            
            return Math.pow(arguments.get(0), arguments.get(1));
        }
    };
    
    public final static Operator OPERATOR_MULTIPLICATION = new Operator("*", 3, Operator.ASSOCIATIVITY_LEFT) {
        @Override
        public double performEval(ArrayList<Double> arguments) {
            return arguments.get(0) * arguments.get(1);
        }
    };
    
    public final static Operator OPERATOR_DIVISION = new Operator("/", 3, Operator.ASSOCIATIVITY_LEFT) {
        @Override
        public double performEval(ArrayList<Double> arguments) {
            return arguments.get(0) / arguments.get(1);
        }
    };
    
    public final static Operator OPERATOR_ADDITION = new Operator("+", 2, Operator.ASSOCIATIVITY_LEFT) {
        @Override
        public double performEval(ArrayList<Double> arguments) {
            return arguments.get(0) + arguments.get(1);
        }
    };
    
    private final static int OPERATOR_DEFAULT_NUM_ARGUMENTS = 2;
    public final static int ASSOCIATIVITY_LEFT = 1;
    public final static int ASSOCIATIVITY_RIGHT = 2;    

    private int mPrecedence;
    private int mAssociativity;

    private Operator(String operator, int precedence, int associativity) {
        super(operator, OPERATOR_DEFAULT_NUM_ARGUMENTS, TYPE_OPERATOR);        
        
        this.mPrecedence = precedence;
        this.mAssociativity = associativity;
        
        OPERATORS.add(this);
    }
    
    public int getPrecedence() {
        return this.mPrecedence;
    }
    
    public int getAssociativity() {
        return this.mAssociativity;
    }

    public static Operator getOperatorToken(String expression, int startFrom) {
        String substr = expression.substring(startFrom);
        for(Operator o : OPERATORS) {
            if(substr.startsWith(o.getName())) {
                return o;
            }
        }
        
        return null;
    }
}
