package objects;

public class Parenthesis extends MathObject {
    
    public final static Parenthesis LEFT_PARENTHESIS = new Parenthesis("(", TYPE_PARENTHESIS_LEFT);
    public final static Parenthesis RIGHT_PARENTHESIS = new Parenthesis(")", TYPE_PARENTHESIS_RIGHT);
        
    private Parenthesis(String name, int type) {
        super(name, type);
    }
}
