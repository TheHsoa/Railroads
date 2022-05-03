package pers.rasskazov.railroads;

import pers.rasskazov.railroads.arguments.RailroadsArgumentsParser;
import pers.rasskazov.railroads.exceptions.RailroadsApplicationException;
import pers.rasskazov.railroads.helpers.ExceptionHelper;
import pers.rasskazov.railroads.processing.RailroadsReaderProcessor;
import pers.rasskazov.railroads.workwithfiles.RailroadsFileManager;

import java.io.BufferedReader;
import java.io.IOException;

public final class Railroads {
    public static void main(String[] arguments) {
        try {
            String directoryPathString = RailroadsArgumentsParser.parse(arguments);
            RailroadsFileManager fileManager = new RailroadsFileManager(directoryPathString);
            try (BufferedReader bufferedReader = fileManager.getInputFileReader()) {
                String result = RailroadsReaderProcessor.processTrainBlocks(bufferedReader);
                fileManager.writeToOutputFile(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (RailroadsApplicationException e) {
            ExceptionHelper.logExceptionMessageToConsole(e);
        }
    }
}
