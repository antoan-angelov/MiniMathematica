package objects;

import java.util.ArrayList;

import exceptions.InvalidArgumentsException;

public abstract class Function extends OperatorBase {

    private final static ArrayList<Function> FUNCTIONS = new ArrayList<>();

    public final static Function FUNCTION_SIN = new Function("sin", 1) {
        @Override
        protected double performEval(ArrayList<Double> arguments) {
            return Math.sin(arguments.get(0));
        }
    };

    public final static Function FUNCTION_COS = new Function("cos", 1) {
        @Override
        protected double performEval(ArrayList<Double> arguments) {
            return Math.cos(arguments.get(0));
        }
    };

    public final static Function FUNCTION_TAN = new Function("tan", 1) {
        @Override
        protected double performEval(ArrayList<Double> arguments) {
            return Math.tan(arguments.get(0));
        }
    };

    public final static Function FUNCTION_COTAN = new Function("cotan", 1) {
        @Override
        protected double performEval(ArrayList<Double> arguments) {
            return 1 / Math.tan(arguments.get(0));
        }
    };

    public final static Function FUNCTION_POW = new Function("pow", 2) {
        @Override
        protected double performEval(ArrayList<Double> arguments) throws InvalidArgumentsException {
            if(arguments.get(0) == 0 && arguments.get(1) == 0) {
                throw new InvalidArgumentsException();
            }
            
            return Math.pow(arguments.get(0), arguments.get(1));
        }
    };
    
    public final static Function FUNCTION_LOG = new Function("log", 2) {
        @Override
        protected double performEval(ArrayList<Double> arguments) throws InvalidArgumentsException {
            return Math.log(arguments.get(1)) / Math.log(arguments.get(0));
        }
    };

    public final static Function FUNCTION_SQRT = new Function("sqrt", 1) {
        @Override
        protected double performEval(ArrayList<Double> arguments) throws InvalidArgumentsException {
            if(arguments.get(0) < 0) {
                throw new InvalidArgumentsException();
            }
            
            return Math.sqrt(arguments.get(0));
        }
    };
    
    public final static Function FUNCTION_SQRTN = new Function("sqrtn", 2) {
        @Override
        protected double performEval(ArrayList<Double> arguments) throws InvalidArgumentsException {
            double d = arguments.get(0);
            double n = arguments.get(1);

            if (d < 0) {
                throw new InvalidArgumentsException();
            } else if (d == 0) {
                return 0;
            }

            double x_prev = d;
            double x = d / n;
            while (Math.abs(x - x_prev) > 0.001) {
                x_prev = x;
                x = ((n - 1.0) * x + d / Math.pow(x, n - 1.0)) / n;
            }
            return x;
        }
    };

    private Function(String name, int numArguments) {
        super(name, numArguments, TYPE_FUNCTION);
        FUNCTIONS.add(this);
    }

    public static Function getFunctionToken(String expression, int startFrom) {
        return (Function) find(expression, startFrom, FUNCTIONS);
    }
}
