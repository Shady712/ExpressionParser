package expression.exceptions;

import expression.*;

public class CheckedAdd extends Add {

    public CheckedAdd(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    protected int calculate(int x, int y) {
        if (y > 0 && Integer.MAX_VALUE - y < x || y < 0 && Integer.MIN_VALUE - y > x) {
            throw new OverflowException("addition");
        }
        return x + y;
    }
}