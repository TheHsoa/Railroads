package pers.rasskazov.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.constants.RailroadsConstants;
import pers.rasskazov.railroads.exceptions.NumberOfTrainCoachesIncorrectFormatException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static pers.rasskazov.railroads.testsupport.ErrorMessageGenerator.generateOutputFileErrorMessage;
import static pers.rasskazov.railroads.testsupport.helpers.FileHelper.generateInputFileWithOneBlockForTest;
import static pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class NumberOfCoachesTests extends BaseProcessInputTests {
    @Test
    void negativeNumberOfCoaches_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "negativeNumberOfCoaches");

        int errorLineNumber = 1;
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, new NumberOfTrainCoachesIncorrectFormatException());
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void floatNumberOfCoaches_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "floatNumberOfCoaches");

        int errorLineNumber = 1;
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, new NumberOfTrainCoachesIncorrectFormatException());
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void numberOfCoachesEquals1000_allowed() throws IOException {
        int numberOfCoaches = 1000;
        Path inputFilePath = generateInputFileWithOneBlockForTest(numberOfCoaches);

        List<String> expectedOutputFileContent = Collections.singletonList(RailroadsConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(inputFilePath, expectedOutputFileContent);
    }

    @Test
    void numberOfCoachesEquals1001_errorOnLine() throws IOException {
        int numberOfCoaches = 1001;
        Path inputFilePath = generateInputFileWithOneBlockForTest(numberOfCoaches);

        int errorLineNumber = 1;
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, new NumberOfTrainCoachesIncorrectFormatException());
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(inputFilePath, expectedOutputFileContent);
    }
}
