/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package books;


import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author mcase
 */
public class Books {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the title of the book: ");
        String title = read.readLine();
        System.out.println("The title of the book is: "+ title);
    
        BufferedReader auth = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please provide the name of the author of " + title + ": ");
        String author =  auth.readLine();
        System.out.println("The author of " + title + " is " + author);
    
       Scanner scan = new Scanner(System.in);
       System.out.print("Enter the number of pages: ");
       int number = scan.nextInt();
       System.out.println("There are " +number + " of pages in " + title);
    }
    
}

