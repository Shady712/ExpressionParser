package expression.generic;

public class Negate<T> extends UnaryOperation<T> {

    public Negate(Expression<T> arg, Calculator<T> calculator) {
        super(arg, calculator);
    }

    @Override
    protected T calculate(T x) {
        return calculator.negate(x);
    }
}
