package expression.generic;

public class DoubleCalculator implements Calculator<Double> {

    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiply(Double x, Double y) {
        return x * y;
    }

    @Override
    public Double divide(Double x, Double y) {
        return x / y;
    }

    @Override
    public Double negate(Double x) {
        return -x;
    }

    @Override
    public Double parse(String source) {
        return Double.parseDouble(source);
    }

    @Override
    public Double convertConstType(int x) {
        return (double) x;
    }

    @Override
    public Double abs(Double x) {
        return x < 0 ? -x : x;
    }

    @Override
    public Double square(Double x) {
        return x * x;
    }

    @Override
    public Double mod(Double x, Double y) {
        return x % y;
    }

    @Override
    public Double convertVarType(Double x) {
        return x;
    }
}
