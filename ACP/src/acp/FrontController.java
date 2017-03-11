/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acp;

/**
 *
 * @author Melissa Case
 */
public class FrontController {

        
      private dis dis;
      
      public FrontController(){
          dis = new dis();
      }
      
      private boolean isAuthenticated(){
          System.out.println("You are successfully authenticated");
          return true;
      }
      private void trackRequest(String req){
          System.out.println("You have requested " + req);
      }
      public void dispatchRequest(String req) {
          trackRequest(req);
          
          if(isAuthenticated()){
              dis.dispatch(req);
          }
    }
    
}
