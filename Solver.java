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
public class Solver implements LabyrinthSolver {
    private Model model;
    private View view;
    
    public Solver(Model m){
        this.model=m;
    }
    @Override
    public void setView(View v){
        this.view=v;
    }
    @Override
    public void nextCellToExplore(int linie,int coloana){
        model.setCurrLocation(linie, coloana);
    }
    @Override
    public void listen(String comanda){
        Locatie aux=new Locatie();
        aux=model.getCurrLocation();
        int a,b;
        a=aux.x;
        b=aux.y;
        switch(comanda){
            case "w":
                this.nextCellToExplore(aux.x-1, aux.y);
                if(a!=model.getCurrLocation().x)
                    model.addStep("UP");
                break;
            case "a":
                this.nextCellToExplore(aux.x, aux.y-1);
                 if(b!=model.getCurrLocation().y)           
                    model.addStep("LEFT");
                break;
            case "s":
                this.nextCellToExplore(aux.x+1, aux.y);
                if(a!=model.getCurrLocation().x)
                    model.addStep("DOWN");
                break;
            case "d":
                this.nextCellToExplore(aux.x, aux.y+1);
                if(b!=model.getCurrLocation().y) 
                    model.addStep("RIGHT");
                break;
            default:
                System.out.println("Comanda incorecta");
                break; 
        }
    }
    
}
