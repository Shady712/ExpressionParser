package expression.exceptions;

public class ZeroDivisionException extends EvaluateException {
    public ZeroDivisionException() {
        super("division by zero");
    }
}
