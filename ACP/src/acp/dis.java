package acp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melissa Case
 */
public class dis {
    
    private DogView dogView;
    private PuppyView puppyView;
    
    public dis(){
        dogView = new DogView();
        puppyView = new PuppyView();
    }
    
    public void dis(String req){
        if (req.equalsIgnoreCase("DOG")){
            dogView.show();
        }else {
            puppyView.show();
        }
    }

    void dispatch(String req) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
