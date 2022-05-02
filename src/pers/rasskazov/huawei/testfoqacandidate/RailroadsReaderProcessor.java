package pers.rasskazov.huawei.testfoqacandidate;

import pers.rasskazov.huawei.testfoqacandidate.checkers.TrainCoachesReorganizationChecker;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.IncorrectNumberOfTrainCoachesException;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.NumberOfTrainCoachesIncorrectFormatException;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.RailroadsApplicationException;
import pers.rasskazov.huawei.testfoqacandidate.exceptions.TrainCoachesIncorrectFormatException;
import pers.rasskazov.huawei.testfoqacandidate.helpers.IntegerHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import static pers.rasskazov.huawei.testfoqacandidate.constants.RailroadsConstants.*;

public final class RailroadsReaderProcessor {
    private RailroadsReaderProcessor() {
        // No OP
    }

    private static String getErrorForLine(int lineNumber, RailroadsApplicationException exception) {
        return "Error at line " + lineNumber + ": " + exception.getMessageWithCause();
    }

    private static Stack<Integer> parseTrainStringToIntegerStack(String trainString) throws TrainCoachesIncorrectFormatException {
        try {
            return Arrays.stream(trainString.split(TrainCoachesDelimiter)).map(Integer::parseUnsignedInt).collect(Collectors.toCollection(Stack::new));
        } catch (NumberFormatException e) {
            throw new TrainCoachesIncorrectFormatException(e);
        }
    }

    public static String processTrainBlocks(BufferedReader trainsBlocksReader) throws IOException {
        StringBuilder result = new StringBuilder();
        String line = trainsBlocksReader.readLine();
        int lineNumber = 1;
        while (line != null) {
            if (BlockLastLine.equals(line)) {
                break;
            }
            try {
                Integer numberOfTrainCoaches = IntegerHelper.tryParse(line);
                if (numberOfTrainCoaches == null || numberOfTrainCoaches < 1 || numberOfTrainCoaches > 1000) {
                    throw new NumberOfTrainCoachesIncorrectFormatException();
                }

                String blockLine = trainsBlocksReader.readLine();
                lineNumber++;
                while (blockLine != null && !BlockLastLine.equals(blockLine)) {
                    try {
                        if (lineNumber != FirstCoachesLine) {
                            result.append(System.lineSeparator());
                        }
                        Stack<Integer> reorganizedTrainCoaches = parseTrainStringToIntegerStack(blockLine);
                        if (reorganizedTrainCoaches.size() != numberOfTrainCoaches) {
                            throw new IncorrectNumberOfTrainCoachesException(numberOfTrainCoaches, reorganizedTrainCoaches.size());
                        }
                        if (TrainCoachesReorganizationChecker.checkCanTrainReorganized(reorganizedTrainCoaches)) {
                            result.append(ItPossibleToMarshalTheCoaches);
                        } else {
                            result.append(ItImpossibleToMarshalTheCoaches);
                        }
                    } catch (TrainCoachesIncorrectFormatException | IncorrectNumberOfTrainCoachesException e) {
                        result.append(getErrorForLine(lineNumber, e));
                        blockLine = null;
                        break;
                    }

                    blockLine = trainsBlocksReader.readLine();
                    lineNumber++;
                }
                if (blockLine == null) {
                    break;
                }
            } catch (NumberOfTrainCoachesIncorrectFormatException e) {
                result.append(getErrorForLine(lineNumber, e));
                break;
            }
            line = trainsBlocksReader.readLine();
            if (!BlockLastLine.equals(line)) {
                result.append(System.lineSeparator());
            }
            lineNumber++;
        }

        return result.toString();
    }
}
