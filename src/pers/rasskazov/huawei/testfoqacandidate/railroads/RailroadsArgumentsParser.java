package pers.rasskazov.huawei.testfoqacandidate.railroads;

import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.DirectoryNotSetException;
import pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions.EmptyArgumentsException;

final class RailroadsArgumentsParser {
    private RailroadsArgumentsParser() {
        // No OP
    }

    static String parse(String[] arguments) throws EmptyArgumentsException, DirectoryNotSetException {
        if (arguments == null || arguments.length == 0) {
            throw new EmptyArgumentsException();
        }
        String directoryPathString = arguments[0];
        if (directoryPathString == null) {
            throw new DirectoryNotSetException();
        }

        return directoryPathString;
    }
}
