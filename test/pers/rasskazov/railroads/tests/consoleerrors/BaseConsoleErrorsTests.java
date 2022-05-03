package pers.rasskazov.railroads.tests.consoleerrors;

import pers.rasskazov.railroads.Railroads;
import pers.rasskazov.railroads.exceptions.RailroadsApplicationException;
import pers.rasskazov.railroads.tests.BaseRailroadsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pers.rasskazov.railroads.testsupport.ErrorMessageGenerator.generateConsoleErrorMessage;

abstract class BaseConsoleErrorsTests extends BaseRailroadsTests {
    protected void consoleErrorsTest(String[] arguments, String expectedErrorMessage) {
        Railroads.main(arguments);
        String result = errContent.toString();
        assertTrue(result.contains(expectedErrorMessage), "Actual error message must contains expected." +
                System.lineSeparator() + "Actual message: " + result + System.lineSeparator() + "Expected message: " + expectedErrorMessage);
    }

    protected void consoleErrorsTest(String[] arguments, RailroadsApplicationException expectedException) {
        consoleErrorsTest(arguments, generateConsoleErrorMessage(expectedException));
    }
}
