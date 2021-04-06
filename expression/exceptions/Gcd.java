package expression.exceptions;

import expression.*;

public class Gcd extends TripleExpressionOnly {

    public Gcd(Arguments arg1, Arguments arg2) {
        super(arg1, arg2);
    }

    @Override
    public int getPriority(boolean position) {
        return -3;
    }

    @Override
    public String getOperator() {
        return "gcd";
    }

    private static int abs(int x) {
        return x < 0 ? -x : x;
    }

    private static int euclid(int x, int y) {
        while (y > 0) {
            x %= y;
            int t = x;
            x = y;
            y = t;
        }
        return x;
    }

    @Override
    protected int calculate(int x, int y) {
        return getAns(x, y);
    }

    public static int getAns(int x, int y) {
        if (x == Integer.MIN_VALUE && y == Integer.MIN_VALUE) {
            throw new OverflowException("gcd");
        }
        if (y > x) {
            int t = x;
            x = y;
            y = t;
        }
        int tmp = y == Integer.MIN_VALUE ? y % abs(x) + abs(x) : y;
        return abs(x) < abs(tmp) ? euclid(abs(tmp), abs(x)) : euclid(abs(x), abs(tmp));
    }
}
