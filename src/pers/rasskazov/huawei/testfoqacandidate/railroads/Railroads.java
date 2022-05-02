package pers.rasskazov.huawei.testfoqacandidate.railroads;

import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.RailroadsApplicationException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.helpers.ExceptionHelper;
import pers.rasskazov.huawei.testfoqacandidate.railroads.workwithfiles.RailroadsFileManager;

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
