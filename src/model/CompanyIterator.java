package model;

import controller.DataCreator;

import java.util.ArrayList;


//For out printing Companies with highest and lowest capital was used Iterator Pattern
//It passes the highest or the lowest capital that was found befor in controller class and checks if it have more companies with same capital
//it can't be lower or higher because it was checked before.
public class CompanyIterator implements CompanyIteratorInterface {

    DataCreator creator = new DataCreator();
    ArrayList<Company> companies;
    double filterNumber;
    int position;


    //Constructor to pass all the variables
    public CompanyIterator(ArrayList<Company> companies, double filterNumber){
        this.companies = companies;
        this.filterNumber = filterNumber;
        this.position = 0;
    }


    //hasNext and next are created in typical structure
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
