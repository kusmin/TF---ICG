package Graphics;

import Loader.Obj;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import java.util.ArrayList;

public class Renderer implements GLEventListener {

    float x = 1, y, z = 10;
    // ArrayList<String> vertex;
    // ArrayList<String> edge;
    Obj obj;

    public Renderer(Obj objeto) {
        this.obj = objeto;

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        z -= 0.1;
        gl.glTranslated(0, -0.5, 0);
         gl.glScalef( 0.4f, 0.4f,1);

        for (int i = 0; i < obj.edge.size(); i++) {

            try {
                //pede a posicao i na lista de aresta
                //retorna 03 vetores com as posicoes dos vertices
                //desenha um triangulo

                drawTriangle(gl,obj.edge.get(i).faceVertex[0],
                                obj.edge.get(i).faceVertex[1],
                                obj.edge.get(i).faceVertex[2]);

            } catch (Exception e) {
                System.out.println("Erro ao rasterizar objeto");
            }
        }

                // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
    }

    public void drawTriangle(GL2 gl, int v1, int v2, int v3) {

        //GL_TRIANGLE_STRIP
        try {
            gl.glBegin(GL.GL_LINE_STRIP);

            gl.glVertex3f(  obj.vertex.get(v1 - 1).vertex3f[0],
                            obj.vertex.get(v1 - 1).vertex3f[1],
                            obj.vertex.get(v1 - 1).vertex3f[2]);

            gl.glColor3f(100, 0, 76);
            gl.glVertex3f(  obj.vertex.get(v2 - 1).vertex3f[0],
                            obj.vertex.get(v2 - 1).vertex3f[1],
                            obj.vertex.get(v2 - 1).vertex3f[2]);

            gl.glColor3f(0, 112, 255);
            gl.glVertex3f(  obj.vertex.get(v3 - 1).vertex3f[0],
                            obj.vertex.get(v3 - 1).vertex3f[1],
                            obj.vertex.get(v3 - 1).vertex3f[2]);

            gl.glEnd();
        } catch (Exception e) {
            //System.err.println("Problema ao desenhar triangulos");
        }

    }


}
