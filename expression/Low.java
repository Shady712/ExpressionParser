package expression;

public class Low extends UnaryOperation {

    public Low(Arguments arg) {
        super(arg);
    }

    @Override
    public String getOperator() {
        return "low";
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Integer.lowestOneBit(arg.evaluate(x, y, z));
    }
}
