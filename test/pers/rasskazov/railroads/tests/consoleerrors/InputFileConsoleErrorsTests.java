package pers.rasskazov.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.exceptions.InputFileReadException;
import pers.rasskazov.railroads.exceptions.RailroadsApplicationException;
import pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper;

import java.nio.file.Path;

import static pers.rasskazov.railroads.constants.RailroadsConstants.InputFileName;

final class InputFileConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void inputFileNotExistsInDirectory_notAllowed() {
        Path directoryPath = ResourcesHelper.getClassResourcePath(getClass(), "inputFileNotExistsInDirectory");
        Path inputFilePath = directoryPath.resolve(InputFileName);

        RailroadsApplicationException expectedException =
                new InputFileReadException(inputFilePath, null);
        consoleErrorsTest(new String[]{directoryPath.toString()}, expectedException);
    }
}
