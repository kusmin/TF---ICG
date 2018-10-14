package Modelos;

import Loader.Objeto;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Modelo extends Objeto {

    public float rX = 0f, rY = 0f, rZ = 0f, angle = 0f;  //Rotate
    public float tX = 0f, tY = 0f, tZ = 0f;              //Translate
    public float sX = 1f, sY = 1f, sZ = 1f;              //scale

    public Modelo(String address, String name) {
        super(address, name);
    }

    public void settings(float[] rotate, float[] scale, float[] translation) {

        rX = rotate[0];
        rY = rotate[1];
        rZ = rotate[2];

        sX = scale[0];
        sY = scale[1];
        sZ = scale[2];

        tX = translation[0];
        tY = translation[1];
        tZ = translation[2];

    }

    public void drawable(GL2 gl) {

        gl.glPushMatrix();

        gl.glScalef(sX, sY, sZ);
        gl.glTranslatef(tX, tY, tZ);

        gl.glRotatef(rX, 1, 0, 0);  //Rotacao em x
        gl.glRotatef(rY, 0, 1, 0);  //Rotacao em y
        gl.glRotatef(rZ, 0, 0, 1);  //Rotacao em z

        for (int i = 0; i < sizeFaces(); i++) {
            //pede a posicao i na lista de aresta
            //retorna 03 vetores com as posicoes dos vertices
            //desenha um triangulo 

            drawTriangle(gl, getFaceVertex(i)[0], getFaceVertex(i)[1], getFaceVertex(i)[2],
                    getFaceTexture(i)[0], getFaceTexture(i)[1], getFaceTexture(i)[2],
                    getFaceNormalVector(i)[0], getFaceNormalVector(i)[1], getFaceNormalVector(i)[2]);

        }

        gl.glPopMatrix();
    }

    protected void drawTriangle(GL2 gl, int v1, int v2, int v3, int t1, int t2, int t3, int vn1, int vn2, int vn3) {

        try {
            gl.glBegin(GL.GL_TRIANGLES);

            // Front Face.
            gl.glNormal3f(getNormalVector(vn1 - 1)[0], getNormalVector(vn1 - 1)[1], getNormalVector(vn1 - 1)[2]);
            gl.glTexCoord2f(getTexture(t1 - 1)[0], getTexture(t1 - 1)[1]);
            gl.glVertex3f(getVertex(v1 - 1)[0], getVertex(v1 - 1)[1], getVertex(v1 - 1)[2]);

            gl.glNormal3f(getNormalVector(vn2 - 1)[0], getNormalVector(vn2 - 1)[1], getNormalVector(vn2 - 1)[2]);
            gl.glTexCoord2f(getTexture(t2 - 1)[0], getTexture(t2 - 1)[1]);
            gl.glVertex3f(getVertex(v2 - 1)[0], getVertex(v2 - 1)[1], getVertex(v2 - 1)[2]);

            gl.glNormal3f(getNormalVector(vn3 - 1)[0], getNormalVector(vn3 - 1)[1], getNormalVector(vn3 - 1)[2]);
            gl.glTexCoord2f(getTexture(t3 - 1)[0], getTexture(t3 - 1)[1]);
            gl.glVertex3f(getVertex(v3 - 1)[0], getVertex(v3 - 1)[1], getVertex(v3 - 1)[2]);
            gl.glEnd();

        } catch (Exception e) {
            System.err.println("Problema ao desenhar triangulos");
        }

    }

    public void rotate(float x, float y, float z) {

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
