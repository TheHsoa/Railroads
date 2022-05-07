package pers.rasskazov.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.testsupport.StringConstants;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static pers.rasskazov.railroads.testsupport.RailroadsErrorMessages.generateForInputStringExceptionMessage;
import static pers.rasskazov.railroads.testsupport.RailroadsErrorMessages.generateOutputFileErrorMessage;
import static pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class BlocksTests extends BaseProcessInputTests {
    @Test
    void noReorganizationsInBlock_emptyResult() {
        Path directoryPath = getClassResourcePath(getClass(), "noReorganizationsInBlock");

        processInputTest(directoryPath, new LinkedList<>());
    }

    @Test
    void severalValidBlocksWithReorganizations() {
        Path directoryPath = getClassResourcePath(getClass(), "severalValidBlocksWithReorganizations");

        List<String> expectedOutputFileContent = Arrays.asList(StringConstants.ItPossibleToMarshalTheCoaches,
                StringConstants.EmptyString,
                StringConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalValidBlocksOneWithoutReorganizations_emptyResultForBlockWithoutReorganizations() {
        Path directoryPath = getClassResourcePath(getClass(), "severalValidBlocksOneWithoutReorganizations");

        List<String> expectedOutputFileContent = Arrays.asList(StringConstants.ItPossibleToMarshalTheCoaches,
                StringConstants.EmptyString,
                StringConstants.EmptyString,
                StringConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalReorganizationsInOneBlock() {
        Path directoryPath = getClassResourcePath(getClass(), "severalReorganizationsInOneBlock");

        List<String> expectedOutputFileContent = Arrays.asList(StringConstants.ItPossibleToMarshalTheCoaches, StringConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void lastBlockWithout0_allowed() {
        Path directoryPath = getClassResourcePath(getClass(), "lastBlockWithout0");

        List<String> expectedOutputFileContent = Collections.singletonList(StringConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalBlocks_inNotLastAndNotFirstError_processedToError() {
        Path directoryPath = getClassResourcePath(getClass(), "severalBlocks_inNotLastAndNotFirstError");

        int errorLineNumber = 5;
        String exceptionOnString = "s";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, generateForInputStringExceptionMessage(exceptionOnString));
        List<String> expectedOutputFileContent = Arrays.asList(StringConstants.ItPossibleToMarshalTheCoaches, StringConstants.EmptyString, errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalReorganizationsInOneBlock_inNotLastAndNotFirstError_processedToError() {
        Path directoryPath = getClassResourcePath(getClass(), "severalReorganizationsInOneBlock_inNotLastAndNotFirstError");

        int errorLineNumber = 3;
        String exceptionOnString = "s";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, generateForInputStringExceptionMessage(exceptionOnString));
        List<String> expectedOutputFileContent = Arrays.asList(StringConstants.ItPossibleToMarshalTheCoaches, errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }
}
