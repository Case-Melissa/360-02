package bookapp;
// Generated Mar 16, 2017 6:59:13 AM by Hibernate Tools 4.3.1



/**
 * Pages generated by hbm2java
 */
public class Pages  implements java.io.Serializable {


     private Integer id;
     private int pagesId;
     private int pages;

    public Pages() {
    }

    public Pages(int pagesId, int pages) {
       this.pagesId = pagesId;
       this.pages = pages;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getPagesId() {
        return this.pagesId;
    }
    
    public void setPagesId(int pagesId) {
        this.pagesId = pagesId;
    }
    public int getPages() {
        return this.pages;
    }
    
    public void setPages(int pages) {
        this.pages = pages;
    }




}


