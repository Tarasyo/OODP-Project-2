package model;

import java.util.ArrayList;

public class CompanyIterator implements CompanyIteratorInterface {

    FilterType type;
    ArrayList<Company> companies;
    int filterNumber;
    int position;

    public CompanyIterator(FilterType type, ArrayList<Company> companies, int filterNumber){
        this.type = type;
        this.companies = companies;
        this.filterNumber = filterNumber;
        this.position = 0;
    }



    @Override
    public boolean hasNext() {
        if(this.type == FilterType.HIGHEST){

        }


        return false;
    }

    @Override
    public Company next() {
        return null;
    }
}
