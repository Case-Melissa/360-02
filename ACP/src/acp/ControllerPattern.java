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
public class ControllerPattern {
    public static void main(String[] args){
        FrontController fController = new FrontController();
        fController.dispatchRequest("Dogs");
        fController.dispatchRequest("Puppy");
    }
    
}
