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
public interface LabyrinthSolver {
    void setView(View v);
    void nextCellToExplore(int linie,int coloana);
    void listen(String comanda);
    
    
}
