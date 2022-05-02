package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.InputFileReadException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.RailroadsApplicationException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.helpers.ResourcesHelper;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.RailroadsConstants.InputFileName;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.ErrorMessageGenerator.generateFileNotFoundCauseExceptionMessage;

final class InputFileConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void inputFileNotExistsInDirectory_notAllowed() {
        Path directoryPath = ResourcesHelper.getClassResourcePath(getClass(), "inputFileNotExistsInDirectory");
        Path inputFilePath = directoryPath.resolve(InputFileName);

        RailroadsApplicationException expectedException =
                new InputFileReadException(inputFilePath, new FileNotFoundException(generateFileNotFoundCauseExceptionMessage(inputFilePath)));
        consoleErrorsTest(new String[]{directoryPath.toString()}, expectedException);
    }
}
