package model;

import java.util.ArrayList;

public class SaleDayStart implements SaleDayLink {

    private SaleDayLink nextChain;

    @Override
    public void setNextLInk(SaleDayLink nextLink) {
        this.nextChain = nextLink;
    }

    @Override
    public void companies(ArrayList<Company> comp) {







    }
}
