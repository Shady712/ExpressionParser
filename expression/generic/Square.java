package expression.generic;

public class Square<T> extends UnaryOperation<T> {

    public Square(Expression<T> arg, Calculator<T> calculator) {
        super(arg, calculator);
    }

    @Override
    protected T calculate(T x) {
        return calculator.square(x);
    }
}
