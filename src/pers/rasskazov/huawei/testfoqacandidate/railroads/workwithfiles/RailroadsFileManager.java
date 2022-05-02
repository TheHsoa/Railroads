package pers.rasskazov.huawei.testfoqacandidate.railroads.workwithfiles;

import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.RailroadsConstants.InputFileName;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.RailroadsConstants.OutputFileName;
import static pers.rasskazov.huawei.testfoqacandidate.railroads.constants.StringConstants.EmptyString;

public final class RailroadsFileManager {
    private final File InputFile;
    private final File OutputFile;

    public RailroadsFileManager(String directoryPathString) throws DirectoryNotExistsException, OutputFileNotCreatedException,
            IncorrectPathForDirectoryException, PathNotForDirectoryException {
        try {
            Path directoryPath = Paths.get(directoryPathString);

            if (Files.notExists(directoryPath) || directoryPathString.equals(EmptyString)) {
                throw new DirectoryNotExistsException(directoryPath);
            }

            if (!Files.isDirectory(directoryPath)) {
                throw new PathNotForDirectoryException(directoryPath);
            }

            Path inputFilePath = directoryPath.resolve(InputFileName);
            InputFile = inputFilePath.toFile();

            Path outputFilePath = directoryPath.resolve(OutputFileName);
            OutputFile = outputFilePath.toFile();
            createOutputFileIfNotExists();
        } catch (InvalidPathException e) {
            throw new IncorrectPathForDirectoryException(directoryPathString);
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
}
