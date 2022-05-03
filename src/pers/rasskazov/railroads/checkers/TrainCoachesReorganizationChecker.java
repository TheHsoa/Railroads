package pers.rasskazov.railroads.checkers;

import java.util.Stack;

public final class TrainCoachesReorganizationChecker {
    private TrainCoachesReorganizationChecker() {
        // No OP
    }

    public static boolean checkCanTrainReorganized(Stack<Integer> reorganizedTrainCoaches) {
        Stack<Integer> stationTrainCoaches = new Stack<>();
        int trainLength = reorganizedTrainCoaches.size();

        for (int nextTrainCoach = trainLength; nextTrainCoach >= 1; nextTrainCoach--) {
            if (stationTrainCoaches.contains(nextTrainCoach)) {
                if (stationTrainCoaches.peek() == nextTrainCoach) {
                    stationTrainCoaches.pop();
                    continue;
                }
                return false;
            }
            if (!tryMoveTrainCoachesToStationBeforeFindNextCoach(reorganizedTrainCoaches, stationTrainCoaches, nextTrainCoach)) {
                return false;
            }
        }

        return true;
    }

    private static boolean tryMoveTrainCoachesToStationBeforeFindNextCoach(Stack<Integer> trainCoaches, Stack<Integer> stationTrainCoaches,
            int nextSearchedTrainCoach) {
        while (!trainCoaches.empty()) {
            int nextTrainCoach = trainCoaches.pop();
            if (nextTrainCoach != nextSearchedTrainCoach) {
                stationTrainCoaches.add(nextTrainCoach);
            } else {
                return true;
            }
        }
        return false;
    }
}
