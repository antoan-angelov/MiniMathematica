# MiniMathematica

Java tool for computing mathematical expressions.

Coursework for Data Structures and Algorithms @FMI

It uses [RPN (Reverse Polish Notation)](http://en.wikipedia.org/wiki/Reverse_Polish_notation) and [Shunting-yard algorithm](http://en.wikipedia.org/wiki/Shunting-yard_algorithm).

Supports the following functions and operators:
* arithmetic - addition (`+`), substraction (`-`), negation (`-`), multiplication (`*`), division (`/`)
* advanced - exponentiation (either `pow(x, n)` or `x^n`), nth root (`sqrt(x)` or `sqrtn(x, n)`), logarithms (`log(x, n)`)
* trigonometric - sine (`sin(x)`), cosine (`cos(x)`), tangent (`tan(x)`), cotangent (`cotan(x)`)

##Exapmles

```
$> java MiniMathematica "5 + sin(pi) / pow(2, 10) - log(e, pow(e, sqrt(4)))"
Result is 3.000001555325114
```

```
$> java MiniMathematica "cos(pi/2) + 3 ^ 2"
Result is 9.000796326710732
```

```
$> java MiniMathematica "0 ^ 0"
Expression contains invalid arguments.
```

##How to use

1. First of all, make sure you have Java installed.
2. Open your console and change your current directory to the `bin` folder of the project.
3. You can run the program in two ways:

```
$> java MiniMathematica 
$> Enter an expression: [expression]
```
or
```
$> java MiniMathematica [expression]
```

**IMPORTANT**: Make sure to _**always**_ put the expression in double quotes!

## License
```
The MIT License (MIT)

Copyright (c) 2015 Antoan Angelov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
