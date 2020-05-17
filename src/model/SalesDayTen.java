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


        for(int j = 0; j < comp.size(); j++){
            if(comp.get(j).getSoldThisRound() == false){
                comp.get(j).setPrice(comp.get(j).getPrice() * 0.98);
            }else{
                comp.get(j).setSoldThisRound(false);
            }
        }


    }
}
