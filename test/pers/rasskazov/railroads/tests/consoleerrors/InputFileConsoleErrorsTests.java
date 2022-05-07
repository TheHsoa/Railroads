package pers.rasskazov.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper;

import java.nio.file.Path;

final class InputFileConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void inputFileNotExistsInDirectory_notAllowed() {
        Path directoryPath = ResourcesHelper.getClassResourcePath(getClass(), "inputFileNotExistsInDirectory");
        consoleErrorsTest(new String[]{directoryPath.toString()});
    }
}
