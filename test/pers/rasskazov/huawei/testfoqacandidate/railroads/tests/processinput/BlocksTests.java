package pers.rasskazov.huawei.testfoqacandidate.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.huawei.testfoqacandidate.railroads.constants.RailroadsConstants;
import pers.rasskazov.huawei.testfoqacandidate.railroads.constants.StringConstants;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.TrainCoachesIncorrectFormatException;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.ErrorMessageGenerator.generateForInputStringExceptionMessage;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.ErrorMessageGenerator.generateOutputFileErrorMessage;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class BlocksTests extends BaseProcessInputTests {
    @Test
    void noTrainsInBlock_emptyResult() {
        Path directoryPath = getClassResourcePath(getClass(), "noTrainsInBlock");

        processInputTest(directoryPath, new LinkedList<>());
    }

    @Test
    void severalValidBlocksWithTrains() {
        Path directoryPath = getClassResourcePath(getClass(), "severalValidBlocksWithTrains");

        List<String> expectedOutputFileContent = Arrays.asList(RailroadsConstants.ItPossibleToMarshalTheCoaches,
                StringConstants.EmptyString,
                RailroadsConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalValidBlocksOneWithoutTrains_emptyResultForBlockWithoutTrains() {
        Path directoryPath = getClassResourcePath(getClass(), "severalValidBlocksOneWithoutTrains");

        List<String> expectedOutputFileContent = Arrays.asList(RailroadsConstants.ItPossibleToMarshalTheCoaches,
                StringConstants.EmptyString,
                StringConstants.EmptyString,
                RailroadsConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalTrainsInOneBlock() {
        Path directoryPath = getClassResourcePath(getClass(), "severalTrainsInOneBlock");

        List<String> expectedOutputFileContent = Arrays.asList(RailroadsConstants.ItPossibleToMarshalTheCoaches,
                RailroadsConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void lastBlockWithout0_allowed() {
        Path directoryPath = getClassResourcePath(getClass(), "lastBlockWithout0");

        List<String> expectedOutputFileContent = Collections.singletonList(
                RailroadsConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalBlocks_inNotLastAndNotFirstError_processedToError() {
        Path directoryPath = getClassResourcePath(getClass(), "severalBlocks_inNotLastAndNotFirstError");

        int errorLineNumber = 5;
        String exceptionOnString = "s";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber,
                new TrainCoachesIncorrectFormatException(new Exception(generateForInputStringExceptionMessage(exceptionOnString))));
        List<String> expectedOutputFileContent = Arrays.asList(RailroadsConstants.ItPossibleToMarshalTheCoaches, StringConstants.EmptyString, errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void severalTrainsInOneBlock_inNotLastAndNotFirstError_processedToError() {
        Path directoryPath = getClassResourcePath(getClass(), "severalTrainsInOneBlock_inNotLastAndNotFirstError");

        int errorLineNumber = 3;
        String exceptionOnString = "s";
        String errorMessage = generateOutputFileErrorMessage(errorLineNumber,
                new TrainCoachesIncorrectFormatException(new Exception(
                        generateForInputStringExceptionMessage(
                                exceptionOnString))));
        List<String> expectedOutputFileContent = Arrays.asList(RailroadsConstants.ItPossibleToMarshalTheCoaches,
                errorMessage);

        processInputTest(directoryPath, expectedOutputFileContent);
    }
}
