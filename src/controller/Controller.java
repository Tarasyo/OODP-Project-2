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

    GlobalVar var = GlobalVar.getInstance();





    public Controller(){

        dataGen = new DataCreator();


        try {

            companies = dataGen.getCompanies();
            investors = dataGen.getInvestors();


        } catch (IOException e) {
            e.printStackTrace();
        }
        //cout();
        salesDay(companies, investors);

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

    public void options(){
        String input;
        for (int i = 0; i < menu.getMenu().size(); i++) {
            System.out.println((menu.getMenu().get(i)));
        }
        System.out.println("Please Select one of the options");
        input = bufferR();
        switch (input) {
            case "1":

                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

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

    public void salesDay(ArrayList<Company> c, ArrayList<Investor> i){
        ArrayList<Company> comp = c;
        ArrayList<Investor> invest = i;

        Random random = new Random();
        SaleDayLink d1 = new SaleDayStart();
        SaleDayLink d2 = new SalesDayTen();

           d1.setNextLink(d2);
//        for(int io =0; io < investors.size(); io++){
//            System.out.println(investors.get(io).getBudget());
//        }

        while((var.getTotalShares() == 0) || (var.getMaxBudget() > var.getMinPrice())) {
//        System.out.println(var.getTotalShares());
//            System.out.print(var.getMaxBudget()+ "==");
//            System.out.println(var.getMinPrice());

            int investorIndex = random.nextInt(100);
            if(var.getRoundCounter() == 11){
                var.setRoundCounter(0);
            }
            d1.sales(comp, invest, investorIndex);

        }

        companies = comp;
        investors = invest;

//        for(int io = 0; io < companies.size(); io++){
//            System.out.println(companies.get(io).getPrice());
//        }

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
