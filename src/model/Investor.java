package model;

import java.util.ArrayList;




//Investor was created as BuilderPattern as well with the same structure but has one arrayList where will be stored IDs of bought company shares
public class Investor {


    private String id;
    private String name;
    private double budget;
    private int sharesBought;
    private ArrayList<String> companys = new ArrayList<String>();
    private boolean cantBuy;



    private Investor(BuilderInvestor builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.budget = builder.budget;
        this.sharesBought = builder.sharesBought;
        this.cantBuy = builder.cantBuy;


    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public int getSharesBought() {
        return sharesBought;
    }

    public ArrayList<String> getCompanys() {
        return companys;
    }

    public boolean isCantBuy() {
        return cantBuy;
    }

    public static class BuilderInvestor {


        private String id;
        private String name;
        private double budget;
        private int sharesBought;
        private String companyId;
        private boolean cantBuy;

        public BuilderInvestor(String id, String name, double budget) {

            this.id = id;
            this.name = name;
            this.budget = budget;
            this.sharesBought = 0;
            this.cantBuy = false;
        }




        public BuilderInvestor setShares(int shares){
            this.sharesBought = shares;
            return this;
        }

        public BuilderInvestor setCompany(String companyId){
            this.companyId = companyId;
            return this;
        }

        public BuilderInvestor setAllSold(boolean noMoney){
            this.cantBuy = noMoney;
            return this;
        }


        public Investor build() {
            return new Investor(this);
        }


    }


}
