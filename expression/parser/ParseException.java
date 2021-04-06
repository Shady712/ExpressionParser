package expression.parser;

import expression.exceptions.*;

public class ParseException extends ExpressionException {
    public ParseException(final String message) {
        super(message);
    }
}
