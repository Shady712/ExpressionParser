package expression.generic;

public class Multiply<T> extends BinaryOperator<T> {

    public Multiply(Expression<T> arg1, Expression<T> arg2, Calculator<T> calculator) {
        super(arg1, arg2, calculator);
    }

    @Override
    protected T calculate(T x, T y) {
        return calculator.multiply(x, y);
    }
}
