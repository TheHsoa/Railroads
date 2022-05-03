package pers.rasskazov.railroads.testsupport.helpers;

import pers.rasskazov.railroads.constants.RailroadsConstants;
import pers.rasskazov.railroads.testsupport.StringGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public final class FileHelper {
    private FileHelper() {
        // No OP
    }

    public static Path generateInputFileWithOneBlockForTest(int numberOfTrainCoaches) throws IOException {

        Path inputFileDirectoryPath = Paths.get("./tests/generated")
                .resolve(StringGenerator.generateRandomLatinAlphaNumericString(30));
        File inputFileDirectory = inputFileDirectoryPath.toFile();

        assertTrue(inputFileDirectory.mkdirs(), "Directory already exists or not created: " + inputFileDirectoryPath);

        Path inputFilePath = inputFileDirectoryPath.resolve(RailroadsConstants.InputFileName);
        Files.createFile(inputFilePath);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(numberOfTrainCoaches);
        stringBuilder.append(System.lineSeparator());

        IntStream.range(1, 1001).forEach(x -> {
            stringBuilder.append(x);
            stringBuilder.append(RailroadsConstants.TrainCoachesDelimiter);
        });
        stringBuilder.append(System.lineSeparator());

        stringBuilder.append(RailroadsConstants.BlockLastLine);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(RailroadsConstants.BlockLastLine);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFilePath.toFile()))) {
            writer.write(stringBuilder.toString());
        }

        return inputFileDirectoryPath;
    }
}
