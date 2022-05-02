package pers.rasskazov.huawei.testfoqacandidate.exceptions;

public final class IncorrectNumberOfTrainCoachesException extends RailroadsApplicationException {

    public IncorrectNumberOfTrainCoachesException(int numberOfCoachesInBlock, int actualNumberOfCoaches) {
        super("Number of train coaches does not match to number of coaches in block. Expected number of coaches in block: " + numberOfCoachesInBlock + ". Actual number of coaches: " + actualNumberOfCoaches + ".");
    }
}
