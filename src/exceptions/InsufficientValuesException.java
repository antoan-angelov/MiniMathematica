package exceptions;

public class InsufficientValuesException extends Exception {
    public InsufficientValuesException() {
        super("Insufficient values in the expression for operator.");
    }
}
