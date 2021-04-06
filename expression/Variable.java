package expression;

public class Variable implements Arguments {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String getOperator() {
        return name;
    }

    @Override
    public int evaluate(int val) {
        return val;
    }

    @Override
    public double evaluate(double val) {
        return val;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (name.equals("x")) {
            return x;
        } else if (name.equals("y")) {
            return y;
        } else if (name.equals("z")) {
            return z;
        } else {
            throw new UnsupportedOperationException("Invalid variable names");
        }
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
        Variable tmp = (Variable) obj;
        return tmp.name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public String toMiniString() {
        return name;
    }
}
