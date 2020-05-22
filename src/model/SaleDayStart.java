package model;

import controller.Controller;
import controller.DataCreator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;



//To run all operations on selling day was used Chain Pattern

public class SaleDayStart implements SaleDayLink {

    private SaleDayLink nextChain;

    //GlobalVariable to be able change than from here
    GlobalVar var = GlobalVar.getInstance();
    DataCreator creator = new DataCreator();


    @Override
    public void setNextLink(SaleDayLink nextLink) {
        this.nextChain = nextLink;
    }

    //In fir chain will be generated all main byes of shares
    //Method takes two Arrays Lists that holds all companies and Investors and integer that will use for index position of investor
    @Override
    public void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int invIndex) {
        var.setSuccess(false);
        //In next Chain will be reduced share price of companies that did't sale any shares in last 10 round of selling
        if(var.getRoundCounter() == 10){
            nextChain.sales(comp, invest, invIndex);
        }
        Random random = new Random();

        int invIn = invIndex;
        //generates random index for company
        int compIn = random.nextInt(100);

        //Check all conditions if investor still able to buy something
        //if he has money to buy shears with price of this company
        //and if company still has shares left
        if((!invest.get(invIn).isCantBuy()) &&
                (invest.get(invIn).getBudget() >= comp.get(compIn).getPrice()) &&
                        (!comp.get(compIn).isAllSold())){
                //if all conditions is good that start transaction
                //call method in which pass 2 arrayLists and indexes of the current investor and company
                operation(comp, invest, invIn, compIn);
        }else{
            //If Investor could'nt buy from that company I did very tricky while loop to do more random buying of shears
            //which will start in one position after the previous
            //and will stop on old position if no company will be found to buy some shares
            int j = compIn + 1;
            //not ot break the index I need to check if it is already on position 99 I need start from 0
            if(compIn == 99){
                j = 0;
            }
            loop:
            while(j != (compIn)){
                //condition of the if statement the same as before to buy shares
                if((!invest.get(invIn).isCantBuy()) &&
                        (invest.get(invIn).getBudget() >= comp.get(j).getPrice()) &&
                        (!comp.get(j).isAllSold())){
                    operation(comp, invest, invIn, j);
                    //and I will break this loop if I did transaction to go start from beginning
                    break loop;
                }
                if(j == 99){
                    j = -1;
                }
                j++;

            }
        }
            //In this part if transaction wasn't made before this I check on success variable
            //I run while loop with from next investor on the list and check if he still able to buy some shears
            //If yes creates an recursion by invoking sales method again but with new position that will give investor that able to buy
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

    //This method will do the transaction and change all data in investor and company that effects after all operations
    public void operation(ArrayList<Company> comp, ArrayList<Investor> invest, int invIn, int compIn){
        //first its add + 1 to round to know when will be 10 successful transactions
        var.setRoundCounter(var.getRoundCounter() + 1);
        //To keep track  of old price and budget
        double oldBudget = invest.get(invIn).getBudget();
        double oldPrice = comp.get(compIn).getPrice();

        //Minus price from budget
        invest.get(invIn).setBudget(creator.round((invest.get(invIn).getBudget() - comp.get(compIn).getPrice()),2));
        //and check if old price same as maximal Budget than run loop and check all investor where is now Max Budget
        if(var.getMaxBudget() == oldBudget){
            var.setMaxBudget(0);
            for(int i = 0; i < invest.size(); i++){
                if(var.getMaxBudget() < invest.get(i).getBudget()){
                    var.setMaxBudget(invest.get(i).getBudget());
                }
            }
        }
        //Add one share to investor
        invest.get(invIn).setSharesBought(invest.get(invIn).getSharesBought() + 1);

        //Set share bought this round to true and minus from shares left and from total shares
        comp.get(compIn).setSoldThisRound(true);
        comp.get(compIn).setSharesLeft(comp.get(compIn).getSharesLeft() -1);
        var.setTotalShares(var.getTotalShares() - 1);
        //in no more shares left set company that cant sell anymore
        if(comp.get(compIn).getSharesLeft() == 0){
            comp.get(compIn).setAllSold(true);
        }


        //Price counter +1 and if it has 10 to double the price
        comp.get(compIn).setPriceCounter(comp.get(compIn).getPriceCounter() +1);

        if(comp.get(compIn).getPriceCounter() == 10){
            comp.get(compIn).setPriceCounter(0);
            comp.get(compIn).setPrice(creator.round((comp.get(compIn).getPrice() * 2), 2));

            //and if this company had the old price equal to global minimal price check who have now the min price
            if(var.getMinPrice() == oldPrice){
                for(int i = 0; i < comp.size(); i++){
                    if(var.getMinPrice() > comp.get(i).getPrice()){
                        var.setMinPrice(comp.get(i).getPrice());
                    }
                }
            }
        }
        //and if budget of this investor is smaller than global min price of share set variable cantBuys to true
        if(invest.get(invIn).getBudget() < var.getMinPrice()){
            invest.get(invIn).setCantBuy(true);
        }

        var.setSuccess(true);

    }
}
