package expression.exceptions;

import expression.*;

import java.util.InputMismatchException;

public class CheckedMultiply extends Multiply {

    public CheckedMultiply(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }

    @Override
    protected int calculate(int x, int y) {
        return getAns(x, y);
    }

    private static OverflowException overflow() {
        return new OverflowException("multiplication");
    }

    public static int getAns(int x, int y) {
        int ans = x * y;
        if (x != 0 && y != 0) {
            if ((x == Integer.MIN_VALUE && y != 1) || (y == Integer.MIN_VALUE && x != 1)) {
                throw overflow();
            } else if (ans == Integer.MIN_VALUE && Integer.MIN_VALUE / x == y) {
                return ans;
            } else if (Integer.MAX_VALUE / abs(x) < abs(y)) {
                throw overflow();
            }
        }
        return ans;
    }
}
