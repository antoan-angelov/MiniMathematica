package objects;
import java.util.ArrayList;

import exceptions.InsufficientValuesException;
import exceptions.InvalidArgumentsException;


public abstract class OperatorBase extends MathObject {
    
    protected int mNumArguments;
    
    protected OperatorBase(String name, int numArguments, int type) {        
        super(name, type);
        this.mNumArguments = numArguments;
    }

    public String getName() {
        return this.mName;
    }

    public int getType() {
        return this.mType;
    }
    
    public int getNumArguments() {
        return this.mNumArguments;
    }
        
    public double eval(ArrayList<Double> arguments) throws InsufficientValuesException, InvalidArgumentsException {
        if(arguments.size() != this.mNumArguments) {
            throw new InsufficientValuesException();
        }
        
        return performEval(arguments);
    }

    protected abstract double performEval(ArrayList<Double> arguments) throws InvalidArgumentsException;
}
