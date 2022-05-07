package pers.rasskazov.railroads.testsupport.validation;

import pers.rasskazov.railroads.testsupport.StringConstants;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public final class OutputFileValidator {
    private OutputFileValidator() {
        // No OP
    }

    public static void validateOutputFile(Path folderPath, List<String> expectedOutputFileContents) {
        Path outputFilePath = folderPath.resolve(StringConstants.OutputFileName);

        assertTrue(outputFilePath.toFile().exists(), "Output file: " + outputFilePath + " not exists.");

        List<String> outputFileContent = assertDoesNotThrow(() -> Files.readAllLines(outputFilePath),
                "Can't read output file.");
        assertEquals(expectedOutputFileContents, outputFileContent, "Output file contains unexpected content");
    }
}
