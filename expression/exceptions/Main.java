package expression.exceptions;

import expression.*;

public class Main {
    public static void main(String[] args) {
        ExpressionParser parser = new ExpressionParser();
        TripleExpression expression = parser.parse("1000000 * x * x * x * x * x / (x - 1)");
        System.out.println("x\t\tf");
        for (int f = 0; f <= 10; f++) {
            try {
                System.out.println(f + "\t\t" + expression.evaluate(f, f, f));
            } catch(EvaluateException e) {
                System.out.println(f + "\t\t" + e.getMessage());
            }
        }
    }
}
