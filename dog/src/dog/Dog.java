/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dog;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Melissa Case
 */

@Entity
@Table(name="dogs", catalog="mysql")

public class Dog implements java.io.Serializable{

 private Integer dogId;
 private String name;
 private String breed;
 private Integer age;
 
public Dog(){

}
    public Dog(String name, String breed, Integer age){
    this.name = name;
    this.breed = breed;
    this.age = age;
}

    public Dog(String name, String breed, String age) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getdogId(){
        return this.dogId;
    }
    public void setdogId(Integer id){
        this.dogId = dogId;
    }
    @Column(name="name", nullable=false, length=30)
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Column(name="breed", nullable=false, length=30)
    public String getBreed(){
        return this.breed;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }
    @Column(name="age", nullable=false, length=30)
    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    @Id
    public Integer getDogId() {
        return dogId;
    }

    public void setDogId(Integer dogId) {
        this.dogId = dogId;
    }

    public void getAge(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setAge(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
