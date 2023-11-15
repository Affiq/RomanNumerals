package com.sparta.ak;

public class RomanNumeralConverter {

    private static int[] numeralValues = new int[]{1000, 500, 100, 50, 10, 5, 1};
    private static char[] numeralLetters = new char[]{'M','D','C','L','X','V','I'};
    private static StringBuilder stringBuilder;

    /* Due to the value each letter represents, you will only really run into
    consecutive values for C, X, I and M (which will be ignored). This is due to
    the nature of the larger divisors
    */

    public static String convert(int inputNumber) {
        String numeralString = getUnformattedConversion(inputNumber);
        // At this point, we have our numeral string, but will need formatting
        // i.e. LXXXXVIIII

        return formatNumeralString(numeralString);
    }
    private static String getUnformattedConversion(int inputNumber) {
        int currentNumber = inputNumber;
        System.out.println("Current: " + currentNumber);
        String numeralString = "";
        for (int i=0; i < numeralValues.length; i++) {
            int numToReplicate = currentNumber / numeralValues[i];
            char letterToReplicate = numeralLetters[i];

            currentNumber = currentNumber - (numToReplicate * numeralValues[i]);
            numeralString = numeralString + replicateLetter(letterToReplicate, numToReplicate);
        }

        return numeralString;
    }

    private static String formatNumeralString(String numeralString) {
        // Starting from the last Roman letter (I),
        // and decrement by 2 each loop to get to next x10 exponent
        // until we reach the second last letter in the list
        for (int i = numeralLetters.length-1; i >= 2; i=i-2) {

            // Search for 0.9x10^ns... (i.e. VIIII or LXXXX) and convert (i.e IX or XC)
            String searchedSubstring = numeralLetters[i-1] +
                    replicateLetter(numeralLetters[i],4);
            String replaceWithSubstring = new StringBuilder()
                    .append(numeralLetters[i])
                    .append(numeralLetters[i-2]).
                    toString();

            numeralString = numeralString.replace(searchedSubstring, replaceWithSubstring);

            // Search for 0.4x10^ns... (i.e. IIII or XXXX) and convert (i.e IV or XL)
            searchedSubstring = replicateLetter(numeralLetters[i],4);
            replaceWithSubstring = new StringBuilder()
                    .append(numeralLetters[i])
                    .append(numeralLetters[i-1]).
                    toString();

            numeralString = numeralString.replace(searchedSubstring, replaceWithSubstring);
        }

        return numeralString;
    }

    private static String replicateLetter(char letterToReplicate, int numOfReplications) {
        String replicatedLetters = "";
        for (int j=0; j!=numOfReplications; j++) {
            replicatedLetters = replicatedLetters + letterToReplicate;
        }
        return replicatedLetters;
    }

}
