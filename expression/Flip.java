package expression;

public class Flip extends UnaryOperation {

    public Flip(Arguments arg) {
        super(arg);
    }

    @Override
    public String getOperator() {
        return "flip";
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int ans = arg.evaluate(x, y, z);
        return Integer.reverse(ans) >>> Integer.numberOfLeadingZeros(ans);
    }
}
