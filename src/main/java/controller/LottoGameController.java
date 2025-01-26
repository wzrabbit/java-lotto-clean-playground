package controller;

import model.*;
import view.InputView;
import view.OutputView;

import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class LottoGameController {
    private final LottoRandomNumberGenerator lottoRandomNumberGenerator = new LottoRandomNumberGenerator();
    private final LottoGenerator lottoGenerator = new LottoGenerator(lottoRandomNumberGenerator);
    private LottoList lottoList;
    private WinningLottoInfo winningLottoInfo;

    public void run() {
        inputLottoPurchasePrice();
        inputWinningLottoInfo();
    }

    private void inputLottoPurchasePrice() {
        try {
            final LottoPurchasePrice lottoPurchasePrice = InputView.inputLottoPurchasePrice();
            makeLottoList(lottoPurchasePrice.getLottoCount());
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
        }
    }

    private void makeLottoList(int lottoCount) {
        lottoList = new LottoList(IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoGenerator.generate())
                .collect(Collectors.toList()));

        OutputView.printLottoPurchases(lottoList);
    }

    private void inputWinningLottoInfo() {
        try {
            final Lotto winningLotto = InputView.inputWinningLotto();
            final BonusNumber bonusNumber = InputView.inputBonusNumber();
            this.winningLottoInfo = new WinningLottoInfo(winningLotto, bonusNumber);
            printLottoPrizeResult();
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
        }
    }

    private void printLottoPrizeResult() {
        try {
            OutputView.printLottoPrizeResult(lottoList.getLottoResultByWinningLottoInfo(winningLottoInfo));
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
        }
    }
}
