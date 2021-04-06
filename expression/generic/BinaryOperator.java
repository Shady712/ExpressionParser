package expression.generic;

public abstract class BinaryOperator<T> implements Expression<T> {
    protected final Expression<T> arg1;
    protected final Expression<T> arg2;
    protected final Calculator<T> calculator;

    public BinaryOperator(Expression<T> arg1, Expression<T> arg2, Calculator<T> calculator) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.calculator = calculator;
    }

    protected abstract T calculate(T x, T y);

    @Override
    public T evaluate(T x, T y, T z) {
        return calculate(arg1.evaluate(x, y, z), arg2.evaluate(x, y, z));
    }
}
