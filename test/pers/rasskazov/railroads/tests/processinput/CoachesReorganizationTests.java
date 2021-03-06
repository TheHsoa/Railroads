package pers.rasskazov.railroads.tests.processinput;

import org.junit.jupiter.api.Test;
import pers.rasskazov.railroads.constants.RailroadsConstants;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static pers.rasskazov.railroads.testsupport.helpers.ResourcesHelper.getClassResourcePath;

final class CoachesReorganizationTests extends BaseProcessInputTests {
    @Test
    void reverseOrder_yes() {
        Path directoryPath = getClassResourcePath(getClass(), "reverseOrder");

        List<String> expectedOutputFileContent = Collections.singletonList(RailroadsConstants.ItPossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }

    @Test
    void coachBlockedAtStation_no() {
        Path directoryPath = getClassResourcePath(getClass(), "coachBlockedAtStation");

        List<String> expectedOutputFileContent = Collections.singletonList(RailroadsConstants.ItImpossibleToMarshalTheCoaches);

        processInputTest(directoryPath, expectedOutputFileContent);
    }
}
