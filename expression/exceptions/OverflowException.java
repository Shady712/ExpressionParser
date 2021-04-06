package expression.exceptions;

public class OverflowException extends EvaluateException {
    public OverflowException(String operation) {
        super(operation + " overflow");
    }
}
