package expression;

public class Xor extends TripleExpressionOnly {

    public Xor(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    public int getPriority(boolean position) {
        return -1;
    }

    @Override
    public String getOperator() {
        return "^";
    }

    @Override
    protected int calculate(int x, int y) {
        return x ^ y;
    }
}
