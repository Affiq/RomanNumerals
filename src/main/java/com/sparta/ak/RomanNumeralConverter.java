package com.sparta.ak;

public class RomanNumeralConverter {

    private static int[] numeralValues = new int[]{1000, 500, 100, 50, 10, 5, 1};
    private static char[] numeralLetters = new char[]{'M','D','C','L','X','V','I'};
    private static StringBuilder stringBuilder = new StringBuilder();


    public static String convert(int inputNumber) {
        int currentNumber = inputNumber;
        System.out.println("Current: " + currentNumber);
        String numeralString = "";
        for (int i=0; i < numeralValues.length; i++) {
            int numToReplicate = currentNumber / numeralValues[i];
            currentNumber = currentNumber - (numToReplicate * numeralValues[i]);

            char letterToReplicate = numeralLetters[i];

            numeralString = numeralString + replicateLetter(letterToReplicate, numToReplicate);
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
