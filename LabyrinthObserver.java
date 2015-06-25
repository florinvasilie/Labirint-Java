/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4ex1;

import java.io.IOException;

/**
 *
 * @author Florin
 */
public interface LabyrinthObserver {
    void processCell();
    void processSolution();
    void showPartialSolution();
    void saveCurrState(Object obj, String fileName)throws IOException;
    Object loadCurrState(String fileName)throws IOException,ClassNotFoundException;    
    
}
