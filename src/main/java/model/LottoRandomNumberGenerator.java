package model;

import java.util.Random;

public class LottoRandomNumberGenerator implements RandomNumberGenerator {
    Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(LottoConstants.MIN_NUMBER.getValue(), LottoConstants.MAX_NUMBER.getValue() + 1);
    }
}
