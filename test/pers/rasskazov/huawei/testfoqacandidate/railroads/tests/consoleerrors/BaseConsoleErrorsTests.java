package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.consoleerrors;

import pers.rasskazov.huawei.testfoqacandidate.railroads.Railroads;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.RailroadsApplicationException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.tests.BaseRailroadsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.ErrorMessageGenerator.generateConsoleErrorMessage;

abstract class BaseConsoleErrorsTests extends BaseRailroadsTests {
    protected void consoleErrorsTest(String[] arguments, String expectedErrorMessage) {
        Railroads.main(arguments);
        String result = errContent.toString();
        assertEquals(expectedErrorMessage + System.lineSeparator(), result);
    }

    protected void consoleErrorsTest(String[] arguments, RailroadsApplicationException expectedException) {
        consoleErrorsTest(arguments, generateConsoleErrorMessage(expectedException));
    }
}
