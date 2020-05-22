package model;

import controller.DataCreator;

import java.util.ArrayList;

public class CompanyIterator implements CompanyIteratorInterface {

    DataCreator creator = new DataCreator();
    ArrayList<Company> companies;
    double filterNumber;
    int position;

    public CompanyIterator(ArrayList<Company> companies, double filterNumber){
        this.companies = companies;
        this.filterNumber = filterNumber;
        this.position = 0;
    }



    @Override
    public boolean hasNext() {
            Company c = null;

            while(position < companies.size()){
                c = companies.get(position);
                double capital = creator.round((c.getPrice() * c.getShares()), 4);

                if(capital == filterNumber){
                    return true;
                }else {
                    position++;
                }
            }
            return false;

    }

    @Override
    public Company next() {
        Company c = companies.get(position);
        position++;
        return c;
    }
}
