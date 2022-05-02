package pers.rasskazov.huawei.testfoqacandidate.exceptions;

import java.nio.file.Path;

public final class DirectoryNotExistsException extends RailroadsApplicationException {
    public DirectoryNotExistsException(Path filePath) {
        super("Directory for path not exists: " + filePath.toString() + ".");
    }
}
