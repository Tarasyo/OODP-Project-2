package controller;

import model.Company;
import model.Investor;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;




public class DataCreator {

    //This variables will be used to check how many shares left and min cost of any share and max budget from all investors
    //and the uuid of the company with min price
    //In this case it will be possible to track when the sales date should to stop

    private int totalShares = 0;
    private double minPrice = 100;
    private double maxBudget = 0;
    private String uuidOfMinPrice;



    //Method for creating data for 100 companies
   public  ArrayList<Company> getCompanies() throws IOException {
       ArrayList<Company> companies = new ArrayList<Company>();

       //Read from file that holds data of 100 companies
        String fileName = "D:\\programing\\java\\OODP_CA2\\src\\controller\\companys.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        //while loop will finished when all lines will be passed
       //in general I know that its 100 because this is the number of names in the file
        while((line = br.readLine()) != null){

            //declaring amd initialize new company object that by use of another methods generates data for the object and name from file
            //and pass it to the arrayList of company objects
            Company.BuilderCompany builder =
                    new Company.BuilderCompany(getUuid(), line, getRandomShares(), getRandomPrice());
                    this.totalShares += builder.build().getShares();

                    if(minPrice > builder.build().getPrice()){
                        minPrice = builder.build().getPrice();
                        uuidOfMinPrice = builder.build().getId();
                    }

            companies.add(builder.build());
        }


       return companies;
   }

   //get investors in works in the same way as getCompanies just uses few different methods to generate data
   public ArrayList<Investor> getInvestors() throws IOException{
       ArrayList<Investor> investors = new ArrayList<Investor>();

       String fileName = "D:\\programing\\java\\OODP_CA2\\src\\controller\\investors.txt";
       File file = new File(fileName);
       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);
       String line;

       while((line = br.readLine()) != null){

           Investor.BuilderInvestor builder =
                   new Investor.BuilderInvestor(getUuid(), line, getRandomBudget());

           if(maxBudget < builder.build().getBudget()){
               maxBudget = builder.build().getBudget();
           }

           investors.add(builder.build());

       }



       return investors;
   }

   //Method for creating uuid for companies and investors
    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }


    //3 next methods return random number in the range of needed for price shares or budget
    public static int getRandomShares(){
       int randomInt = (int)(Math.random() * 1000 + 500);

       return randomInt;
    }

    public static  double getRandomPrice(){
       double randomDouble = Math.random() * 100 + 10;


       return randomDouble;
    }


    public static double getRandomBudget(){
        double randomDouble = Math.random() * 10000 + 10;

        return randomDouble;
    }

    public String getUuidOfMinPrice() {
        return uuidOfMinPrice;
    }

    public void setUuidOfMinPrice(String uuidOfMinPrice) {
        this.uuidOfMinPrice = uuidOfMinPrice;
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


}
