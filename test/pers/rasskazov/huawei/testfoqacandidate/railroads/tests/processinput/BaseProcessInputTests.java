package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.processinput;

import pers.rasskazov.huawei.testfoqacandidate.railroads.Railroads;
import pers.rasskazov.huawei.testfoqacandidate.railroads.tests.BaseRailroadsTests;
import pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.validation.OutputFileValidator;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.StringConstants.EmptyString;

abstract class BaseProcessInputTests extends BaseRailroadsTests {
    protected void processInputTest(Path folderPath, List<String> expectedOutput) {
        Railroads.main(new String[]{folderPath.toString()});

        assertEquals(EmptyString, errContent.toString(), "Errors were found errors in console output, but they shouldn't");

        OutputFileValidator.validateOutputFile(folderPath, expectedOutput);
    }
}
