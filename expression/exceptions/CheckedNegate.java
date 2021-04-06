package expression.exceptions;

import expression.*;

public class CheckedNegate extends Negate {

    public CheckedNegate(Arguments arg) {
        super(arg);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int ans = arg.evaluate(x, y, z);
        if (ans == Integer.MIN_VALUE) {
            throw new OverflowException("negation");
        }
        return -ans;
    }
}
