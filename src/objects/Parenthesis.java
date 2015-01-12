package objects;

public class Parenthesis extends MathObject {
    
    public final static Parenthesis LEFT_PARENTHESIS = new Parenthesis(TYPE_PARENTHESIS_LEFT);
    public final static Parenthesis RIGHT_PARENTHESIS = new Parenthesis(TYPE_PARENTHESIS_RIGHT);
        
    private Parenthesis(int type) {
        super(type == TYPE_PARENTHESIS_LEFT 
                ? "(" : type == TYPE_PARENTHESIS_RIGHT ? ")" : "", type);
    }
}
