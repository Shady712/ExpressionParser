package expression;

public class Multiply extends BinaryOperator {

    public Multiply(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    protected int calculate(int x, int y) {
        return x * y;
    }

    @Override
    protected double calculate(double x, double y) {
        return x * y;
    }

    @Override
    public int getPriority(boolean position) {
        return 4;
    }
}
