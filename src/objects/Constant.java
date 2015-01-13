package objects;
import java.util.ArrayList;

public class Constant extends Number {

    private final static ArrayList<Constant> CONSTANTS = new ArrayList<>();
    
    public final static Constant CONSTANT_PI = new Constant("pi", 3.14159265359);
    public final static Constant CONSTANT_E = new Constant("e", 2.71828);
    
    private Constant(String name, double value) {
        super(name, value, TYPE_CONSTANT);        
        CONSTANTS.add(this);                     
    }
    
    public static Constant getConstantToken(String expression, int startFrom) {
        return (Constant) find(expression, startFrom, CONSTANTS);
    }
}
