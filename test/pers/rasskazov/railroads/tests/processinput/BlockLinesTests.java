package pers.rasskazov.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.testsupport.StringConstants;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static pers.rasskazov.railroads.testsupport.RailroadsErrorMessages.generateForInputStringExceptionMessage;
import static pers.rasskazov.railroads.testsupport.RailroadsErrorMessages.generateOutputFileErrorMessage;
import static pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class BlockLinesTests extends BaseProcessInputTests {

    @Test
    void numberOfCoachesInLineNotEqualsNumberOfCoachesInBlock_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "numberOfCoachesInLineNotEqualsNumberOfCoachesInBlock");

        int errorLineNumber = 2;
        String errorMessage =
                generateOutputFileErrorMessage(errorLineNumber, "Coaches count does not match to number of coaches in block.");
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void notFormattedStringInBlockLine_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "notFormattedStringInBlockLine");

        int errorLineNumber = 2;
        String exceptionOnString = "incorrect";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, generateForInputStringExceptionMessage(exceptionOnString));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void notFirstCoachInIncorrectFormat_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "notFirstCoachInIncorrectFormat");

        int errorLineNumber = 2;
        String exceptionOnString = "s";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, generateForInputStringExceptionMessage(exceptionOnString));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void floatCoachNumber_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "floatCoachNumber");

        int errorLineNumber = 2;
        String exceptionOnString = "1.5";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber, generateForInputStringExceptionMessage(exceptionOnString));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void zeroCoachNumber_no() {
        Path directoryPath = getClassResourcePath(getClass(), "zeroCoachNumber");

        List<String> expectedOutputFileContent = Collections.singletonList(StringConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalCoachesWithSameNumber_no() {
        Path directoryPath = getClassResourcePath(getClass(), "severalCoachesWithSameNumber");

        List<String> expectedOutputFileContent = Collections.singletonList(StringConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void coachWithNumberGreaterThanNumberOfCoachesInBlock_no() {
        Path directoryPath = getClassResourcePath(getClass(), "coachWithNumberGreaterThanNumberOfCoachesInBlock");

        List<String> expectedOutputFileContent = Collections.singletonList(StringConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }
}
