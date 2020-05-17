package view;

import java.util.ArrayList;

public class Menu {
    /*
     * Just simple menu with options that are stored in Array LIst
     * The class with methods are taken from My work on DoubleLinkedList and little bit changed
     *https://github.com/Tarasyo/DoubleLinkedList_CA/blob/master/src/main/java/View/View.java
     * */

    private ArrayList menu;

    public Menu() {

        System.out.println("-------------Menu---------------");

        menu = new ArrayList<>();

        menu.add("1. Company with highest capital");
        menu.add("2. Company with lowest capital");
        menu.add("3. Investor with the highest number of shares");
        menu.add("4. Investor with the lowest number of shares");
        menu.add("5. Exit");


    }

    public ArrayList getMenu() {
        return menu;
    }

}