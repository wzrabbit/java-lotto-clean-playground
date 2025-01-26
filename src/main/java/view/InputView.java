package view;

import model.BonusNumber;
import model.Lotto;
import model.LottoPurchasePrice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static LottoPurchasePrice inputLottoPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(scanner.nextInt());
        scanner.nextLine();

        return lottoPurchasePrice;
    }

    public static Lotto inputWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public static BonusNumber inputBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return new BonusNumber(scanner.nextInt());
    }
}
