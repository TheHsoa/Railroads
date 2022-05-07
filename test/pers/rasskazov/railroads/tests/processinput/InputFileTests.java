package pers.rasskazov.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.testsupport.RailroadsErrorMessages;
import pers.rasskazov.railroads.testsupport.StringConstants;

import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static pers.rasskazov.railroads.testsupport.RailroadsErrorMessages.generateOutputFileErrorMessage;
import static pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class InputFileTests extends BaseProcessInputTests {

    @Test
    void emptyInputFile_emptyResult() {
        Path directoryPath = getClassResourcePath(getClass(), "emptyInputFile");

        processInputTest(directoryPath, new LinkedList<>());
    }

    @Test
    void only0InFile_emptyResult() {
        Path directoryPath = getClassResourcePath(getClass(), "only0InFile");

        processInputTest(directoryPath, new LinkedList<>());
    }

    @Test
    void notFormattedContentInFile_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "notFormattedContentInFile");

        int errorLineNumber = 1;
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, RailroadsErrorMessages.generateForInputStringExceptionMessage("Railroads"));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void fileEndsWithout0_allowed() {
        Path directoryPath = getClassResourcePath(getClass(), "fileEndsWithout0");

        List<String> expectedOutputFileContent = Collections.singletonList(StringConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }
}
