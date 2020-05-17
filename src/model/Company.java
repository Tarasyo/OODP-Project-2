package model;

public class Company {

    private String id;
    private String name;
    private int shares;
    private double price;
    private int priceCounter;
    private int sharesSold;
    private boolean allSold;


    private Company(BuilderCompany builder) {

        this.id = builder.id;
        this.name = builder.name;
        this.shares = builder.shares;
        this.price = builder.price;
        this.priceCounter = builder.priceCounter;
        this.sharesSold = builder.sharesSold;
        this.allSold = builder.allSold;

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

    public int getSharesSold() {
        return sharesSold;
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
        private int sharesSold;
        private boolean allSold;

        public BuilderCompany(String id, String name, int shares, double price) {

            this.id = id;
            this.name = name;
            this.shares = shares;
            this.price = price;
            this.priceCounter = 0;
            this.sharesSold = 0;
            this.allSold = false;
        }

        public BuilderCompany setPriceConter(int priceCounter){
            this.priceCounter = priceCounter;
            return this;
        }


        public BuilderCompany setPrice(double price){
                this.price = price;
                return this;
        }

        public BuilderCompany setSold(int sold){
            this.sharesSold = sold;
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