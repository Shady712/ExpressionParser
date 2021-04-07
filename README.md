# ExpressionParser
Mathematical expressions implementation. Expression parser implementation (recursive decent method). 

# Mathematical expressions
This code is the implementation of mathematical expressions (expression package). The code is based on objective-oriented programming methods: the common code is moved to parent classes, classes implement interfaces, abstract classes are used too. So, mathematical addition, subtraction, division, multiplication, negation, constants and variables are implemented this way. Expressions can be evaluated with three variables: x, y and z. Encapsulation rules are also followed.

# Parser
This code is the implementation of mathematical expressions parser (expression.parser package). This parser returns mathematical expression based on classes from the first package using string from the input. The parser is based on recursive descent method. Some operations are added too (bitwise operations: and, or, xor, etc.).

# Exceptions
This code adds specific exceptions for expressions and parser. For example, if input string for parser is incorrect then human-readable exception is thrown. The exception's message shows the positions and the type of the error (invalid variable name, invalid function, etc.). Some other operations added (abs, sqrt, ...). Evaluation exceptions are implemented and checked in the specified classes too.

# Generic
This code is the implementation of mathematical expressions and expression parser with usage of java generics. Generic tabulator is the class which calculates the value of the expression in different types (integer, float, byte, etc.) in different ranges of variables' values. The version of parser based on generics is also implemented.

# General principles
All the code follows the rule of encapsulation: no undesirable changes in random parts of the program are available. The common code is moved to parent's class (if such exists), for example: BinaryOperator, UnaryOperator, etc. The implementation is based on java classes and, therefore, objective-oriented programming methods.
