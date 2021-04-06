package expression.generic;

import expression.exceptions.ZeroDivisionException;

import java.math.BigInteger;

public class BigIntegerCalculator implements Calculator<BigInteger> {

    @Override
    public BigInteger add(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    @Override
    public BigInteger subtract(BigInteger x, BigInteger y) {
        return x.subtract(y);
    }

    @Override
    public BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    @Override
    public BigInteger divide(BigInteger x, BigInteger y) {
        if (y.equals(new BigInteger("0"))) {
            throw new ZeroDivisionException();
        }
        return x.divide(y);
    }

    @Override
    public BigInteger negate(BigInteger x) {
        return x.negate();
    }

    @Override
    public BigInteger parse(String source) {
        return new BigInteger(source);
    }

    @Override
    public BigInteger convertConstType(int x) {
        return new BigInteger(Integer.toString(x));
    }

    @Override
    public BigInteger abs(BigInteger x) {
        return x.abs();
    }

    @Override
    public BigInteger square(BigInteger x) {
        return x.multiply(x);
    }

    @Override
    public BigInteger mod(BigInteger x, BigInteger y) {
        return x.mod(y);
    }

    @Override
    public BigInteger convertVarType(BigInteger x) {
        return x;
    }
}
