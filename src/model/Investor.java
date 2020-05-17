package model;

import java.util.ArrayList;




//Investor
public class Investor {


    private String id;
    private String name;
    private double budget;
    private int sharesBought;
    private boolean cantBuy;



    public Investor(String id, String name, double budget) {

        this.id = id;
        this.name = name;
        this.budget = budget;
        this.sharesBought = 0;
        this.cantBuy = false;
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

    public boolean isCantBuy() {
        return cantBuy;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setSharesBought(int sharesBought) {
        this.sharesBought = sharesBought;
    }

    public void setCantBuy(boolean cantBuy) {
        this.cantBuy = cantBuy;
    }


}
