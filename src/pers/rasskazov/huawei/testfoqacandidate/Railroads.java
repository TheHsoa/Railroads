package pers.rasskazov.huawei.testfoqacandidate;

import pers.rasskazov.huawei.testfoqacandidate.exceptions.RailroadsApplicationException;
import pers.rasskazov.huawei.testfoqacandidate.helpers.ExceptionHelper;
import pers.rasskazov.huawei.testfoqacandidate.workwithfiles.RailroadsFileManager;

import java.io.BufferedReader;
import java.io.IOException;

final class Railroads {

    public static void main(String[] arguments) {
        try {
            String directoryPathString = RailroadsArgumentsParser.parse(arguments);
            RailroadsFileManager fileManager = new RailroadsFileManager(directoryPathString);
            try (BufferedReader bufferedReader = fileManager.getInputFileReader()) {
                String result = RailroadsReaderProcessor.processTrainBlocks(bufferedReader);
                fileManager.writeToOutputFile(result);
            }
        } catch (RailroadsApplicationException | IOException e) {
            ExceptionHelper.logExceptionMessageToConsole(e);
        }
    }


}
