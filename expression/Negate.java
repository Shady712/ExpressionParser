package expression;

public class Negate extends UnaryOperation {

    public Negate(Arguments arg) {
        super(arg);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return -arg.evaluate(x, y, z);
    }

    @Override
    public String getOperator() {
        return "-";
    }
}
