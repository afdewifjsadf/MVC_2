/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author tana_
 */
public class RestaurantModel {
    private String name;
    private ArrayList<String> menuList;
    private double reviewPoint;
    private  ArrayList<String> reviewList;

    public String getName() {
        return name;
    }

    public ArrayList<String> getMenuList() {
        return menuList;
    }

    public double getReviewPoint() {
        return reviewPoint;
    }

    public ArrayList<String> getReviewList() {
        return reviewList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuList(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public void setReviewPoint(double reviewPoint) {
        this.reviewPoint = reviewPoint;
    }

    public void setReviewList(ArrayList<String> reviewList) {
        this.reviewList = reviewList;
    }

    public RestaurantModel(String name, ArrayList<String> menuList, double reviewPoint, ArrayList<String> reviewList) {
        this.name = name;
        this.menuList = menuList;
        this.reviewPoint = reviewPoint;
        this.reviewList = reviewList;
    }

    public RestaurantModel() {
    }

    @Override
    public String toString() {
        return "RestaurantModel{" + "name=" + name + ", menuList=" + menuList + ", reviewPoint=" + reviewPoint + ", reviewList=" + reviewList + '}';
    }
    
    
    
}
