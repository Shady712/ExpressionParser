package expression.generic;

public class Const<T> implements Expression<T> {
    private final T value;
    private final Calculator<T> calculator;

    public Const(T value, Calculator<T> calculator) {
        this.value = value;
        this.calculator = calculator;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        return calculator.convertVarType(value);
    }
}
