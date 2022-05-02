package pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport;

import java.security.SecureRandom;
import java.util.Random;

public final class StringGenerator {
    private static final String IncorrectPathSymbols = "/<>:]\\|?*";
    private static final String UpperLatinLetters = "ABCDEFGHIKLMNOPQRSTVXYZ";
    private static final String LowerLatinLetters = "abcdefghiklmnopqrstvxyz";
    private static final String LatinLetters = UpperLatinLetters + LowerLatinLetters;
    private static final String ArabicNumerals = "0123456789";

    private StringGenerator() {
        // No OP
    }

    public static String generateRandomIncorrectPathString(int length) {
        return generateRandomString(length, IncorrectPathSymbols);
    }

    public static String generateRandomLatinAlphaNumericString(int length) {
        return generateRandomString(length, LatinLetters + ArabicNumerals);
    }

    public static String generateRandomLatinAlphaNumericString() {
        return generateRandomLatinAlphaNumericString(100);
    }

    public static String generateRandomIncorrectPathString() {
        return generateRandomIncorrectPathString(100);
    }

    public static String generateRandomString(int length, String symbols) {
        if (length < 1) {
            throw new IllegalArgumentException();
        }
        if (symbols.length() < 2) {
            throw new IllegalArgumentException();
        }

        Random random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            stringBuilder.append(symbols.charAt(random.nextInt(symbols.length())));
        }

        return stringBuilder.toString();
    }
}
