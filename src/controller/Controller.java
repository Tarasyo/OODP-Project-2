package controller;

import view.Menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller {

    private DataCreator dataGen;
    private Menu menu;


    public Controller(){

        dataGen = new DataCreator();
        menu = new Menu();

        options();

    }

    public void options(){
        String input;
        for (int i = 0; i < menu.getMenu().size(); i++) {
            System.out.println(String.valueOf(menu.getMenu().get(i)));
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
