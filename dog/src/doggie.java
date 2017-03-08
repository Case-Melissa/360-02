/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dog.Dog;
import static java.time.Clock.system;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Melissa Case
 */
public class doggie {

    private static void main(String[] args) {
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
        HibernateUtil.getSessionFactory().close();
    }
    
    public static void listDogs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        
        try {
            tr = session.beginTransaction();
            List dog = session.createQuery("FROM dog").list();
            System.out.println("dogId\tDogName");
            System.out.println("************************************");
            for (Iterator iterator = dog.iterator(); iterator.hasNext();){
                Dog dog = (dog)iterator.next();
                System.out.println(dog.getdogId() + "\t" + dog.getName());
            }
            tr.commit();
        } catch (Throwable ex) {
            if(tr!=null) tr.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
        }
    }
    private static Dog getDog(Integer dogId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        Dog dog = null;
        
        try {
            tr = session.beginTransaction();
            dog = (Dog)session.get(Dog.class, dogId);
            tr.commit();
        } catch(HibernateException ex) {
            if(tr!=null) tr.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return dog;
    }
    private static Dog detailDog(Integer dogId) {
        Dog dog = getDog(dogId);
        System.out.println("ID: "+ dog.getdogId());
        System.out.println("Name: " + dog.getName());
        System.out.println("Breed: " + dog.getBreed());
        System.out.println("Age: " + dog.getAge());
    }
    
    private static Integer addDog(String name, String breed, String age){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        Integer dogId = null;
        
        try{
            tr = session.beginTransaction();
            Dog dog = new Dog(name, breed, age);
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        Dog dog = getDog(dogId);
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        Dog dog = getDog(dogId);
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
 
    }

