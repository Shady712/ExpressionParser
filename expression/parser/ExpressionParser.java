package expression.parser;

import expression.*;

import java.util.Map;

public class ExpressionParser implements Parser {

    private static final Variable VAR_X = new Variable("x");
    private static final Variable VAR_Y = new Variable("y");
    private static final Variable VAR_Z = new Variable("z");
    private static final Map<String, Variable> VARS = Map.of(
            "x", VAR_X,
            "y", VAR_Y,
            "z", VAR_Z
    );

    public TripleExpression parse(final String source) {
        return parse(new StringSource(source));
    }

    public static TripleExpression parse(CharSource source) {
        return new InternalParser(source).parseExpression();
    }

    private static class InternalParser extends BaseParser {
        public InternalParser(final CharSource source) {
            super(source);
            nextChar();
        }

        private Arguments parseExpression() {
            Arguments ans = parseOr();
            if (!eof()) {
                throw error("End of expression expected");
            } else {
                return ans;
            }
        }

        private Arguments parseOr() {
            Arguments ans = parseXor();
            while (true) {
                if (test('|')) {
                    ans = new Or(ans, parseXor());
                } else {
                    return ans;
                }
            }
        }

        private Arguments parseXor() {
            Arguments ans = parseAnd();
            while (true) {
                if (test('^')) {
                    ans = new Xor(ans, parseAnd());
                } else {
                    return ans;
                }
            }
        }

        private Arguments parseAnd() {
            Arguments ans = parseAddSub();
            while (true) {
                if (test('&')) {
                    ans = new And(ans, parseAddSub());
                } else {
                    return ans;
                }
            }
        }

        private Arguments parseAddSub() {
            Arguments ans = parseMulDiv();
            while (true) {
                if (test('+')) {
                    ans = new Add(ans, parseMulDiv());
                } else if (test('-')) {
                    ans = new Subtract(ans, parseMulDiv());
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
                    ans = new Multiply(ans, parseConstVar());
                } else if (test('/')) {
                    ans = new Divide(ans, parseConstVar());
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
                    return new Negate(parseConstVar());
                }
            } else if (between('0', '9')) {
                return new Const(parseNumber(""));
            } else if (test('(')) {
                Arguments result = parseOr();
                expect(')');
                return result;
            } else if (test('f')) {
                expectIdentifier('f', "lip");
                return new Flip(parseConstVar());
            } else if(test('l')) {
                expectIdentifier('l', "ow");
                return new Low(parseConstVar());
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
                result = new Variable(name);
            }
            return result;
        }

        private Number parseNumber(final String beginning) {
            final StringBuilder sb = new StringBuilder(beginning);
            copyInteger(sb);
            if (test('.')) {
                sb.append('.');
                copyDigits(sb);
            }
            try {
                return Double.parseDouble(sb.toString());
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
