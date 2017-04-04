



import java.util.Date;


public class Books  implements java.io.Serializable {


     private Integer id;
     private String callno;
     private String name;
     private String author;
     private String publisher;
     private int quantity;
     private int issued;
     private Date date;
     private String genre;

    /**
     * author Melissa Case
     */
    public Books() {
    }

    /**
     *
     * @param callno
     * @param name
     * @param author
     * @param publisher
     * @param quantity
     * @param issued
     * @param addedDate
     * @param genre
     */
    public Books(String callno, String name, String author, String publisher, int quantity, int issued, Date addedDate, String genre) {
       this.callno = callno;
       this.name = name;
       this.author = author;
       this.publisher = publisher;
       this.quantity = quantity;
       this.issued = issued;
       this.date = addedDate;
       this.genre = genre;
    }
   
    /**
     *
     * @return
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getCallno() {
        return this.callno;
    }
    
    /**
     *
     * @param callno
     */
    public void setCallno(String callno) {
        this.callno = callno;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public String getPublisher() {
        return this.publisher;
    }
    
    /**
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public int getIssued() {
        return this.issued;
    }
    
    /**
     *
     * @param issued
     */
    public void setIssued(int issued) {
        this.issued = issued;
    }

    /**
     *
     * @return
     */
    public Date getAddedDate() {
        return this.date;
    }
    
    /**
     *
     * @param addedDate
     */
    public void setAddedDate(Date addedDate) {
        this.date = addedDate;
 
    }
    /**
     *
     * @return
     */
    public String getGenre() {
        return this.genre;
    }
    
    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }




}


