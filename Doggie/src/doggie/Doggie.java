/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doggie;
import static dog.util.HibernateUtil.getSessionFactory;
import static java.time.Clock.system;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author Melissa Case
 */
public class Doggie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        
        Scanner input = new Scanner(System.in);
        
        String dogList = "\n"
                + "\n***********************************"
                + "\n       Dog List                    "
                + "\n***********************************"
                + "\n1 - List Dogs"
                + "\n2 - Show Dog details (required dogId)"
                + "\n3 - Add a Dog"
                + "\n4 - Update a Dog (requires a dogId)"
                + "\n5 - Delete a Dog (requires a dogId)"
                + "\nE - Exit"
                + "\n************************************"
                + "\n"
                + "\nChoose a menu item: ";
        
        boolean finished = false;
        char choice;
        String dogId = null;
        
        while(!finished){
            System.out.print(dogList);
            choice = input.nextLine().charAt(0);
            
            switch(choice) {
                case '1':
                    listDogs();
                    break;
                case '2':
                    System.out.print("\nEnter an Id to show details: ");
                    dogId = input.nextLine();
                    detailDog(Integer.parseInt(dogId));
                    break;
                case '3':
                    System.out.print("\nEnter a name: ");
                    String name = input.nextLine();
                    System.out.print("Enter a breed: ");
                    String breed = input.nextLine();
                    System.out.print("Enter an age: ");
                    String age = input.nextLine();
                    Integer newId = addDog(name, breed, age);
                    System.out.print("\n" + name + " was added as ID " + newId.toString());
                    break;
                case '4':
                    System.out.print("\nEnter an Id to update a dog: ");
                    dogId = input.nextLine();
                    System.out.print("Enter a field to update: ");
                    String field = input.nextLine();
                    System.out.print("Enter a replacement value: ");
                    String value = input.nextLine();
                    updateDog(Integer.parseInt(dogId), field.toLowerCase(), value);
                    break;
                case '5': 
                    System.out.print("\nEnter an Id to delete: ");
                    dogId = input.nextLine();
                    deleteDog(Integer.parseInt(dogId));
                    break;
                case 'E':
                    finished = true;
                    break;
                default:
                    System.out.print("/nInvalide choice: Please try again");
                    break;
            }
            
        }
       
    }
    
    /**
     *
     */
    public static void listDogs() {
        Session session = dog.util.HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        
        try {
            tr = session.beginTransaction();
            tr.commit();
        } catch (Throwable ex) {
            if(tr!=null) tr.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
    private static Dogs getDog(Integer dogId){
        Session session = getSessionFactory().openSession();
        Transaction tr = null;
        Dogs dog = null;
        
        try {
            tr = session.beginTransaction();
            dog = (Dogs)session.get(Dogs.class, dogId);
            tr.commit();
        } catch(HibernateException ex) {
            if(tr!=null) tr.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return dog;
    }
    private static Dogs detailDog(Integer dogId) {
        Dogs dog = getDog(dogId);
        System.out.println("ID: "+ dog.getId());
        System.out.println("Name: " + dog.getName());
        System.out.println("Breed: " + dog.getBreed());
        System.out.println("Age: " + dog.getAge());
        return dog;
    }
    
    private static Integer addDog(String name, String breed, String age){
        Session session = getSessionFactory().openSession();
        Transaction tr = null;
        Integer dogId = null;
        
        try{
            tr = session.beginTransaction();
            Dogs dog = new Dogs(name, breed, age);
            dogId = (Integer) session.save(dog);
            tr.commit();
        }catch (HibernateException ex){
            if(tr!=null) tr.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return dogId;
    }
    private static void updateDog(Integer dogId, String field, String value){
        Session session = getSessionFactory().openSession();
        Transaction tr = null;
        Dogs dog = getDog(dogId);
        switch(field){
            case "name" :
                dog.setName(value);
                break;
            case "breed" :
                dog.setBreed(value);
                break;
            case "age" :
                dog.setAge(value);
                break;
        }
        try {
            tr = session.beginTransaction();
            session.update(dog);
            tr.commit();
        }catch (HibernateException ex){
            if (tr!=null) tr.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
    private static void deleteDog(Integer dogId) {
        Session session = getSessionFactory().openSession();
        Transaction tr = null;
        Dogs dog = getDog(dogId);
 try{
     tr = session.beginTransaction();
     session.delete(dog);
     tr.commit();
 } catch (HibernateException ex){
     if(tr!=null) tr.rollback();
     ex.printStackTrace();
 }finally{
     session.close();
 }
    }

    private static String getdogId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    }

    
    

