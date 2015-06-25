/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4ex1;

/**
 *
 * @author Florin
 */
public class Lab4Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LabyrinthModel model=new Model();
        LabyrinthSolver controller=new Solver((Model) model);
        LabyrinthObserver observer=new Observer(model);
        LabyrinthView view=new View((Model)model,(Solver)controller,observer);
        model.readFromFile();
        //model.randomLabyrinth();
        controller.setView((View) view);
        while(view.display()){
        
        }
    }
    
}
