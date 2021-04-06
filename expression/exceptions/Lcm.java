package expression.exceptions;

import expression.*;

public class Lcm extends TripleExpressionOnly {

    public Lcm(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    public int getPriority(boolean position) {
        return -3;
    }

    @Override
    public String getOperator() {
        return "lcm";
    }

    @Override
    protected int calculate(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        return CheckedMultiply.getAns(CheckedDivide.getAns(x, Gcd.getAns(x, y)), y);
    }
}
