package expression;

public interface Arguments extends Expression, DoubleExpression, TripleExpression {
    int getPriority(boolean position);
    String getOperator();
}
