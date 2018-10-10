package Graphics;

import Keyboard.Keyboard;
import Obj.Model;
import Obj.Moto;

import com.jogamp.opengl.*;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;
import com.jogamp.opengl.glu.GLU;
import java.util.ArrayList;

public class Renderer implements GLEventListener {

    float x = 1f, y = 1f, z = 1f;
    Keyboard keyboard;
    Model obj;
    ArrayList<Moto> lista;

    private GLU glu;
    
    
    public void Render(ArrayList<Moto> lista) {
        this.lista = lista;
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        
        glu = GLU.createGLU(gl);
        gl.glClearColor(90.0f, 255.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);

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

        x += 0.09;
        y += 0.09;
        z += 0.09;

        gl.glPushMatrix();
        lista.get(0).drawable(gl);
        gl.glPopMatrix();

        for (int i = 1; i < lista.size(); i++) {

            gl.glPushMatrix();
            gl.glScalef(x, x, x);
            lista.get(i).drawable(gl);
            gl.glPopMatrix();
            gl.glScalef(1/x, 1/x, 1/x);
            
        }

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        
        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();
        
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity();
        
        
        
    }

}
