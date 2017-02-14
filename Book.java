/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360;
/**
 *
 * @author mcase
 */



 class Book {
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
}


