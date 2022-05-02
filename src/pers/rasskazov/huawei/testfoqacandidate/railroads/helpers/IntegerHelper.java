package pers.rasskazov.huawei.testfoqacandidate.railroads.helpers;

public final class IntegerHelper {
    private IntegerHelper() {
        // No OP
    }

    public static Integer tryParse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
