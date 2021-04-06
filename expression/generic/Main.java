package expression.generic;

public class Main {
    public static void main(String[] args) {
        ExpressionParser<Integer> parser = new ExpressionParser<>();
        parser.setCalculator(new CheckedIntCalculator());
        Expression<Integer> expression = parser.parse("10");
    }
}
