package expression.generic;

public class ByteCalculator implements Calculator<Byte> {

    @Override
    public Byte add(Byte x, Byte y) {
        return (byte)(x + y);
    }

    @Override
    public Byte subtract(Byte x, Byte y) {
        return (byte)(x - y);
    }

    @Override
    public Byte multiply(Byte x, Byte y) {
        return (byte)(x * y);
    }

    @Override
    public Byte divide(Byte x, Byte y) {
        return (byte)(x / y);
    }

    @Override
    public Byte negate(Byte x) {
        return (byte)-x;
    }

    @Override
    public Byte parse(String source) {
        return Byte.parseByte(source);
    }

    @Override
    public Byte convertConstType(int x) {
        return (byte)x;
    }

    @Override
    public Byte abs(Byte x) {
        return x < 0 ? (byte)-x : x;
    }

    @Override
    public Byte square(Byte x) {
        return (byte)(x * x);
    }

    @Override
    public Byte mod(Byte x, Byte y) {
        return (byte)(x % y);
    }

    @Override
    public Byte convertVarType(Byte x) {
        return x;
    }
}
