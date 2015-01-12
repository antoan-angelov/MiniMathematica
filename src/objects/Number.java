package objects;

public class Number extends MathObject {

    protected double mValue;
    
    public Number(double value) {
        super(String.valueOf(value), TYPE_NUMBER);
        this.mValue = value;
    }
    
    protected Number(String name, double value, int type) {
        super(name, type);
        this.mValue = value;
    }
    
    public double getValue() {
        return this.mValue;
    }
}
