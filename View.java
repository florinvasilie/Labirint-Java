/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4ex1;

import java.util.Scanner;

/**
 *
 * @author Florin
 */
public class View implements LabyrinthView{
    private Model model;
    private LabyrinthObserver observer;
    private Solver controller;
    
    
    public View(Model m,Solver c, LabyrinthObserver o){
        this.model=m;
        this.controller=c;
        this.observer=o;
    }
    @Override
    public String toString(){
        String mesaj=new String();
        Locatie finish,curr,start=new Locatie();
        finish=model.getFinishCell();
        curr=model.getCurrLocation();
        start=model.getStartCell();    
        boolean sw=false;
        for(int i=0;i<model.getRowCount();i++){
            mesaj+="|";
            for(int j=0;j<model.getColumnCount();j++){
                if(model.isFreeAt(i, j)){
                    if(curr.x==i&&curr.y==j){
                        mesaj+="*|";
                        sw=true;
                    }
                    else
                        mesaj+="0|";
                }
                if(model.isWallAt(i, j))
                    mesaj+="1|";
                if(start.x==i&&start.y==j)
                    if(start.x==curr.x&&start.y==curr.y){
                        mesaj+="*|";
                        sw=true;
                    }
                    else
                        mesaj+="-1|";
                if(finish.x==i&&finish.y==j)
                    if(finish.x==curr.x&&finish.y==curr.y){
                        mesaj+="*|";
                        sw=true;
                    }
                    else
                        mesaj+="2|";
                if(sw==false && curr.x==i && curr.y==j){
                        mesaj+="*|";
                        sw=true;
                }
            }
            mesaj+="\n";
        }
        return mesaj;
    }
    @Override
    public boolean display(){
      //  String fisier="file.ser";
        System.out.println(this.toString());
        System.out.println("Introduceti comenzie W(UP)/A(LEFT)/S(DOWN)/D(RIGHT)/Q(EXIT):");
        Scanner sc=new Scanner(System.in);
        String comanda=new String();
        observer.processCell();
        comanda=sc.nextLine();
        Locatie finish,curr=new Locatie();
        finish=model.getFinishCell();
        curr=model.getCurrLocation();
        
        if(comanda.equals("q"))
            return false;
        else{
            controller.listen(comanda);
            if(finish.x==curr.x && finish.y==curr.y){
                System.out.println("Felicitari!\nAti castigat jocul! :)");
                System.out.println("Solutia castigatoare este:");
                observer.processSolution();
                model.printSolution();
                return false;
                
            }
            else
                observer.showPartialSolution();
                return true;
        }
    }
     
}
