/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4ex1;

import java.util.Comparator;

/**
 *
 * @author Florin
 */
public class MyComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        return s1.length()-s2.length();
    }
    
}
