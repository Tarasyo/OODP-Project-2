package model;

import controller.Controller;
import controller.DataCreator;

import java.util.ArrayList;
import java.util.Random;

public class SaleDayStart implements SaleDayLink {

    private SaleDayLink nextChain;
    boolean success = false;
    GlobalVar var = GlobalVar.getInstance();

    @Override
    public void setNextLink(SaleDayLink nextLink) {
        this.nextChain = nextLink;
    }

    @Override
    public void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int i, int invIndex) {

        if(i == 10){
            nextChain.sales(comp, invest, i, invIndex);
        }
        Random random = new Random();

        int invIn = invIndex;
        int compIn = random.nextInt(99);

        if((invest.get(invIn).isCantBuy() != true) &&
                (invest.get(invIn).getBudget() >= comp.get(compIn).getPrice() &&
                        comp.get(compIn).isAllSold() != true )){

                operation(comp, invest, invIn, compIn);
        }else{
            for(int j = compIn +1; j == compIn; j++){
                if(j > 99){
                    j = 0;
                }

                if((invest.get(invIn).isCantBuy() != true) &&
                        (invest.get(invIn).getBudget() >= comp.get(j).getPrice() &&
                                comp.get(j).isAllSold() != true )){
                    operation(comp, invest, invIn, j);
                    break;
                }

            }
        }
            if(success == false){
                sales(comp,  invest, i, (invIndex + 1));
            }


    }


    public void operation(ArrayList<Company> comp, ArrayList<Investor> invest, int invIn, int compIn){

        invest.get(invIn).setBudget(invest.get(invIn).getBudget() - comp.get(compIn).getPrice());
        if(var.getUuidOfMaxBudget() == invest.get(invIn).getId()){
            for(int i = 0; i < invest.size(); i++){
                if(var.getMaxBudget() < invest.get(i).getBudget()){
                    var.setMaxBudget(invest.get(i).getBudget());
                    var.setUuidOfMaxBudget(invest.get(i).getId());
                }
            }
        }

        invest.get(invIn).setSharesBought(invest.get(invIn).getSharesBought() + 1);

        comp.get(compIn).setSoldThisRound(true);
        comp.get(compIn).setSharesLeft(comp.get(compIn).getSharesLeft() -1);
        var.setTotalShares(var.getTotalShares() - 1);
        System.out.println(var.getTotalShares());

        if(comp.get(compIn).getSharesLeft() == 0){
            comp.get(compIn).setAllSold(true);
        }



        comp.get(compIn).setPriceCounter(comp.get(compIn).getPriceCounter() +1);

        if(comp.get(compIn).getPriceCounter() == 10){
            comp.get(compIn).setPriceCounter(0);
            comp.get(compIn).setPrice(comp.get(compIn).getPrice() * 2);
            if(var.getUuidOfMinPrice() == comp.get(compIn).getId()){
                for(int i = 0; i < comp.size(); i++){
                    if(var.getMinPrice() > comp.get(i).getPrice()){
                        var.setMinPrice(comp.get(i).getPrice());
                        var.setUuidOfMinPrice(comp.get(i).getId());
                    }
                }
            }
        }
        success = true;

    }
}
