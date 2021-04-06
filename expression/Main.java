package expression;

public class Main {
    public static void main(String[] args) {
        final Add expression = new Add(
                new Subtract(
                        new Multiply(new Variable("x"), new Variable("x")),
                        new Multiply(new Const(2), new Variable("x"))
                ),
                new Const(1)
        );
        System.out.println(expression);
        System.out.println(expression.toMiniString());
        System.out.println(expression.evaluate(5));
    }
}
