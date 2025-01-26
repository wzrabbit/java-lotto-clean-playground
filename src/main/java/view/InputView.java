package view;

import model.LottoPurchasePrice;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static LottoPurchasePrice inputLottoPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoPurchasePrice(scanner.nextInt());
    }
}
