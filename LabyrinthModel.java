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
public interface LabyrinthModel {
    int getRowCount();
    int getColumnCount();
    boolean isFreeAt(int linie,int coloana);
    boolean isWallAt(int linie,int coloana);
    void addStep(String comanda);
    void printSolution();
    String getFinalSolution();
    Locatie getStartCell();
    Locatie getFinishCell();
    void readFromFile();
    void randomLabyrinth();
    int[][] getMatrix();
    Locatie getCurrLocation();
    void setCurrLocation(int linie,int coloana);
}
