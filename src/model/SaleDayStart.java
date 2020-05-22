package model;

import controller.Controller;
import controller.DataCreator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class SaleDayStart implements SaleDayLink {

    private SaleDayLink nextChain;

    GlobalVar var = GlobalVar.getInstance();
    DataCreator creator = new DataCreator();


    @Override
    public void setNextLink(SaleDayLink nextLink) {
        this.nextChain = nextLink;
    }

    @Override
    public void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int invIndex) {
        var.setSuccess(false);
        if(var.getRoundCounter() == 10){
            nextChain.sales(comp, invest, invIndex);
        }
        Random random = new Random();

        int invIn = invIndex;
        int compIn = random.nextInt(100);

        if((!invest.get(invIn).isCantBuy()) &&
                (invest.get(invIn).getBudget() >= comp.get(compIn).getPrice()) &&
                        (!comp.get(compIn).isAllSold())){

                operation(comp, invest, invIn, compIn);
        }else{
            int j = compIn + 1;
            if(compIn == 99){
                j = 0;
            }
            loop:
            while(j != (compIn)){

                if((!invest.get(invIn).isCantBuy()) &&
                        (invest.get(invIn).getBudget() >= comp.get(j).getPrice()) &&
                        (!comp.get(j).isAllSold())){
                    operation(comp, invest, invIn, j);
                    break loop;
                }
                if(j == 99){
                    j = -1;
                }
                j++;

            }
        }

            int count = invIn +1;
            if(invIn == 99){
                count = 0;
            }
            if(!var.isSuccess()){
                while(invest.get(count).isCantBuy()){


                    if(count == 99){
                        count = -1;
                    }
                    count++;

                }

                sales(comp,  invest, count);
            }


    }


    public void operation(ArrayList<Company> comp, ArrayList<Investor> invest, int invIn, int compIn){
        var.setRoundCounter(var.getRoundCounter() + 1);
        double oldBudget = invest.get(invIn).getBudget();
        double oldPrice = comp.get(compIn).getPrice();


        invest.get(invIn).setBudget(creator.round((invest.get(invIn).getBudget() - comp.get(compIn).getPrice()),2));

        if(var.getMaxBudget() == oldBudget){
            var.setMaxBudget(0);
            for(int i = 0; i < invest.size(); i++){
                if(var.getMaxBudget() < invest.get(i).getBudget()){
                    var.setMaxBudget(invest.get(i).getBudget());
                }
            }
        }

        invest.get(invIn).setSharesBought(invest.get(invIn).getSharesBought() + 1);

        comp.get(compIn).setSoldThisRound(true);
        comp.get(compIn).setSharesLeft(comp.get(compIn).getSharesLeft() -1);
        var.setTotalShares(var.getTotalShares() - 1);

        if(comp.get(compIn).getSharesLeft() == 0){
            comp.get(compIn).setAllSold(true);
        }



        comp.get(compIn).setPriceCounter(comp.get(compIn).getPriceCounter() +1);

        if(comp.get(compIn).getPriceCounter() == 10){
            comp.get(compIn).setPriceCounter(0);
            comp.get(compIn).setPrice(creator.round((comp.get(compIn).getPrice() * 2), 2));


            if(var.getMinPrice() == oldPrice){
                for(int i = 0; i < comp.size(); i++){
                    if(var.getMinPrice() > comp.get(i).getPrice()){
                        var.setMinPrice(comp.get(i).getPrice());
                    }
                }
            }
        }

        if(invest.get(invIn).getBudget() < var.getMinPrice()){
            invest.get(invIn).setCantBuy(true);
        }

        var.setSuccess(true);

    }
}
