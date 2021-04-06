package expression;

public abstract class UnaryOperation implements Arguments {
    protected final Arguments arg;

    public UnaryOperation(Arguments arg) {
        this.arg = arg;
    }

    public int getPriority(boolean position) {
        return 10;
    }

    @Override
    public int evaluate(int val) {
        return evaluate(val, val, val);
    }

    @Override
    public double evaluate(double val) {
        throw new UnsupportedOperationException("TripleExpression doesn't support this evaluation");
    }

    private String convertToString(boolean mini) {
        StringBuilder sb = new StringBuilder(getOperator());
        if (sb.charAt(0) != '-') {
            sb.append(' ');
        }
        if (mini) {
            sb.append(arg.toMiniString());
        } else {
            sb.append(arg.toString());
        }
        return sb.toString();
    }

    public String toString() {
        return convertToString(false);
    }

    public String toMiniString() {
        return convertToString(true);
    }
}
