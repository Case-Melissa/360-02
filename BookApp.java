/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360;

import java.io.*;
/**
 *
 * @author mcase
 */
public class BookApp {

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        
        Book bookOne =  new Book ("Twilight");
        Book bookTwo = new Book ("Witch and Wizard");
        Book bookThree = new Book ("The Fault in our Stars");
        Book bookFour =  new Book ("Hunger Games");
        Book bookFive = new Book ("Harry Potter and the Sorcerer's Stone");
        
        bookOne.title("Twilight");
        bookOne.pages(498);
        bookOne.author("Stephenie Meyer");
        bookOne.printBook();
      
        bookTwo.title("Witch and Wizard");
        bookTwo.pages(336);
        bookTwo.author("James Patterson");
        
        bookThree.title("The Fault in our Stars");
        bookThree.pages(318);
        bookThree.author("John Green");
    
        bookFour.title("Hunger Games");
        bookFour.pages(384);
        bookFour.author("Suzanne Collins");
        
        bookFive.title("Harry Potter and the Sorcerer's Stone");
        bookFive.pages(309);
        bookFive.author("J. K. Rowling");
    }
       
         public class Book {
   String title;
   int pages ;
   String author;
   
    public Book(String title){
        this.title = title;
    }
    public void pageNumbers (int pageNumbers){
        pages = pageNumbers;
    }
    
    public void bookAuthor(String bookAuthor){
        author = bookAuthor;
        
    }
    public void printInfo(){
       System.out.println("Title: " + title );
       System.out.println("Author" + author);
       System.out.println("Number of pages in book" + pages);   
    }

        private void printBook() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void author(String bookAuthor) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void pages(int pageNumbers) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void title(String title) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
}
}
