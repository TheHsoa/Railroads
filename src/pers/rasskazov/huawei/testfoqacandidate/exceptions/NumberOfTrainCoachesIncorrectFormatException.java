package pers.rasskazov.huawei.testfoqacandidate.exceptions;

public final class NumberOfTrainCoachesIncorrectFormatException extends RailroadsApplicationException {

    private static final String NumberOfTrainCoachesIncorrectFormat = "Incorrect format for number of train coaches. Value must be positive integer number less than 1000.";

    public NumberOfTrainCoachesIncorrectFormatException() {
        super(NumberOfTrainCoachesIncorrectFormat);
    }

}
