package expression.parser;

import expression.TripleExpression;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse("x * (x - 2) * x + 1");
        for (int i = 0; i <= 10; i++) {
            System.out.println("f(" + i + ") = " + expression.evaluate(i, i, i));
        }
    }
}
