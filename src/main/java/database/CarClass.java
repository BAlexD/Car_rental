package database;

public enum CarClass {
    ECONOMY,
    COMFORT,
    BUSINESS;

    public static CarClass toEnum(int var) {
        return CarClass.values()[var];
    }

    public static int toInt(CarClass var) {
        return var.ordinal();
    }
}
