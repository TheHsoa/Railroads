package pers.rasskazov.railroads;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Railroads {
    public static void main(String[] arguments) {
        try {
            String directoryPathString = arguments[0];
            Path directoryPath = Paths.get(directoryPathString);
            Path inputPath = directoryPath.resolve("input.txt");

            String result;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader((inputPath.toFile())))) {
                result = processTrainBlocks(bufferedReader);
            }

            File outputFile = directoryPath.resolve("output.txt").toFile();
            if (!outputFile.exists() && !outputFile.createNewFile()) {
                throw new Exception("Output file for path not created: " + outputFile + ".");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(result);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static boolean isContains(Integer[] array, Integer value) {
        for (Integer element : array) {
            if (value.equals(element)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkCanTrainReorganized(Integer[] reorganizedCoaches) {
        int trainLength = reorganizedCoaches.length;
        Integer[] stationTrainCoaches = new Integer[trainLength];
        int headStationCoachIndex = -1;
        int coachesOnB = trainLength;

        for (int nextCoachForA = trainLength; nextCoachForA >= 1; nextCoachForA--) {
            if (headStationCoachIndex > -1 && isContains(stationTrainCoaches, nextCoachForA)) {
                if (stationTrainCoaches[headStationCoachIndex] == nextCoachForA) {
                    headStationCoachIndex--;
                    continue;
                }
                return false;
            }

            boolean isNextCoachForAFound = false;
            while (coachesOnB > 0) {
                int nextCoachOnB = reorganizedCoaches[--coachesOnB];
                if (nextCoachOnB != nextCoachForA) {
                    stationTrainCoaches[++headStationCoachIndex] = nextCoachOnB;
                } else {
                    isNextCoachForAFound = true;
                    break;
                }
            }

            if (!isNextCoachForAFound) {
                return false;
            }
        }

        return true;
    }

    private static String processTrainBlocks(BufferedReader trainsBlocksReader) throws IOException {
        String blockLastLine = "0";

        StringBuilder result = new StringBuilder();
        String line = trainsBlocksReader.readLine();
        int lineNumber = 1;
        while (line != null) {
            if (blockLastLine.equals(line)) {
                break;
            }
            try {
                int numberOfTrainCoaches = Integer.parseInt(line);
                if (numberOfTrainCoaches < 1 || numberOfTrainCoaches > 1000) {
                    throw new Exception("Incorrect format for number of train coaches. Value must be positive integer number less than 1000.");
                }

                String blockLine = trainsBlocksReader.readLine();
                lineNumber++;
                while (blockLine != null && !blockLastLine.equals(blockLine)) {
                    if (lineNumber != 2) {
                        result.append(System.lineSeparator());
                    }

                    String[] coachesStrings = blockLine.split(" ");
                    Integer[] reorganizedCoaches = new Integer[coachesStrings.length];
                    for (int i = 0; i < coachesStrings.length; i++) {
                        reorganizedCoaches[i] = Integer.parseInt(coachesStrings[i]);
                    }

                    if (reorganizedCoaches.length != numberOfTrainCoaches) {
                        throw new Exception("Coaches count does not match to number of coaches in block.");
                    }
                    if (checkCanTrainReorganized(reorganizedCoaches)) {
                        result.append("Yes");
                    } else {
                        result.append("No");
                    }

                    blockLine = trainsBlocksReader.readLine();
                    lineNumber++;
                }

                if (blockLine == null) {
                    break;
                }
            } catch (Exception e) {
                result.append("Error at line ").append(lineNumber).append(": ").append(e.getMessage());
                break;
            }
            line = trainsBlocksReader.readLine();
            if (!blockLastLine.equals(line)) {
                result.append(System.lineSeparator());
            }
            lineNumber++;
        }

        return result.toString();
    }
}
