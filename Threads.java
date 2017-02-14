/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcase
 */
public class Threads implements Runnable {
    Thread trd;
    
    Threads (String s){
        trd = new Thread(this, s);
        trd.start();
    }
    @Override
    public void run(){
        System.out.println(trd.getName() + " beginning.");
        try {
            for(int a=0; a < 12; a++){
                Thread.sleep(600);
                System.out.println("In " +trd.getName() + ", count is " + a);
            }
        }
        catch(InterrputedException e) {
            System.out.println(trd.getName() + "disturbed.");
        }
        System.out.println(trd.getName() + " ending.");
    }
}
class AnotherThread {
    public static void main(String args[]){
        System.out.println("Main thread is beginning.");
        
        Threads t1 = new Threads("Son");
        Threads t2 = new Threads ("Daughter");
        
        for(int b=0; b < 60; b++){
            System.out.print(".");
            try{
                Thread.sleep(150);
            }
            catch(InterruptedException e) {
                System.out.println("Main thread was interrupted.");
            }
        }
        System.out.println("Main thread is now ending.");
    }
}
