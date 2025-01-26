package view;

import model.LottoList;

import java.util.List;

public class OutputView {
    public static void printLottoPurchases(LottoList lottoList) {
        System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");
        lottoList.getValue().forEach(lotto -> {
            System.out.println(lotto);
        });
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage + "\n");
    }
}
