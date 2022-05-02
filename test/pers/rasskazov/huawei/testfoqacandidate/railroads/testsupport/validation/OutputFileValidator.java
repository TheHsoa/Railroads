package pers.rasskazov.huawei.testfoqacandidate.railroads.testsupport.validation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.RailroadsConstants.OutputFileName;

public final class OutputFileValidator {
    private OutputFileValidator() {
        // No OP
    }

    public static void validateOutputFile(Path folderPath, List<String> expectedOutputFileContents) {
        Path outputFilePath = folderPath.resolve(OutputFileName);

        assertTrue(outputFilePath.toFile().exists(), "Output file: " + outputFilePath + " not exists.");

        List<String> outputFileContent = assertDoesNotThrow(() -> Files.readAllLines(outputFilePath),
                "Can't read output file.");
        assertEquals(expectedOutputFileContents, outputFileContent, "Output file contains unexpected content");
    }
}
