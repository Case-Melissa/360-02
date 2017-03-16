/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookapp;


import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author mcase
 */
public class BookApp {

   Scanner bookInput = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       BookApp bookApp =  new BookApp();
       boolean end = false;
       
       while (!end){
           end = bookApp.login();
       }
       system.exit(0);
    }
    private boolean login(){
        boolean end  = false;
    }
    
}
