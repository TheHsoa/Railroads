package pers.rasskazov.railroads.tests.consoleerrors;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.testsupport.StringConstants;

import java.nio.file.Path;

import static pers.rasskazov.railroads.testsupport.StringGenerator.generateRandomIncorrectPathString;
import static pers.rasskazov.railroads.testsupport.StringGenerator.generateRandomLatinAlphaNumericString;
import static pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

class DirectoryPathConsoleErrorsTests extends BaseConsoleErrorsTests {
    @Test
    void directoryArgument_emptyString_notAllowed() {
        consoleErrorsTest(new String[]{StringConstants.EmptyString});
    }

    @Test
    void directoryArgument_invalidPath_notAllowed() {
        String directoryPathString = generateRandomIncorrectPathString();
        consoleErrorsTest(new String[]{directoryPathString});
    }

    @Test
    void directoryArgument_nonExistentDirectory_notAllowed() {
        String directoryPathString = generateRandomLatinAlphaNumericString();
        consoleErrorsTest(new String[]{directoryPathString});
    }

    @Test
    void directoryArgument_pathToFile_notAllowed() {
        Path directoryPath = getClassResourcePath(getClass(), "fileInsteadOfFolder.txt");
        consoleErrorsTest(new String[]{directoryPath.toString()});
    }
}
