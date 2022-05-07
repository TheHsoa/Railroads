package pers.rasskazov.railroads.tests.consoleerrors;

import pers.rasskazov.railroads.Railroads;
import pers.rasskazov.railroads.tests.BaseRailroadsTests;
import pers.rasskazov.railroads.testsupport.StringConstants;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pers.rasskazov.railroads.testsupport.RailroadsErrorMessages.generateConsoleErrorMessage;

abstract class BaseConsoleErrorsTests extends BaseRailroadsTests {
    protected void consoleErrorsTest(String[] arguments, String expectedErrorMessage) {
        String expectedConsoleErrorMessage = generateConsoleErrorMessage(expectedErrorMessage);
        Railroads.main(arguments);
        String result = errContent.toString();
        assertTrue(result.contains(expectedConsoleErrorMessage), "Actual error message must contains expected." +
                System.lineSeparator() + "Actual message: " + result + System.lineSeparator() + "Expected message: " + expectedConsoleErrorMessage);
    }

    protected void consoleErrorsTest(String[] arguments) {
        consoleErrorsTest(arguments, StringConstants.EmptyString);
    }
}
