package model;

import java.util.ArrayList;

//Interface for Chain Pattern
public interface SaleDayLink {

    void setNextLink(SaleDayLink nextLink);

    void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int invIn);



}
