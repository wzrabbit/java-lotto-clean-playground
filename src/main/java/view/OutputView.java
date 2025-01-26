package view;

import model.LottoList;
import model.LottoPrizeConstants;
import model.LottoPrizeResult;

import java.util.List;

public class OutputView {
    public static void printLottoPurchases(LottoList lottoList, int manualLottoCount, int autoLottoCount) {
        System.out.println("\n수동으로 " + manualLottoCount + "개, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
        lottoList.getValue().forEach(lotto -> {
            System.out.println(lotto);
        });
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage + "\n");
    }

    public static void printLottoPrizeResult(LottoPrizeResult lottoPrizeResult) {
        System.out.println("당첨 통계\n---------");
        System.out.println("3개 일치 (" + LottoPrizeConstants.FIFTH_PRIZE_MONEY.getValue() + "원)- "
                + lottoPrizeResult.getFifthPrizeCount() + "개");
        System.out.println("4개 일치 (" + LottoPrizeConstants.FOURTH_PRIZE_MONEY.getValue() + "원)- "
                + lottoPrizeResult.getFourthPrizeCount() + "개");
        System.out.println("5개 일치 (" + LottoPrizeConstants.THIRD_PRIZE_MONEY.getValue() + "원)- "
                + lottoPrizeResult.getThirdPrizeCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + LottoPrizeConstants.SECOND_PRIZE_MONEY.getValue() + "원)- "
                + lottoPrizeResult.getSecondPrizeCount() + "개");
        System.out.println("6개 일치 (" + LottoPrizeConstants.FIRST_PRIZE_MONEY.getValue() + "원)- "
                + lottoPrizeResult.getFirstPrizeCount() + "개");
        System.out.println("총 수익률은 " + lottoPrizeResult.getProfitRate() + "입니다.");
    }
}
