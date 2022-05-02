package pers.rasskazov.huawei.testfoqacandidate.exceptions;

public final class DirectoryNotSetException extends RailroadsApplicationException {
    public DirectoryNotSetException() {
        super("Directory path not set in command-line arguments.");
    }
}
