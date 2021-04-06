package expression;


public abstract class TripleExpressionOnly extends BinaryOperator {

    public TripleExpressionOnly(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    public int evaluate(int val) {
        return evaluate(val, val, val);
    }

    @Override
    public double evaluate(double val) {
        throw new UnsupportedOperationException("Triple Expression does not support this evaluation");
    }

    @Override
    protected double calculate(double x, double y) {
        throw new UnsupportedOperationException("Can't calculate from not integer numbers");
    }
}
