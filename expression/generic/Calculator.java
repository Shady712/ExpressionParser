package expression.generic;

public interface Calculator<T> {
    T add(T x, T y);
    T subtract(T x, T y);
    T multiply(T x, T y);
    T divide(T x, T y);
    T negate(T x);
    T parse(String source);
    T convertConstType(int x);
    T abs(T x);
    T square(T x);
    T mod(T x, T y);
    T convertVarType(T x);
}
