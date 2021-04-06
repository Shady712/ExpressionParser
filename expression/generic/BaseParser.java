package expression.generic;

import expression.parser.*;

public class BaseParser {
    public static final char END = '\0';
    protected CharSource source;
    protected char ch = 0xffff;

    protected BaseParser() {

    }

    protected BaseParser(final CharSource source) {
        this.source = source;
    }

    protected BaseParser(final String source) {
        this(new StringSource(source));
    }

    protected void nextChar() {
        ch = source.hasNext() ? source.next() : END;
    }

    protected boolean test(char expected) {
        if (ch == expected) {
            nextChar();
            return true;
        }
        return false;
    }

    protected void expect(final char c) {
        if (ch != c) {
            throw error("Expected '" + c + "', found '" + ch + "'");
        }
        nextChar();
    }

    protected void expect(final String value) {
        for (char c : value.toCharArray()) {
            expect(c);
        }
    }

    protected void expectIdentifier(char start, final String value) {
        expect(value);
        if (Character.isLetterOrDigit(ch)) {
            throw error("Invalid function name: " + start + value + ch);
        }
    }

    protected boolean eof() {
        return test(END);
    }

    protected ParseException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}
