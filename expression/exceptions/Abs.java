package expression.exceptions;

import expression.*;

public class Abs extends UnaryOperation {
    public Abs(Arguments arg) {
        super(arg);
    }

    @Override
    public String getOperator() {
        return "abs";
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int ans = arg.evaluate(x, y, z);
        if (ans < 0) {
            if (ans == Integer.MIN_VALUE) {
                throw new OverflowException(getOperator());
            }
            ans *= -1;
        }
        return ans;
    }
}