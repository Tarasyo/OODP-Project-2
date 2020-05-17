package model;

public enum GlobalVar {
    instance;


    //This variables will be used to check how many shares left and min cost of any share and max budget from all investors
    //and the uuid of the company with min price
    //In this case it will be possible to track when the sales date should to stop

    private int totalShares = 0;
    private double minPrice = 100;
    private double maxBudget = 0;
    private String uuidOfMinPrice;
    private String uuidOfMaxBudget;


    public String getUuidOfMaxBudget() {
        return uuidOfMaxBudget;
    }

    public void setUuidOfMaxBudget(String uuidOfMaxBudget) {
        this.uuidOfMaxBudget = uuidOfMaxBudget;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public String getUuidOfMinPrice() {
        return uuidOfMinPrice;
    }

    public void setUuidOfMinPrice(String uuidOfMinPrice) {
        this.uuidOfMinPrice = uuidOfMinPrice;
    }

    public static GlobalVar getInstance(){
        return instance;
    }
}
