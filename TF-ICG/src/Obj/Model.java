package Obj;

import Loader.Objeto;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Model extends Objeto {

    //Todo modelo eh um objeto
    //Com transformacoes
    
    public Model(String address, String name) {
        super(address, name);
    }

    protected float rX = 0f, rY = 0f, rZ = 0f, angle = 0f;  //Rotate
    protected float tX = 0f, tY = 0f, tZ = 0f;              //Translate
    protected float sX = 1f, sY = 1f, sZ = 1f;              //scale

    public void drawable(GL2 gl) {

        gl.glScalef(sX, sY, sZ);    
        gl.glTranslatef(tX, tY, tZ);
        gl.glRotatef(angle, rX, rY, rZ);
       
        for (int i = 0; i < sizeFaces(); i++) {

            try {
                
                //pede a posicao i na lista de aresta
                //retorna 03 vetores com as posicoes dos vertices
                //desenha um triangulo
                
                drawTriangle(gl, getFaceVertex(i)[0], getFaceVertex(i)[1], getFaceVertex(i)[2]);

            } catch (Exception e) {
                System.out.println("Erro ao rasterizar objeto");
            }
        }
    }

    protected void drawTriangle(GL2 gl, int v1, int v2, int v3) {

        //GL_TRIANGLE_STRIP
        try {
            gl.glBegin(GL.GL_LINE_STRIP);

            gl.glVertex3f(getVertex(v1 - 1)[0], getVertex(v1 - 1)[1], getVertex(v1 - 1)[2]);
            gl.glVertex3f(getVertex(v2 - 1)[0], getVertex(v2 - 1)[1], getVertex(v2 - 1)[2]);
            gl.glVertex3f(getVertex(v3 - 1)[0], getVertex(v3 - 1)[1], getVertex(v3 - 1)[2]);

            gl.glEnd();
        } catch (Exception e) {
            System.err.println("Problema ao desenhar triangulos");
        }

    }

    public void rotate(float angle, float x, float y, float z) {
        this.angle = angle;
        
        rX = x;
        rY = y;
        rZ = z;
    }

    public void scale(float x, float y, float z) {
        sX += x;
        sY += y;
        sZ += z;
    }

    public void translate(float x, float y, float z) {
        
        tX += x;
        tY += y;
        tZ += z;
    }
}
