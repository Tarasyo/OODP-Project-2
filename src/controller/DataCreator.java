package controller;

import model.Company;
import model.Investor;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import static jdk.nashorn.internal.objects.NativeMath.round;


public class DataCreator {






   public  ArrayList<Company> getCompanies() throws IOException {
       ArrayList<Company> companies = new ArrayList<Company>();

        String fileName = "D:\\programing\\java\\OODP_CA2\\src\\controller\\companys.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null){

            Company.BuilderCompany builder =
                    new Company.BuilderCompany(getUuid(), line, getRandomShares(), getRandomPrice());

            companies.add(builder.build());
        }


       return companies;
   }

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

           investors.add(builder.build());

       }



       return investors;
   }

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }


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






}
