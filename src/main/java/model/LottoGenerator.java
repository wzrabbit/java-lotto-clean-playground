package model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Lotto generate() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LottoConstants.NUMBER_COUNT.getValue()) {
            int candidateLottoNumber = randomNumberGenerator.generate();

            if (!lottoNumbers.contains(candidateLottoNumber)) {
                lottoNumbers.add(candidateLottoNumber);
            }
        }

        return new Lotto(lottoNumbers);
    }
}

