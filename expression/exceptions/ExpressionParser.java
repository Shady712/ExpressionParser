package expression.exceptions;

import expression.*;
import expression.parser.*;

import java.util.Map;

public class ExpressionParser implements expression.exceptions.Parser {

    private static final Map<String, Variable> VARS = Map.of(
            "x", new Variable("x"),
            "y", new Variable("y"),
            "z", new Variable("z")
    );

    public TripleExpression parse(final String source) {
        return parse(new StringSource(source));
    }

    public static TripleExpression parse(CharSource source) {
        return new ExpressionParser.InternalParser(source).parseExpression();
    }

    private static class InternalParser extends BaseParser {

        public InternalParser(final CharSource source) {
            super(source);
            nextChar();
        }

        private Arguments parseExpression() {
            Arguments ans = parseGcdLcm();
            if (eof()) {
                return ans;
            } else {
                throw error("End of expression expected");
            }
        }

        private Arguments parseGcdLcm() {
            Arguments ans = parseAddSub();
            while (true) {
                if (test('g')) {
                    expectIdentifier('g', "cd");
                    ans = new Gcd(ans, parseAddSub());
                } else if (test('l')) {
                    expectIdentifier('l', "cm");
                    ans = new Lcm(ans, parseAddSub());
                } else {
                    return ans;
                }
            }
        }

        private Arguments parseAddSub() {
            Arguments ans = parseMulDiv();
            while (true) {
                if (test('+')) {
                    ans = new CheckedAdd(ans, parseMulDiv());
                } else if (test('-')) {
                    ans = new CheckedSubtract(ans, parseMulDiv());
                } else {
                    return ans;
                }
            }
        }

        private Arguments parseMulDiv() {
            Arguments ans = parseConstVar();
            while (true) {
                skipWhitespace();
                if (test('*')) {
                    ans = new CheckedMultiply(ans, parseConstVar());
                } else if (test('/')) {
                    ans = new CheckedDivide(ans, parseConstVar());
                } else {
                    return ans;
                }
            }
        }

        private Arguments parseConstVar() {
            skipWhitespace();
            if (test('-')) {
                if (between('0', '9')) {
                    return new Const(parseNumber("-"));
                } else {
                    return new CheckedNegate(parseConstVar());
                }
            } else if (between('0', '9')) {
                return new Const(parseNumber(""));
            } else if (test('(')) {
                Arguments parsedGcdLcm = parseGcdLcm();
                expect(')');
                return parsedGcdLcm;
            } else if (test('a')) {
                expectIdentifier('a', "bs");
                return new Abs(parseConstVar());
            } else if(test('s')) {
                expectIdentifier('s', "qrt");
                return new Sqrt(parseConstVar());
            } else {
                return parseVariable();
            }
        }

        private Variable parseVariable() {
            StringBuilder sb = new StringBuilder();
            while (Character.isLetter(ch)) {
                sb.append(ch);
                nextChar();
            }
            final String name = sb.toString();
            Variable result = VARS.get(name);
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

        private int parseNumber(final String beginning) {
            final StringBuilder sb = new StringBuilder(beginning);
            copyInteger(sb);
            if (test('.')) {
                throw error("Number is not integer " + sb);
            }
            try {
                return Integer.parseInt(sb.toString());
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

        private void skipWhitespace() {
            while (test(' ') || test('\r') || test('\n') || test('\t')) {
                // skipping whitespaces
            }
        }
    }
}

