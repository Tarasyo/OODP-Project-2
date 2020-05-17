package model;






// For company was used BuilderPater with inner class that build and pass data to to the main constructor
public class Company {

    private String id;
    private String name;
    private int shares;
    private double price;
    private int priceCounter;
    private int sharesLeft;
    private int sharesSold;
    private boolean allSold;
    private boolean soldThisRound;


    private Company(BuilderCompany builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.shares = builder.shares;
        this.price = builder.price;
        this.priceCounter = builder.priceCounter;
        this.sharesLeft = builder.sharesLeft;
        this.allSold = builder.allSold;
        this.soldThisRound = builder.soldThisRound;
        this.sharesSold = builder.sharesSold;
    }

    public int getSharesSold() {
        return sharesSold;
    }

    public boolean isSoldThisRound() {
        return soldThisRound;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getShares() {
        return shares;
    }

    public double getPrice() {
        return price;
    }

    public int getPriceCounter() {
        return priceCounter;
    }

    public int getSharesLeft() {
        return sharesLeft;
    }

    public boolean isAllSold() {
        return allSold;
    }

    public static class BuilderCompany {

        private String id;
        private String name;
        private int shares;
        private double price;
        private int priceCounter;
        private int sharesLeft;
        private boolean allSold;
        private boolean soldThisRound;
        private int sharesSold;

        public BuilderCompany(String id, String name, int shares, double price) {

            this.id = id;
            this.name = name;
            this.shares = shares;
            this.price = price;
            this.priceCounter = 0;
            this.sharesLeft = shares;
            this.allSold = false;
            this.soldThisRound = false;
            this.sharesSold = 0;
        }
        public BuilderCompany setSold(int sold){
            this.sharesSold = sold;
            return this;
        }

        public BuilderCompany setThisRound(boolean round){
            this.soldThisRound = round;
            return this;
        }

        public BuilderCompany setPriceConter(int priceCounter){
            this.priceCounter = priceCounter;
            return this;
        }


        public BuilderCompany setPrice(double price){
                this.price = price;
                return this;
        }

        public BuilderCompany setLeft(int sold){
            this.sharesLeft = sold;
            return this;
        }

        public BuilderCompany setAllSold(boolean all){
            this.allSold = all;
            return this;
        }


        public Company build() {
            return new Company(this);
        }


    }
}