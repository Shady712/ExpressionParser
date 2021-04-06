package expression.generic;

public abstract class UnaryOperation<T> implements Expression<T> {
    protected final Expression<T> arg;
    protected final Calculator<T> calculator;

    public UnaryOperation(Expression<T> arg, Calculator<T> calculator) {
        this.arg = arg;
        this.calculator = calculator;
    }

    protected abstract T calculate(T x);
    @Override
    public T evaluate(T x, T y, T z) {
        return calculate(arg.evaluate(x, y, z));
    }
}
