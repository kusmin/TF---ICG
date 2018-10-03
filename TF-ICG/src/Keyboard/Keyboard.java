/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Keyboard;

import java.util.Scanner;

/**
 *
 * @author Diego Felipe
 */
public class Keyboard implements Runnable{

    char tecla;
    
    public Keyboard(char tecla){
        this.tecla = tecla;
    }
    
    @Override
    public void run() {
        
        Scanner in = new Scanner (System.in);
        in.next();
        
        switch(tecla){
            
            case 'w':
            
            
        }
        
        
    }
    
}
