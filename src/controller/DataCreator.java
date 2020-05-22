package controller;

import model.Company;
import model.GlobalVar;
import model.Investor;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;




public class DataCreator {


    GlobalVar var = GlobalVar.getInstance();

    //Method for creating data for 100 sales
   public  ArrayList<Company> getCompanies() throws IOException {
       ArrayList<Company> companies = new ArrayList<Company>();

       //Read from file that holds data of 100 sales
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
            Company company = new Company(getUuid(), line, getRandomShares(), getRandomPrice());
                    var.setTotalShares(var.getTotalShares() + company.getShares());

                    if(var.getMinPrice() > company.getPrice()){
                        var.setMinPrice(company.getPrice());
                        var.setUuidOfMinPrice(company.getId());
                    }

            companies.add(company);
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

           Investor investor = new Investor(getUuid(), line, getRandomBudget());

           if(var.getMaxBudget() < investor.getBudget()){
               var.setMaxBudget(investor.getBudget());
               var.setUuidOfMaxBudget(investor.getId());
           }

           investors.add(investor);

       }



       return investors;
   }

   //Method for creating uuid for sales and investors
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


       return round(randomDouble, 2);
    }


    public static double getRandomBudget(){
        double randomDouble = Math.random() * 10000 + 10;

        return round(randomDouble, 2);
    }

    //round double to 2 decimal places code taken from: https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
