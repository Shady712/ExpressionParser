package expression;

public class Const implements Arguments {
    private final Number value;

    public Const(Number value) {
        this.value = value;
    }

    @Override
    public String getOperator() {
        return value.toString();
    }

    @Override
    public int evaluate(int val) {
        return value.intValue();
    }

    @Override
    public double evaluate(double val) {
        return value.doubleValue();
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return value.intValue();
    }

    @Override
    public int getPriority(boolean position) {
        return 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Const tmp = (Const) obj;
        return tmp.value.equals(value);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value.doubleValue());
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public String toMiniString() {
        return value.toString();
    }
}
