package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.DirectoryNotExistsException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.IncorrectPathForDirectoryException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.PathNotForDirectoryException;

import java.nio.file.Path;
import java.nio.file.Paths;

import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.StringConstants.EmptyString;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.StringGenerator.generateRandomIncorrectPathString;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.StringGenerator.generateRandomLatinAlphaNumericString;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

class DirectoryPathConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void directoryArgument_emptyString_notAllowed() {
        String directoryPathString = EmptyString;
        consoleErrorsTest(new String[]{directoryPathString},
                new DirectoryNotExistsException(Paths.get(directoryPathString)));
    }

    @Test
    void directoryArgument_invalidPath_notAllowed() {
        String directoryPathString = generateRandomIncorrectPathString();
        consoleErrorsTest(new String[]{directoryPathString},
                new IncorrectPathForDirectoryException(directoryPathString));
    }

    @Test
    void directoryArgument_nonExistentDirectory_notAllowed() {
        String directoryPathString = generateRandomLatinAlphaNumericString();
        consoleErrorsTest(new String[]{directoryPathString},
                new DirectoryNotExistsException(Paths.get(directoryPathString)));
    }

    @Test
    void directoryArgument_pathToFile_notAllowed() {
        Path directoryPath = getClassResourcePath(getClass(), "fileInsteadOfFolder.txt");
        consoleErrorsTest(new String[]{directoryPath.toString()}, new PathNotForDirectoryException(directoryPath));
    }
}
