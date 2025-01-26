package model;

public enum LottoPrizeConstants {
    FIRST_PRIZE_MONEY(2_000_000_000),
    SECOND_PRIZE_MONEY(30_000_000),
    THIRD_PRIZE_MONEY(1_500_000),
    FOURTH_PRIZE_MONEY(50_000),
    FIFTH_PRIZE_MONEY(5_000),
    PRIZE_TYPE_COUNT(6);

    private final int value;

    LottoPrizeConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
