/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tana_
 */
public class Database {
    
    File myObj;
    public Database() {
         myObj = new File("C:\\Users\\tana_\\OneDrive - KMITL\\Documents\\NetBeansProjects\\ProjectMVC_2\\src\\Model\\data.txt");
    }
    public ArrayList<RestaurantModel> readAll() throws FileNotFoundException{
        ArrayList<RestaurantModel> rList = new ArrayList<RestaurantModel>();
        try (Scanner myReader = new Scanner(myObj)) {
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] arrOfData = data.split(",");
                boolean check = true;
                String name = arrOfData[0];
                double review = 0;
                ArrayList<String> menuList = new ArrayList<String>();
                ArrayList<String> reviewList = new ArrayList<String>();
                for(int i = 1; i<arrOfData.length ;i++ ){
                    if(arrOfData[i].equals("review")){
                        check = false;
                        review =  Double.parseDouble(arrOfData[i+1]);
                        i+=2;
                    }
                    if(check && !arrOfData[i].equals("review") && !arrOfData[i].equals("menu")){
                        menuList.add(arrOfData[i]);
                    }else if (!check && !arrOfData[i].equals("review") && !arrOfData[i].equals("menu") ){
                        reviewList.add(arrOfData[i]);
                    }
                    
                }
                rList.add(new RestaurantModel(name, menuList, review, reviewList));
            }
        }
        return rList;
    }

    
    

}
