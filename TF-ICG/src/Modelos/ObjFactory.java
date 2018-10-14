/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Loader.Loader;
import Loader.Objeto;
import com.jogamp.opengl.GL2;

public class ObjFactory {
    
    Loader loader;
    
    public ObjFactory() {
        loader = Loader.getLoader();
    }

    public Moto getMoto(String address, String name, String nameTexture, float[] rotate, float[] scale, float[] translation){
        
        Moto moto = new Moto(address, name);
        moto.setNameTexture(nameTexture);
        moto.settings(rotate, scale, translation);
        loader.loader(moto);
        
        return (Moto) moto;
    }
    
    public void getTexture(GL2 gl, Objeto obj){
        loader.loaderTexture(gl, obj);
    }

    
    
}
