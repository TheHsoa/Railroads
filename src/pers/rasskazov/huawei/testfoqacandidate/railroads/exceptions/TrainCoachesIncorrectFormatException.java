package pers.rasskazov.huawei.testfoqacandidate.railroads.exceptions;

public final class TrainCoachesIncorrectFormatException extends RailroadsApplicationException {

    private static final String TrainCoachesIncorrectFormat =
            "Incorrect format for train coaches. Value must be a sequence of positive integer numbers separated by spaces.";

    public TrainCoachesIncorrectFormatException(Throwable cause) {
        super(TrainCoachesIncorrectFormat, cause);
    }

}
