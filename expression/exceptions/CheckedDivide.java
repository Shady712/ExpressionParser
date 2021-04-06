package expression.exceptions;

import expression.*;

public class CheckedDivide extends Divide {

    public CheckedDivide(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    protected int calculate(int x, int y) {
        return getAns(x, y);
    }

    public static int getAns(int x, int y) {
        if (y == 0) {
            throw new ZeroDivisionException();
        }
        if (y == -1 && x == Integer.MIN_VALUE) {
            throw new OverflowException("division");
        }
        return x / y;
    }

}
