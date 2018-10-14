
package Modelos;

public class Veiculo  extends Modelo{

    public Veiculo(String address, String name) {
        super(address, name);
    }

    public void direita(float[] translation){
        tX += translation[0];
        tY += translation[1];
        tZ += translation[2];
    }
    public void esquerda(float[] translation){
        tX += translation[0];
        tY += translation[1];
        tZ += translation[2];
    }
    public void frente(){
        
    }
    public void para(){
        
    }    
    
    
}
