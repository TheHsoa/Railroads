package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.huawei.testfoqacandidate.railroads.constants.RailroadsConstants;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.IncorrectNumberOfTrainCoachesException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.TrainCoachesIncorrectFormatException;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.ErrorMessageGenerator.generateForInputStringExceptionMessage;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.ErrorMessageGenerator.generateOutputFileErrorMessage;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class TrainCoachesTests extends BaseProcessInputTests {

    @Test
    void numberOfTrainCoachesNotEqualsNumberOfCoachesInBlock_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "numberOfTrainCoachesNotEqualsNumberOfCoachesInBlock");

        int errorLineNumber = 2;
        int numberOfCoachesInBlock = 5;
        int numberOfCoachesInTrain = 6;
        String errorMessage =
                generateOutputFileErrorMessage(errorLineNumber, new IncorrectNumberOfTrainCoachesException(numberOfCoachesInBlock, numberOfCoachesInTrain));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void notFormattedStringInTrainCoaches_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "notFormattedStringInTrainCoaches");

        int errorLineNumber = 2;
        String exceptionOnString = "incorrect";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber,
                new TrainCoachesIncorrectFormatException(new Exception(generateForInputStringExceptionMessage(exceptionOnString))));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void notFirstCoachInIncorrectFormat_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "notFirstCoachInIncorrectFormat");

        int errorLineNumber = 2;
        String exceptionOnString = "s";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber,
                new TrainCoachesIncorrectFormatException(new Exception(generateForInputStringExceptionMessage(exceptionOnString))));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void floatCoachNumber_errorOnLine() {
        Path directoryPath = getClassResourcePath(getClass(), "floatCoachNumber");

        int errorLineNumber = 2;
        String exceptionOnString = "1.5";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber,
                new TrainCoachesIncorrectFormatException(new Exception(generateForInputStringExceptionMessage(exceptionOnString))));
        List<String> expectedOutputFileContent = Collections.singletonList(errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void zeroCoachNumber_no() {
        Path directoryPath = getClassResourcePath(getClass(), "zeroCoachNumber");

        List<String> expectedOutputFileContent = Collections.singletonList(RailroadsConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalCoachesWithSameNumber_no() {
        Path directoryPath = getClassResourcePath(getClass(), "severalCoachesWithSameNumber");

        List<String> expectedOutputFileContent = Collections.singletonList(RailroadsConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void coachWithNumberGreaterThanNumberOfCoachesInBlock() {
        Path directoryPath = getClassResourcePath(getClass(), "coachWithNumberGreaterThanNumberOfCoachesInBlock");

        List<String> expectedOutputFileContent = Collections.singletonList(RailroadsConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }
}
