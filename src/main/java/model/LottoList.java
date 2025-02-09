package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoList {
    List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public List<Lotto> getValue() {
        return lottoList;
    }

    public int size() {
        return lottoList.size();
    }

    public LottoPrizeResult getLottoResultByWinningLottoInfo(WinningLottoInfo winningLottoInfo) {
        List<Integer> lottoPrizesCount = new ArrayList<>();

        for (int i = 1; i <= LottoPrizeConstants.PRIZE_TYPE_COUNT.getValue(); i++) {
            lottoPrizesCount.add(0);
        }

        lottoList.forEach(lotto -> {
            int lottoPrizeIndex = getLottoPrizeIndex(lotto, winningLottoInfo);
            lottoPrizesCount.set(lottoPrizeIndex, lottoPrizesCount.get(lottoPrizeIndex) + 1);
        });


        return new LottoPrizeResult(lottoPrizesCount);
    }

    private int getLottoPrizeIndex(Lotto lotto, WinningLottoInfo winningLottoInfo) {
        Set<Integer> lottoNumbers = new HashSet<>(lotto.getValue());

        int matchCount = (int) winningLottoInfo.getLottoValue().stream().filter(lottoNumbers::contains).count();
        boolean isBonusNumberMatched = lottoNumbers.contains(winningLottoInfo.getBonusNumberValue());

        if (matchCount == 6) {
            return 0;
        }

        if (matchCount == 5 && isBonusNumberMatched) {
            return 1;
        }

        if (matchCount < 3) {
            return 5;
        }

        return 7 - matchCount;
    }
}
