package book_app;
// Generated Mar 24, 2017 9:51:53 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Issuebooks generated by hbm2java
 */
public class Issuebooks  implements java.io.Serializable {


     private Integer id;
     private String bookcallno;
     private int studentid;
     private String studentname;
     private String studentcontact;
     private Date issueddate;

    public Issuebooks() {
    }

    public Issuebooks(String bookcallno, int studentid, String studentname, String studentcontact, Date issueddate) {
       this.bookcallno = bookcallno;
       this.studentid = studentid;
       this.studentname = studentname;
       this.studentcontact = studentcontact;
       this.issueddate = issueddate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getBookcallno() {
        return this.bookcallno;
    }
    
    public void setBookcallno(String bookcallno) {
        this.bookcallno = bookcallno;
    }
    public int getStudentid() {
        return this.studentid;
    }
    
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    public String getStudentname() {
        return this.studentname;
    }
    
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }
    public String getStudentcontact() {
        return this.studentcontact;
    }
    
    public void setStudentcontact(String studentcontact) {
        this.studentcontact = studentcontact;
    }
    public Date getIssueddate() {
        return this.issueddate;
    }
    
    public void setIssueddate(Date issueddate) {
        this.issueddate = issueddate;
    }




}


