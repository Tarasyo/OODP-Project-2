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

    @Override
    public void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int invIn) {


        for(int j = 0; j < comp.size(); j++){
            if(!comp.get(j).getSoldThisRound()){
                comp.get(j).setPrice(creator.round((comp.get(j).getPrice() * 0.98), 2));
            }else{
                comp.get(j).setSoldThisRound(false);
            }
        }

        for(int n = 0; n < comp.size(); n++){
            if(var.getMinPrice() > comp.get(n).getPrice()){
                var.setMinPrice(comp.get(n).getPrice());
            }
        }

        for(int j = 0; j < invest.size(); j++){
            if(invest.get(j).getBudget() >= var.getMinPrice()){
                invest.get(j).setCantBuy(false);
            }
        }


    }
}
