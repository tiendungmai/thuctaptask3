/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thuctaptask3;

import java.util.ArrayList;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 *
 * @author tiendungmai
 */
/* chinh sua tren local */
public class Task {

     public static boolean test(int n) {
        int cout = 0;
        if (n < 2) {
            return false;
        } 
        else {
            for (int i = 2; i < n / 2; i++) {
                if (n % i == 0) {
                    cout++;
                }
            }
            if (cout == 0) {
                return true;
            } else {
                return false;
            }
        }

    }

    public static ArrayList<Integer> primes(int n) {
        ArrayList<Integer> pri = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (test(i)) {
                pri.add(i);
            }
        }
        return pri;
    }

    public static void main(String[] args) {
        Spark.get("/prime", (rqst, rspns) -> {
            //return primes(Integer.parseInt(rqst.queryParams("n")));
            ArrayList<Integer> pri = new ArrayList<>();
            for(int i = 1 ; i <= Integer.parseInt(rqst.queryParams("n")); i++){
                if(test(i))
                    pri.add(i);
                    
            }
            return pri;
           // return "number " + rqst.queryParams("n");
           
        });
        Spark.get("/hello", new Route() {

            @Override
            public Object handle(Request arg0, Response arg1) throws Exception {
                return "Hello World from Spark";
            }

            

        });
    }
}
