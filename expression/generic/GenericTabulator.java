package expression.generic;

public class GenericTabulator implements Tabulator {
    public static void main(String[] args) throws Exception {
        GenericTabulator tabulator = new GenericTabulator();
        int x1, x2, y1, y2, z1, z2;
        x1 = y1 = z1 = -2;
        x2 = y2 = z2 = 2;
        Object[][][] result = tabulator.tabulate(args[0], args[1], x1, x2, y1, y2, z1, z2);
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    System.out.println("x = " + x + " ; y = " + y + " ; z = " + z + " ; result = " + result[x - x1][y - y1][z - z1]);
                }
            }
        }
    }

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        return getAns(getCalculator(mode), expression, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] getAns(Calculator<T> calculator, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        ExpressionParser<T> parser = new ExpressionParser<>();
        parser.setCalculator(calculator);
        Expression<T> exp = parser.parse(expression);
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                for (int z = z1; z <= z2; z++) {
                    try {
                        result[x - x1][y - y1][z - z1] = exp.evaluate(calculator.convertConstType(x), calculator.convertConstType(y), calculator.convertConstType(z));
                    } catch (Exception e) {
                        result[x - x1][y - y1][z - z1] = null;
                    }
                }
            }
        }
        return result;
    }

    private Calculator<?> getCalculator(String mode) {
        switch (mode) {
            case "i":
                return new CheckedIntCalculator();
            case "d":
                return new DoubleCalculator();
            case "bi":
                return new BigIntegerCalculator();
            case "u":
                return new UncheckedIntCalculator();
            case "p":
                return new Module1009Calculator();
            case "b":
                return new ByteCalculator();
            default:
                throw new UnsupportedOperationException("Invalid evaluation mode");
        }
    }
}
