package expression.generic;

public class Abs<T> extends UnaryOperation<T> {

    public Abs(Expression<T> arg, Calculator<T> calculator) {
        super(arg, calculator);
    }

    @Override
    protected T calculate(T x) {
        return calculator.abs(x);
    }
}
