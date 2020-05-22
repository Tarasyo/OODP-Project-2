package model;






//Company class with all setters and getters
//It was created more variables in investor object and company for faster check and safer check of condition
public class Company {

    private String id;
    private String name;
    private int shares;
    private double price;
    //priceCounter will add plus one until it will be 10 and price will double
    private int priceCounter;
    //minus one share after each transaction if it 0, boolean allSold set to true
    private int sharesLeft;
    private boolean allSold;
    //boolean if in fresh 10 rounds this company sel some shears will set to true
    private boolean soldThisRound;


    public Company(String id, String name, int shares, double price) {

        this.id = id;
        this.name = name;
        this.shares = shares;
        this.price = price;
        this.priceCounter = 0;
        this.sharesLeft = shares;
        this.allSold = false;
        this.soldThisRound = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPriceCounter() {
        return priceCounter;
    }

    public void setPriceCounter(int priceCounter) {
        this.priceCounter = priceCounter;
    }

    public int getSharesLeft() {
        return sharesLeft;
    }

    public void setSharesLeft(int sharesLeft) {
        this.sharesLeft = sharesLeft;
    }


    public boolean isAllSold() {
        return allSold;
    }

    public void setAllSold(boolean allSold) {
        this.allSold = allSold;
    }

    public boolean getSoldThisRound() {
        return soldThisRound;
    }

    public void setSoldThisRound(boolean soldThisRound) {
        this.soldThisRound = soldThisRound;
    }
}