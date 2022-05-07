package pers.rasskazov.railroads.tests.processinput;

import pers.rasskazov.railroads.Railroads;
import pers.rasskazov.railroads.tests.BaseRailroadsTests;
import pers.rasskazov.railroads.testsupport.StringConstants;
import pers.rasskazov.railroads.testsupport.validation.OutputFileValidator;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class BaseProcessInputTests extends BaseRailroadsTests {
    protected void processInputTest(Path folderPath, List<String> expectedOutput) {
        Railroads.main(new String[]{folderPath.toString()});

        assertEquals(StringConstants.EmptyString, errContent.toString(), "Errors were found errors in console output, but they shouldn't");

        OutputFileValidator.validateOutputFile(folderPath, expectedOutput);
    }
}
