/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Florin
 */
public class Observer implements LabyrinthObserver {
    private LabyrinthModel model;
    private List<String> solutii;
    
    public Observer(LabyrinthModel model){
        this.model=model;
        solutii=new ArrayList<>();
    }
    @Override
    public void processCell(){
        Locatie loc=new Locatie();
        loc=model.getCurrLocation();
        if(loc.x!=0)
            if(model.isFreeAt(loc.x-1, loc.y))
                System.out.println("Se poate efectua miscarea \"UP\"");
        if(loc.x!=model.getRowCount()-1)
            if(model.isFreeAt(loc.x+1, loc.y))
                System.out.println("Se poate efectua miscarea \"DOWN\"");
        if(loc.y!=0)
             if(model.isFreeAt(loc.x, loc.y-1))
                System.out.println("Se poate efectua miscarea \"LEFT\"");
        if(loc.y!=model.getColumnCount()-1)
              if(model.isFreeAt(loc.x, loc.y+1))
                System.out.println("Se poate efectua miscarea \"RIGHT\"");
        
    }
    @Override
    public void processSolution(){
        solutii.add(model.getFinalSolution());
        Collections.sort(solutii, new MyComparator());
    }
    @Override
    public void showPartialSolution(){
        System.out.println("Solutia partiala este:");
        model.printSolution();
    }
    
    @Override
    public void saveCurrState(Object obj, String fileName)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
 
        fos.close();
    }
    @Override
    public Object loadCurrState(String fileName) throws IOException,
            ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
    
}
