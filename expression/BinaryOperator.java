package expression;

public abstract class BinaryOperator implements Arguments {
    private final Arguments arg1;
    private final Arguments arg2;

    public BinaryOperator(Arguments arg1, Arguments arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    protected abstract int calculate(int x, int y);

    @Override
    public int evaluate(int val) {
        return calculate(arg1.evaluate(val), arg2.evaluate(val));
    }

    protected abstract double calculate(double x, double y);

    @Override
    public double evaluate(double val) {
        return calculate(arg1.evaluate(val), arg2.evaluate(val));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(arg1.evaluate(x, y, z), arg2.evaluate(x, y, z));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        BinaryOperator tmp = (BinaryOperator) obj;
        return tmp.arg1.equals(arg1) && tmp.arg2.equals(arg2);
    }

    @Override
    public int hashCode() {
        return 137 * arg1.hashCode() + 139 * arg2.hashCode() + 149 * this.getClass().hashCode();
    }

    public String toString() {
        return toString(this);
    }

    private String toString(BinaryOperator operator) {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(arg1.toString()).append(' ');
        sb.append(operator.getOperator());
        sb.append(' ').append(arg2.toString()).append(')');
        return sb.toString();
    }

    private void updateStringBuilder(StringBuilder sb, String add, boolean addBrackets) {
        if (addBrackets) {
            sb.append('(').append(add).append(')');
        } else {
            sb.append(add);
        }
    }

    public String toMiniString() {
        return toMiniString(this);
    }

    private String toMiniString(BinaryOperator operator) {
        StringBuilder sb = new StringBuilder();
        String left = arg1.toMiniString();
        String right = arg2.toMiniString();
        updateStringBuilder(sb, left, arg1.getPriority(true) < operator.getPriority(false));
        sb.append(' ').append(operator.getOperator()).append(' ');
        updateStringBuilder(sb, right, arg2.getPriority(false) < operator.getPriority(true));
        return sb.toString();
    }
}
