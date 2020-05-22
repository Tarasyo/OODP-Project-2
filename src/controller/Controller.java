package controller;

import model.*;
import view.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Controller {

    private DataCreator dataGen;
    private Menu menu;

    private ArrayList<Company> companies;
    private ArrayList<Investor> investors;
    //This global variables will be used to check all this data straight after selling day finished
    private double HighestCompany = 0;
    private double LowestCompany = 100000000;
    private int HighestInvestor = 0;
    private int LowestInvestor = 10000;

    GlobalVar var = GlobalVar.getInstance();





    public Controller(){

        dataGen = new DataCreator();


        try {

            companies = dataGen.getCompanies();
            investors = dataGen.getInvestors();


        } catch (IOException e) {
            e.printStackTrace();
        }

        salesDay(companies, investors);
        getTotalData();

        menu = new Menu();
        options();





    }

//    public void cout(){
//        for(int io = 0; io < companies.size(); io++){
//            System.out.println("companys"+io);
//       }
//        for(int io =0; io < investors.size(); io++){
//            System.out.println("ivestors"+io);
//        }
//    }

    //Just class and out prints menu and wait for some user action
    public void options(){
        String input;
        for (int i = 0; i < menu.getMenu().size(); i++) {
            System.out.println((menu.getMenu().get(i)));
        }
        System.out.println("Please Select one of the options");
        input = bufferR();
        switch (input) {
            case "1":
                highestCapital();
                break;
            case "2":
                lowestCapital();
                break;
            case "3":
                highestInvestor();
                break;
            case "4":
                lowestInvestor();
                break;
            case "5":
                exit();
                break;
            default:
                System.out.println("Please choice one of the options");
                options();
                break;
        }
    }

    //In sales day Method pass the array lists of investors and companies
    public void salesDay(ArrayList<Company> c, ArrayList<Investor> i){
        ArrayList<Company> comp = c;
        ArrayList<Investor> invest = i;

        Random random = new Random();
        //create instance of my chain
        SaleDayLink d1 = new SaleDayStart();
        SaleDayLink d2 = new SalesDayTen();
            //and the position of them in chain
           d1.setNextLink(d2);

        //loop will work until will left no shears or the richest investor wont be able to buy the cheapest share
        while((var.getTotalShares() == 0) || (var.getMaxBudget() > var.getMinPrice())) {

            //random number for index of the investor
            int investorIndex = random.nextInt(100);
            //after 10 rounds on 11 need to drop rounds back to 0
            if(var.getRoundCounter() == 11){
                var.setRoundCounter(0);
            }
            d1.sales(comp, invest, investorIndex);
       //     System.out.println("Loading......");

        }
        //pass changed arrays to global
        companies = comp;
        investors = invest;


    }
    //this method checks the highest and lowest company and investor and assign the variables to globals variable
    public void getTotalData() {

        for (int i = 0; i < companies.size(); i++) {
            double capital = dataGen.round((companies.get(i).getShares() * companies.get(i).getPrice()), 2);
            if (HighestCompany < capital) {
                this.HighestCompany = capital;
            }
            if (LowestCompany > capital) {
                this.LowestCompany = capital;
            }
        }

        for(int i = 0; i < investors.size(); i++){
            if(HighestInvestor < investors.get(i).getSharesBought()){
                this.HighestInvestor = investors.get(i).getSharesBought();
            }
            if(LowestInvestor > investors.get(i).getSharesBought()){
                this.LowestInvestor = investors.get(i).getSharesBought();
            }
        }
    }
    //This methods just make use off iterators to find the companies and investor with the same value if its more than one company or investor
    //all structure of the methods below is the same
    public void highestCapital(){
        Company c;
        //create ne instance that passes the value which I want to check
        CompanyIteratorInterface highestCompany = new CompanyIterator(companies, HighestCompany);
        while(highestCompany.hasNext()){
            c = highestCompany.next();
            //go trough all array List and out print all that have same value
            System.out.println("Company Name: "+c.getName()+"| Company total Shares: "+ c.getShares()+"| Price: "+ c.getPrice() +"| Capital: "+ (c.getShares() * c.getPrice()) );
        }
        System.out.println("------------------------------------------------------------------------");
        //call menu after printing the information
        options();
    }
    public void lowestCapital(){
        Company c;
        CompanyIteratorInterface lowestCompany = new CompanyIterator(companies, LowestCompany);
        while(lowestCompany.hasNext()){
            c = lowestCompany.next();
            System.out.println("Company Name: "+c.getName()+"| Company total Shares: "+ c.getShares()+"| Price: "+ c.getPrice() +"| Capital: "+ (c.getShares()* c.getPrice()) );
        }
        System.out.println("------------------------------------------------------------------------");
        options();
    }
    public void highestInvestor(){
        Investor i;
        InvestorIteratorInterface highestInvestor = new IvestorIterator(investors, HighestInvestor);
        while (highestInvestor.hasNext()){
            i = highestInvestor.next();
            System.out.println("Investor Name: "+i.getName()+"| Total Shares: "+ i.getSharesBought());
        }
        System.out.println("------------------------------------------------------------------------");
        options();
    }
    public void lowestInvestor(){
        Investor i;
        InvestorIteratorInterface lowestInvestor = new IvestorIterator(investors, LowestInvestor);
        while (lowestInvestor.hasNext()){
            i = lowestInvestor.next();
            System.out.println("Investor Name: "+i.getName()+"| Total Shares: "+ i.getSharesBought());
        }
        System.out.println("------------------------------------------------------------------------");
        options();
    }



    //method to exit from java machine
    public void  exit(){
        System.exit(0);
    }


    //Method to read input from user
    public String  bufferR() {
        String input = "";
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            input = br.readLine();

        }catch(Exception e) { System.out.println("Error reading input");}
        return input;
    }

}
