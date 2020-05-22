package model;



//This is Enum singleton I use it to have one global instance of this variables
//and any changes will be the same for all
public enum GlobalVar {
    instance;


    //This variables will be used to check how many shares left and min cost of any share and max budget from all investors
    //and  how many rounds left to reduce the price
    //Success  variable will be used to check if share was already bought
    //In this case it will be possible to track when the sales date should to stop

    private int totalShares = 0;
    private double minPrice = 100;
    private double maxBudget = 0;
    private String uuidOfMinPrice;
    private String uuidOfMaxBudget;
    private int roundCounter = 0;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }

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
