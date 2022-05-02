package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.DirectoryNotSetException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.EmptyArgumentsException;

final class ParseArgumentsConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void nullArguments_notAllowed() {
        consoleErrorsTest(null, new EmptyArgumentsException());
    }

    @Test
    void zeroLengthArrayInArguments_notAllowed() {
        consoleErrorsTest(new String[0], new EmptyArgumentsException());
    }

    @Test
    void notInitializedArrayInArguments_notAllowed() {
        consoleErrorsTest(new String[1], new DirectoryNotSetException());
    }
}
