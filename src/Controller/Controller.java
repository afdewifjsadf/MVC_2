/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.RestaurantModel;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tana_
 */
public class Controller implements ActionListener {

    private View v;
    private RestaurantModel m;
    private Database db;
    private ArrayList<RestaurantModel> restaurantList;

    public Controller(View v, RestaurantModel m) {
        this.v = v;
        this.m = m;
        this.db = new Database();

        v.setVisible(true);

        v.getjButton1().setActionCommand("orderbyname");
        v.getjButton2().setActionCommand("orderbyreview");
        v.getjButton3().setActionCommand("readThai");
        v.getjButton1().addActionListener(this);
        v.getjButton2().addActionListener(this);
        v.getjButton3().addActionListener(this);
        v.getjTextField1().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("orderbyname")) {
            try {
                restaurantList = db.readAll();

                if (!restaurantList.isEmpty()) {
                    if (restaurantList.size() > Integer.parseInt(v.getjTextField1().getText())) {
                        restaurantList = new ArrayList(restaurantList.subList(0, Integer.parseInt(v.getjTextField1().getText())));
                    }
                    restaurantList.sort(Comparator.comparing(RestaurantModel::getName));
                    v.showorderByName(restaurantList);
                } else {
                    v.setjTextArea1("It's Empty");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (command.equals("orderbyreview")) {
            try {
                restaurantList = db.readAll();

                if (!restaurantList.isEmpty()) {
                    if (restaurantList.size() > Integer.parseInt(v.getjTextField1().getText())) {
                        restaurantList = new ArrayList(restaurantList.subList(0, Integer.parseInt(v.getjTextField1().getText())));
                    }
                    restaurantList.sort(Comparator.comparing(RestaurantModel::getReviewPoint));
                    Collections.reverse(restaurantList);
                    v.showorderByreview(restaurantList);
                } else {
                    v.setjTextArea1("It's Empty");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (command.equals("readThai")) {
            try {
                restaurantList = db.readAll();
                ArrayList<RestaurantModel> result = new ArrayList<>();
                if (!restaurantList.isEmpty()) {
                    for (RestaurantModel r : restaurantList) {
                        int realkawtom = 0;
                        int notrealkawtom = 0;
                        for (String s : r.getReviewList()) {
                            System.out.println(s);
                            if (s.equals("notrealkawtom")) {
                                notrealkawtom+=1;
                            }
                            if (s.equals("realkawtom")) {
                                realkawtom+=1;
                            }
                        }
                        if (realkawtom > notrealkawtom) {
                           result.add(r);
                        }
                    }
                    if (restaurantList.size() > Integer.parseInt(v.getjTextField1().getText())) {
                        result = new ArrayList(result.subList(0, Integer.parseInt(v.getjTextField1().getText())));
                    }
                    v.showRealThai(result);

                } else {
                    v.setjTextArea1("It's Empty");
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
