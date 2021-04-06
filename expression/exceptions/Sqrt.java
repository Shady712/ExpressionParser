package expression.exceptions;

import expression.*;

public class Sqrt extends UnaryOperation{

    public Sqrt(Arguments arg) {
        super(arg);
    }

    @Override
    public String getOperator() {
        return "sqrt";
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int ans = arg.evaluate(x, y, z);
        if (ans < 0) {
            throw new NegativeInputException(getOperator());
        }
        return (int)Math.sqrt(ans);
    }
}
