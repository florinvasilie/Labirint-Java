/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Florin
 */
public class Model implements LabyrinthModel,Serializable {
    private int[][] matrice;
    private List<String> solutie;
    private int nrLinii;
    private int nrColoane;
    private Locatie locatieCurr;
    
    public Model(int nrLinii,int nrColoane,int[][] matrice){
        this.matrice=new int[100][100];
        this.nrLinii=nrLinii;
        this.nrColoane=nrColoane;
        for(int i=0;i<nrLinii;i++)
            for(int j=0;j<nrColoane;j++)
                this.matrice[i][j]=matrice[i][j];
        this.locatieCurr=getStartCell();
        this.solutie=new ArrayList<>();
    }
    public Model(){
        this.matrice=new int[100][100];
        this.solutie=new ArrayList<>();
    }
    
    @Override
    public int getRowCount(){
        return this.nrLinii;
    }
    @Override
    public int getColumnCount(){
        return this.nrColoane;
    }
    @Override
    public boolean isFreeAt(int linie,int coloana){
        return this.matrice[linie][coloana]==0;
    }
    @Override
    public boolean isWallAt(int linie,int coloana){
        return this.matrice[linie][coloana]==1;
    }
    @Override
    public Locatie getStartCell(){
        Locatie l=new Locatie();
        
        for(int i=0;i<this.nrLinii;i++)
            for(int j=0;j<this.nrColoane;j++)
                if(this.matrice[i][j]==-1){
                  l.x=i;
                  l.y=j;
                 }
        return l;
      
    }
    
    @Override
    public Locatie getFinishCell(){
        Locatie l=new Locatie();
        for(int i=0;i<this.nrLinii;i++)
            for(int j=0;j<this.nrColoane;j++)
                if(matrice[i][j]==2){
                  l.x=i;
                  l.y=j;
                 }
       return l; 
    }
    @Override
     public void addStep(String comanda){
         this.solutie.add(comanda);
    }
    @Override
    public void printSolution(){
        for(String s:solutie)
            System.out.printf("%s->",s);
        System.out.println();
    }
    @Override
    public void readFromFile(){
        try {
            FileReader fd=new FileReader("Lab.txt");
            BufferedReader rd=new BufferedReader(fd);
            this.nrLinii=Integer.parseInt(rd.readLine());
            this.nrColoane=Integer.parseInt(rd.readLine());
             for(int i=0;i<this.nrLinii;i++)
                for(int j=0;j<this.nrColoane;j++)
                    this.matrice[i][j]=Integer.parseInt(rd.readLine());
             this.locatieCurr=this.getStartCell();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @Override
    public void randomLabyrinth(){
        Random rand=new Random();
        int x,y;
        this.nrLinii=5;
        this.nrColoane=5;
        for(int i=0;i<this.nrLinii;i++)
            for(int j=0;j<this.nrColoane;j++)
                this.matrice[i][j]=-7;
        this.matrice[rand.nextInt(5)][rand.nextInt(5)]=-1;
        do{
           x=rand.nextInt(5);
           y=rand.nextInt(5);
          if(this.matrice[x][y]!=-1)
              this.matrice[x][y]=2;
        }while(matrice[x][y]==-1);
        
        for(int i=0;i<this.nrLinii;i++)
            for(int j=0;j<this.nrColoane;j++)
                if(matrice[i][j]==-7){
                    matrice[i][j]=rand.nextInt(2);
                }
        this.locatieCurr=this.getStartCell();
    }
    @Override
    public int[][] getMatrix(){
        return this.matrice;
    } 
    
    @Override
    public Locatie getCurrLocation(){
        return this.locatieCurr;
    }
    @Override
    public void setCurrLocation(int linie,int coloana){
        if(linie<0 || linie >=this.nrLinii || coloana<0 || coloana>=this.nrColoane || this.isWallAt(linie, coloana)){
            System.out.println("Nu se poate executa miscarea");
        }
        else{
            this.locatieCurr.x=linie;
            this.locatieCurr.y=coloana;
        }
    }
    @Override
      public String getFinalSolution(){
          StringBuilder sol=new StringBuilder();
          for(String s:solutie)
              sol.append(s).append("->");
          
        return sol.toString();
      }
    
}
