import controller.DataCreator;
import model.Company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws IOException {





        ArrayList<Company> creator = new DataCreator().getCompanies();

//        for(int i = 0; i < creator.size(); i++){
//            System.out.println(creator.get(i).getId() + " "+ creator.get(i).getName() + " " + creator.get(i).getShares() + " " + creator.get(i).getPrice());
//        }

    }



}
