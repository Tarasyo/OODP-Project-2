package model;

import java.util.ArrayList;

public class SalesDayTen implements SaleDayLink {

    private SaleDayLink nextChain;

    @Override
    public void setNextLink(SaleDayLink nextLink) {
        this.nextChain = nextLink;
    }

    @Override
    public void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int i, int invIn) {

    }
}
