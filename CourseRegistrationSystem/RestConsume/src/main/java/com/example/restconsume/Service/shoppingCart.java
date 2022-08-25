package com.example.restconsume.Service;

import lombok.Synchronized;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*this bean by default is not in session scope
@scope("session") wouldnt work here since it's not web controller
these 2 annotation turn this into a bean of Session Scope */

@SessionScope
@ManagedBean
public class shoppingCart {

    private Map<Integer, List<Integer>> shoppingCart;

    public shoppingCart() {}

    @Synchronized
    public Map<Integer, List<Integer>> getShoppingCart() {
        if(shoppingCart==null){
            shoppingCart=new HashMap<>();
        }
        return shoppingCart;
    }


    public void setShoppingCart(int studentId, int courseId) {
        try {
            //if the map dont contain studentID, initalize a new arraylist
            if(!shoppingCart.containsKey(studentId)){
                shoppingCart.put(studentId,new ArrayList<>());
                }

            //check if the course already exist in the arraylst
          if(shoppingCart.get(studentId).contains(courseId)){
                    throw new RuntimeException("course already exists"); }

          //else dont exist, add the course to the list
          else
           shoppingCart.get(studentId).add(courseId);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }



}
