package pers.rasskazov.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;

final class ParseArgumentsConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void nullArguments_notAllowed() {
        consoleErrorsTest(null);
    }

    @Test
    void zeroLengthArrayInArguments_notAllowed() {
        consoleErrorsTest(new String[0]);
    }

    @Test
    void notInitializedArrayInArguments_notAllowed() {
        consoleErrorsTest(new String[1]);
    }
}
