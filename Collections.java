/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg360;

/**
 *
 * @author Melissa Case
 */
import java.util.*;

public class Collections {

    public static void main(String[] args) {

        List animal = new ArrayList();
        animal.add("Gizmo");
        animal.add("Lilly");
        animal.add("Finn");
        System.out.println("List:");
        for (int i = 0; i < animal.size(); i++) {
            System.out.println("\t" + animal.get(i));
        }
        
        LinkedList animalList = new LinkedList(animal);
        animalList.add("Maxwell");
        animalList.add("Wellington");
        Object pet = animalList.get(1);
        Object p = animalList.get(2);
        animalList.set(1, pet + " (passed away)");
        animalList.set(2, p + " (moved to another home)");
        System.out.println();
        System.out.println("Linked List: " +"\t" + animalList);
        

        Set animal1 = new HashSet();
        animal1.add("Bandit");
        animal1.add("Cookie");
        animal1.add("Mahler");
        System.out.println();
        System.out.println("Set");
        System.out.print("\t" + animal1);

        animal1.remove("Mahler");
        System.out.println();
        System.out.println("New Set");
        System.out.println("\t" + animal1);

        Map loc = new HashMap();
        loc.put("Gizmo", "3");
        loc.put("Lilly", "4");
        loc.put("Bandit", "1");
        System.out.println();
        System.out.println("Map");
        System.out.print("\t" + loc);

        TreeSet t = new TreeSet();
        t.add("Brian");
        t.add("Melissa");
        t.add("Matthew");
        t.add("Chloe");
        t.add("Gizmo");
        System.out.println();
        System.out.println("Tree: ");
        System.out.println("\t" + t);

        
        t.add("Lilly");
        Iterator tree;
        tree = t.iterator();
       
        System.out.println();
        System.out.println("Tree: ");
        while (tree.hasNext()) 
            System.out.println(tree.next() + " ");  

    }

}
