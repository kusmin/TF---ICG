/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Diego Felipe
 */
public class Moto extends Veiculo {

    public Moto(String address, String name) {
        super(address, name);
    }

    public void move(float [] tanslation) {
        tX += tanslation[0];
        tY += tanslation[1];
        tZ += tanslation[2];
    }

}
