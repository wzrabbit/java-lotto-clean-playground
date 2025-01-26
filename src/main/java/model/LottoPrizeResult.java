package model;

import java.util.ArrayList;
import java.util.List;

public class LottoPrizeResult {
    private final List<Integer> prizeResult;

    public LottoPrizeResult(List<Integer> prizeResult) {
        validateLottoPrizeResult(prizeResult);
        this.prizeResult = new ArrayList<>(prizeResult);
    }

    private void validateLottoPrizeResult(List<Integer> prizeResult) {
        if (prizeResult.size() != LottoPrizeConstants.PRIZE_TYPE_COUNT.getValue()) {
            throw new IllegalArgumentException("당첨 결과는 " + LottoPrizeConstants.PRIZE_TYPE_COUNT.getValue() +
                    "개의 정수로 구성되어야 합니다.");
        }

        prizeResult.forEach(prizeCount -> {
            if (prizeCount < 0) {
                throw new IllegalArgumentException("당첨 횟수는 음수가 될 수 없습니다.");
            }
        });
    }

    public int getFirstPrizeCount() {
        return prizeResult.get(0);
    }

    public int getSecondPrizeCount() {
        return prizeResult.get(1);
    }

    public int getThirdPrizeCount() {
        return prizeResult.get(2);
    }

    public int getFourthPrizeCount() {
        return prizeResult.get(3);
    }

    public int getFifthPrizeCount() {
        return prizeResult.get(4);
    }

    public double getProfitRate() {
        int purchasePrice = prizeResult.stream().mapToInt(Integer::intValue).sum() * LottoConstants.PRICE.getValue();

        if (purchasePrice == 0) {
            return 0;
        }

        int totalPrizeMoney = getFirstPrizeCount() * LottoPrizeConstants.FIRST_PRIZE_MONEY.getValue()
                + getSecondPrizeCount() * LottoPrizeConstants.SECOND_PRIZE_MONEY.getValue()
                + getThirdPrizeCount() * LottoPrizeConstants.THIRD_PRIZE_MONEY.getValue()
                + getFourthPrizeCount() * LottoPrizeConstants.FOURTH_PRIZE_MONEY.getValue()
                + getFifthPrizeCount() * LottoPrizeConstants.FIFTH_PRIZE_MONEY.getValue();

        return (double) totalPrizeMoney / purchasePrice;
    }
}
