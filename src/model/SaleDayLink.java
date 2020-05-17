package model;

import java.util.ArrayList;

public interface SaleDayLink {

    void setNextLink(SaleDayLink nextLink);

    void sales(ArrayList<Company> comp, ArrayList<Investor> invest, int i, int invIn);



}
