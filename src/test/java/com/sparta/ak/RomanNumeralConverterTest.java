package com.sparta.ak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class RomanNumeralConverterTest {

    @ParameterizedTest
    @MethodSource("intArrayProvider")
    @DisplayName("Test for consecutive IIII")
    public void testForQuadrupleLetters(int arabicNumeral) {
        String numeralString = RomanNumeralConverter.convert(arabicNumeral);
        Assertions.assertEquals(false, numeralString.contains("IIII"));
        Assertions.assertEquals(false, numeralString.contains("VVVV"));
        Assertions.assertEquals(false, numeralString.contains("XXXX"));
        Assertions.assertEquals(false, numeralString.contains("CCCC"));
        Assertions.assertEquals(false, numeralString.contains("LLLL"));
        Assertions.assertEquals(false, numeralString.contains("DDDD"));
    }



    //Generate full test set
    private static Integer[] generateFullTestSet() {
        Integer[] fullTestSetArray = new Integer[3998];

        int base = 1;
        for (int i=0; i < fullTestSetArray.length; i++) {
            fullTestSetArray[i] = base;
            base++;
        }

        return fullTestSetArray;
    }

    // Needed to supply a method source
    static Stream<Integer> intArrayProvider() {
        return Stream.of(generateFullTestSet());
    }

}
