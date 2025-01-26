package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoList {
    List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<Lotto>(lottoList);
    }

    public List<Lotto> getValue() {
        return lottoList;
    }

    public int size() {
        return lottoList.size();
    }
}
