package expression.exceptions;

public class NegativeInputException extends EvaluateException {
    public NegativeInputException(String operation) {
        super("Can't calculate" + operation + "from negative number");
    }
}
