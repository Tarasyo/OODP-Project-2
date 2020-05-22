package model;

import controller.DataCreator;

import java.util.ArrayList;

public class SalesDayTen implements SaleDayLink {

    private SaleDayLink nextChain;
    GlobalVar var = GlobalVar.getInstance();
    DataCreator creator = new DataCreator();

    @Override
    public void setNextLink(SaleDayLink nextLink) {

        this.nextChain = nextLink;
    }

    //Second Chain starts when we have 10 successful sold shares
    @Override
    public void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int invIn) {

        //it will go trough all company list and if SoldThisRound is false reduce price by 2%
        for(int j = 0; j < comp.size(); j++){
            if(!comp.get(j).getSoldThisRound()){
                comp.get(j).setPrice(creator.round((comp.get(j).getPrice() * 0.98), 2));
            }else{
                //All that have true will set to false to start the new round with clean
                comp.get(j).setSoldThisRound(false);
            }
        }
        //Of course need now to check the global min Price
        for(int n = 0; n < comp.size(); n++){
            if(var.getMinPrice() > comp.get(n).getPrice()){
                var.setMinPrice(comp.get(n).getPrice());
            }
        }
        //And check if after this price reduce maybe some investor can now buy
        for(int j = 0; j < invest.size(); j++){
            if(invest.get(j).getBudget() >= var.getMinPrice()){
                invest.get(j).setCantBuy(false);
            }
        }


    }
}
