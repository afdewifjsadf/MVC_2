/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmvc_2;

import Controller.Controller;
import Model.RestaurantModel;
import View.View;

/**
 *
 * @author tana_
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        RestaurantModel m = new RestaurantModel();
        Controller c =  new Controller(v, m);
    }
    
}
