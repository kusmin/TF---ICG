package Obj;

import com.jogamp.opengl.GL2;

public class Moto extends Veiculo {

    public Moto(String address, String name) {
        super(address, name);
        init();
    }

    public void init(float[] rotate, float[] scale, float[] translation) {

        //Rotate
        this.angle = rotate[0];
        this.rX = rotate[1];
        this.rY = rotate[2];
        this.rZ = rotate[3];
        
        //Translate
        this.tX = translation[0];
        this.tY = translation[1];
        this.tZ = translation[2];

        //scale
        this.sX = scale[0];
        this.sY = scale[1];
        this.sZ = scale[2];
    }
    
    private void init(){
        //Rotate
        this.angle = 0;
        this.rX = 0;
        this.rY = 0;
        this.rZ = 0;
        
        //Translate
        this.tX = 0;
        this.tY = 0;
        this.tZ = 0;

        //scale
        this.sX = 1;
        this.sY = 1;
        this.sZ = 1;
    }

    @Override
    public void drawable(GL2 gl) {

        gl.glScalef(sX, sY, sZ);
        gl.glTranslatef(tX, tY, tZ);
        gl.glRotatef(angle, rX, rY, rZ);
        gl.glRotatef(-5, 1, 0, 0);

        for (int i = 0; i < sizeFaces(); i++) {

            try {

                drawTriangle(gl, getFaceVertex(i)[0], getFaceVertex(i)[1], getFaceVertex(i)[2]);

            } catch (Exception e) {
                System.out.println("Erro ao rasterizar objeto");
            }
        }
    }

    @Override
    public void direita(){
        rotate(5, 0f, 0f, 1f);
        translate(-0.1f, 0f, 0f);
    }
    
    @Override
    public void esquerda(){
        rotate(-5, 0f, 0f, 1f);
        translate(0.1f, 0f, 0f);
    }
        
    public void empina(){
        rotate(15, 1, 0,0);
    }
    
    public void desempina(){
        rotate (-15,1,0,0);
    }
    
    public void rotate(float angle, float x, float y, float z, boolean a ){
        this.angle += angle;
        this.rX = x;
        this.rY = y;
        this.rZ = z;
        
        System.out.println(this.angle);
        System.out.println(tX + " " + tY + " " + tZ);
        System.out.println(sX + " " + sY + " " + sZ);
    }
}
