# Roman Numerals Convertor

A short list of Roman numerals as exponents that may aid understanding:
- 1x10^n Exponents: M (1000), C(100), X(10), I(1)
- 5x10^n Exponents: D(500), L(50), V(5)

A program designed to convert arabic numerals to roman numerals. The program works by first trying to divide by the largest divisors first, and reduces it as much as possible until it cannot happen anymore, in which case it then moves to the next largest divisor.

This will end up producing some String that resembles something close to a roman numeral, but may require some formatting to remove quadruple letters.

To do this, starting with the I (1), we look for Roman Numeral sequence that satisfy the condition of containing I and is an exponent of 0.9x10^n. So in the first iteration, we will look for instances of VIIII, and replace them with IX accordingly.

While on the first iteration, we will then look for Roman numerals sequence that satisfy the condition of containing I and is an exponent of 0.4x10^n. So in the first iteration, we will look for IIII, and replace them with IV accordingly.

The first instance of detecting VIIII is done over IIII as performing them the other way around could potentially create an invalid string. This then iteratively happens for the next 1x10^n exponent except M.

For instance, before formatting, 9 will produce the Unformatted roman numeral:
- VIIII
- Performing IIII detection first produces VIV which is invalid
- Performing VIIII detection first produces IX which is valid.

Other interesting mathematical properties to note is that exponents of 0.5x10^n never appear consecutively twice.

## Unit Tests

The unit tests will test all strings from 1-3999 using a process called MethodSource, so that an external method may supply arguments.
From here, we are able to test if all digits in our test set produce any characters 4 consecutive times.
