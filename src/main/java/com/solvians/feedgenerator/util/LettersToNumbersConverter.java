package com.solvians.feedgenerator.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LettersToNumbersConverter {

    public static String message;


    public static Map<Character, Integer> lettersToNumbersMap() {
        char[] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Map<Character, Integer> lettersToNumber = new HashMap<>();

        lettersToNumber = IntStream.range(0, alphabetArray.length)
                .mapToObj(i -> new AbstractMap.SimpleImmutableEntry<>(alphabetArray[i], i + 10))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        return lettersToNumber;
    }


    /*
     Convert any letters to numbers by the conversion table below,
     e.g.“DE123456789” will be converted to “1314123456789”
     */
    public static List<Integer> getConvertedString(String letters) {
        String stringValues = letters.toUpperCase();
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> lettersToNumbersMap = lettersToNumbersMap();
        List<Integer> integerList = new ArrayList<>();
        for (int count = 0; count < stringValues.length(); count++) {
            Character val = stringValues.charAt(count);
            String str = String.valueOf(val);
            Integer integer = lettersToNumbersMap.get(val);
            if (Character.isDigit(stringValues.charAt(count))) {
                result.append(val);
                integerList.add((Integer.valueOf(str)));
            } else if (Character.isLetter(stringValues.charAt(count))) {
                if (null != integer) {
                    StringBuffer numberString = new StringBuffer();
                    char[] chars = Integer.toString(integer).toCharArray();
                    Integer intNum = 0;
                    for (int i = 0; i < chars.length; i++) {
                        numberString.append(chars[i]);
                        String strValue = new String();
                        strValue = String.valueOf(chars[i]);
                        integerList.add(Integer.valueOf(strValue));

                    }
                }
            }
        }
        return integerList;

    }

    /*
    Starting from the rightmost digit, every other digit is multiplied by two.
    In the example, we will have “2324226410614818”.
     */
    public static List<Integer> rightmostDigitTwoMultiplier(String strMsg) {
        List<Integer> listOfIntegers = getConvertedString(strMsg);
        //System.out.println("listOfIntegers  " + listOfIntegers);
        List<Integer> listOfIntegersDoubled = new ArrayList<>();
        String convertedStringMsg;

        for (int curIndex = 0;
             curIndex < listOfIntegers.size();
             curIndex++) {

            Integer newNumber = listOfIntegers.get(curIndex);
            if (curIndex % 2 == 0) {
                Integer num = newNumber * 2;

                listOfIntegersDoubled.add(num);
            } else {
                listOfIntegersDoubled.add(listOfIntegers.get(curIndex));
            }
        }

       // System.out.println("Doubled listOfIntegers  " + listOfIntegersDoubled);
        return listOfIntegersDoubled;
    }

    /*
    Add up the resulting string of digits (numbers greater than 9 becoming two separate digits).
    In the example, we will have 2+3+2+4+2+2+6+4+1+0+6+1+4+8+1+8 = 54.
     */
    public static int sumofAllDigitsGreaterThanNine(String strMsg) {
        List<Integer> doubledNumbers = rightmostDigitTwoMultiplier(strMsg);
        int sumForMoreThan1DigitNum = 0;
        int totalSum = 0;
        for (Integer num : doubledNumbers) {
            if (num > 9) {
                sumForMoreThan1DigitNum = sumOfMoreThan1DigitNum(num);
                totalSum = totalSum + sumForMoreThan1DigitNum;
            } else {
                totalSum = totalSum + num;
            }
        }
        //System.out.println("SUM  " +totalSum);
        return totalSum;

    }

    /*
    Subtract the sum from the smallest multiple of 10 which is greater than or equal to it,
    in the example we will have 60–54=6.
     */
    public static int checkDigit(String strMsg) {

        int n =sumofAllDigitsGreaterThanNine(strMsg);
        int smallestMultipleOfTenGreaterThanTheNum = ((n / 10) * 10)+10;
        int finalOutput= smallestMultipleOfTenGreaterThanTheNum-n;
        return finalOutput;

    }

    public static int sumOfMoreThan1DigitNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    /*public static void main(String[] args) {
        System.out.println("Final output " + checkDigit("DE123456789"));
    }*/
}
