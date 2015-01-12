package exceptions;

public class MismatchedParenException extends Exception {
   public MismatchedParenException() {
       super("Mismatched parenthesis.");
   }
}
