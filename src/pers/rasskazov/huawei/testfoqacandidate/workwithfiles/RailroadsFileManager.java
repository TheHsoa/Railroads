package pers.rasskazov.huawei.testfoqacandidate.workwithfiles;

import pers.rasskazov.huawei.testfoqacandidate.exceptions.DirectoryNotExistsException;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.InputFileReadException;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.OutputFileNotCreatedException;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.OutputFileWriteException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class RailroadsFileManager {
    private final File InputFile;
    private final File OutputFile;

    public RailroadsFileManager(String directoryPathString) throws DirectoryNotExistsException, OutputFileNotCreatedException {
        Path directoryPath = Paths.get(directoryPathString);
        if (Files.notExists(directoryPath)) {
            throw new DirectoryNotExistsException(directoryPath);
        }

        Path inputFilePath = directoryPath.resolve("input.txt");
        InputFile = inputFilePath.toFile();

        Path outputFilePath = directoryPath.resolve("output.txt");
        OutputFile = outputFilePath.toFile();
        createOutputFileIfNotExists();
    }

    private void createOutputFileIfNotExists() throws OutputFileNotCreatedException {
        try {
            if (!OutputFile.exists()) {
                if (!OutputFile.createNewFile()) {
                    throw new OutputFileNotCreatedException(OutputFile.toPath());
                }
            }
        } catch (IOException e) {
            throw new OutputFileNotCreatedException(OutputFile.toPath(), e);
        }
    }

    public BufferedReader getInputFileReader() throws InputFileReadException {
        try {
            return new BufferedReader(new FileReader(InputFile));
        } catch (IOException e) {
            throw new InputFileReadException(InputFile.toPath(), e);
        }
    }

    public void writeToOutputFile(String value) throws OutputFileWriteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OutputFile))) {
            writer.write(value);
        } catch (IOException e) {
            throw new OutputFileWriteException(InputFile.toPath(), e);
        }
    }
}
