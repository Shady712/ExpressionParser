package expression.generic;

public class Variable<T> implements Expression<T> {
    private final String name;
    private final Calculator<T> calculator;

    public Variable(String name, Calculator<T> calculator) {
        this.name = name;
        this.calculator = calculator;
    }

    @Override
    public T evaluate(T x, T y, T z) {
        switch (name) {
            case "x":
                return calculator.convertVarType(x);
            case "y":
                return calculator.convertVarType(y);
            case "z":
                return calculator.convertVarType(z);
            default:
                throw new UnsupportedOperationException("Invalid variable name");
        }
    }
}
