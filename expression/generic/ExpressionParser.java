package expression.generic;

import expression.*;
import expression.parser.*;

import java.util.Map;

public class ExpressionParser<T> extends BaseParser {
    private Calculator<T> calculator;

    public ExpressionParser() {
        super();
    }

    public ExpressionParser(final CharSource source) {
        super(source);
    }

    public ExpressionParser(final String source) {
        super(source);
    }

    public void setCalculator(final Calculator<T> calculator) {
        this.calculator = calculator;
    }

    public Expression<T> parse(String expression) {
        this.source = new StringSource(expression);
        nextChar();
        return parseExpression();
    }

    private Expression<T> parseExpression() {
        Expression<T> ans = parseAddSub();
        if (eof()) {
            return ans;
        } else {
            throw error("End of expression expected");
        }
    }

    private Expression<T> parseAddSub() {
        Expression<T> ans = parseMulDiv();
        while (true) {
            if (test('+')) {
                ans = new Add<>(ans, parseMulDiv(), calculator);
            } else if (test('-')) {
                ans = new Subtract<>(ans, parseMulDiv(), calculator);
            } else {
                return ans;
            }
        }
    }

    private Expression<T> parseMulDiv() {
        Expression<T> ans = parseConstVar();
        while (true) {
            skipWhiteSpace();
            if (test('*')) {
                ans = new Multiply<>(ans, parseConstVar(), calculator);
            } else if (test('/')) {
                ans = new Divide<>(ans, parseConstVar(), calculator);
            } else if (test('m')) {
                expectIdentifier('m', "od");
                ans = new Mod<>(ans, parseConstVar(), calculator);
            } else {
                return ans;
            }
        }
    }

    private Expression<T> parseConstVar() {
        skipWhiteSpace();
        if (test('-')) {
            if (between('0', '9')) {
                return new Const<>(parseNumber("-"), calculator);
            } else {
                return new Negate<>(parseConstVar(), calculator);
            }
        } else if (between('0', '9')) {
            return new Const<>(parseNumber(""), calculator);
        } else if (test('a')) {
            expectIdentifier('a', "bs");
            return new Abs<>(parseConstVar(), calculator);
        } else if (test('s')) {
            expectIdentifier('s', "quare");
            return new Square<>(parseConstVar(), calculator);
        } else if (test('(')) {
            Expression<T> parsedAddSub = parseAddSub();
            expect(')');
            return parsedAddSub;
        } else {
            return parseVariable();
        }
    }

    private Variable<T> parseVariable() {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(ch)) {
            sb.append(ch);
            nextChar();
        }
        final String name = sb.toString();
        Variable<T> result = new Variable<>(name, calculator);
        if (result == null) {
            if (name.isEmpty()) {
                throw error("Variable expected, but not found");
            } else {
                throw error("Invalid variable name: " + name);
            }
        } else {
            return result;
        }
    }

    private T parseNumber(final String beginning) {
        final StringBuilder sb = new StringBuilder(beginning);
        copyInteger(sb);
        if (test('.')) {
            throw error("Number is not integer " + sb);
        }
        try {
            return calculator.parse(sb.toString());
        } catch (NumberFormatException e) {
            throw error("Invalid number " + sb);
        }
    }

    private void copyDigits(final StringBuilder sb) {
        while (between('0', '9')) {
            sb.append(ch);
            nextChar();
        }
    }

    private void copyInteger(final StringBuilder sb) {
        if (test('0')) {
            sb.append('0');
        } else if (between('1', '9')) {
            copyDigits(sb);
        } else {
            throw error("Invalid number");
        }
    }

    private void skipWhiteSpace() {
        while (test(' ') || test('\r') || test('\n') || test('\t')) {
            // skipping whitespaces
        }
    }
}

