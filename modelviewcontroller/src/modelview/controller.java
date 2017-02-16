/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelview;

/**
 *
 * @author mcase
 */
public class controller {
    private mod model;
    private view view;
    
    public controller(mod model, view view){
        this.model = model;
        this.view = view;
    }
    public void setFirstName (String fname){
        model.setName(fname);
    }
    public String getFirstName(){
        return model.getName();
    }
    public void setINumber(String iNumber){
        model.getINumber();
    }
    public String getINumber(){
        return model.getINumber();
    }
    public void updateView(){
        view.printStudentInfo(model.getName(), model.getINumber());
    }

}