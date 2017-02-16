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
public class mvctest {
    public static void main(String[] args){
        mod model = retrieveStudentFromData();
        view view = new view();
        controller controller = new controller(model, view);
        controller.updateView();
        
        controller.setFirstName("Bob");
        controller.updateView();
    }
    private static mod retrieveStudentFromData(){
        mod student = new mod();
        student.setName("Melissa");
        student.setINumber("12-234-5678");
        return student;
    }
}
