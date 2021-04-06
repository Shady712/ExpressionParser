package expression.generic;

import expression.exceptions.OverflowException;
import expression.exceptions.ZeroDivisionException;

public class CheckedIntCalculator extends UncheckedIntCalculator {

    @Override
    public Integer add(Integer x, Integer y) {
        if (y > 0 && Integer.MAX_VALUE - y < x || y < 0 && Integer.MIN_VALUE - y > x) {
            throw new OverflowException("addition");
        }
        return super.add(x, y);
    }

    @Override
    public Integer subtract(Integer x, Integer y) {
        if (y > 0 && Integer.MIN_VALUE + y > x || y < 0 && Integer.MAX_VALUE + y < x) {
            throw new OverflowException("subtraction");
        }
        return super.subtract(x, y);
    }

    @Override
    public Integer multiply(Integer x, Integer y) {
        if (x != 0 && y != 0) {
            if ((x == Integer.MIN_VALUE && y != 1) || (y == Integer.MIN_VALUE && x != 1)) {
                throw new OverflowException("multiplication");
            } else if (x * y == Integer.MIN_VALUE && Integer.MIN_VALUE / x == y) {
                return x * y;
            } else if (Integer.MAX_VALUE / abs(x) < abs(y)) {
                throw new OverflowException("multiplication");
            }
        }
        return super.multiply(x, y);
    }

    @Override
    public Integer divide(Integer x, Integer y) {
        if (y == 0) {
            throw new ZeroDivisionException();
        }
        if (y == -1 && x == Integer.MIN_VALUE) {
            throw new OverflowException("division");
        }
        return super.divide(x, y);
    }

    @Override
    public Integer negate(Integer x) {
        if (x == Integer.MIN_VALUE) {
            throw new OverflowException("negation");
        }
        return super.negate(x);
    }

    @Override
    public Integer abs(Integer x) {
        if (x < 0) {
            if (x == Integer.MIN_VALUE) {
                throw new OverflowException("abs");
            }
            x *= -1;
        }
        return super.abs(x);
    }

    @Override
    public Integer square(Integer x) {
        if (x != 0) {
            if (x * x == Integer.MIN_VALUE && Integer.MIN_VALUE / x == x) {
                return x * x;
            } else if (Integer.MAX_VALUE / abs(x) < abs(x)) {
                throw new OverflowException("multiplication");
            }
        }
        return super.square(x);
    }
}
