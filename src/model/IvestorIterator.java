package model;

import controller.DataCreator;

import java.util.ArrayList;

public class IvestorIterator implements InvestorIteratorInterface {

    ArrayList<Investor> investors;
    int filterNumber;
    int position;

    public  IvestorIterator(ArrayList<Investor> investors, int filterNumber){
        this.investors = investors;
        this.filterNumber = filterNumber;
        this.position = 0;
    }


    @Override
    public boolean hasNext() {
        Investor i = null;

        while(position < investors.size()){
            i = investors.get(position);


            if(i.getSharesBought() == filterNumber){
                return true;
            }else {
                position++;
            }
        }
        return false;

    }

    @Override
    public Investor next() {
        Investor i = investors.get(position);
        position++;
        return i;
    }
}
