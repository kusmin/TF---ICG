package Graphics;

import Control.StartSettings;
import Modelos.Moto;
import Modelos.ObjFactory;
import Modelos.Veiculo;
import com.jogamp.opengl.*;
import static com.jogamp.opengl.GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.*;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.*;
import com.jogamp.opengl.glu.GLU;

public class Renderer extends StartSettings implements GLEventListener {

    int x = 100;

    ObjFactory objFactory = new ObjFactory();

    Moto harley;
    Veiculo bus;

    public Renderer() {
        super();
    }

    @Override
    public void init(GLAutoDrawable drawable) {

        final GL2 gl = drawable.getGL().getGL2();
        glu = new GLU();

        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        gl.glShadeModel(GL_SMOOTH);
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        gl.glClearColor(0f, 0f, 1f, 1f);

        harley = objFactory.getMoto("src/Files/Harley-Davidson/", "Harley-Davidson", "bike_d.tga", new float[]{0, 180, 0}, new float[]{1, 1, 1}, new float[]{0, -3, 0});
        objFactory.getTexture(gl, harley);

        bus = objFactory.getMoto("src/Files/Bus/", "bus", "bus.jpg", new float[]{0, 148.5f, 0}, new float[]{3, 3, 1}, new float[]{-1f, -0.6f, 0});
        objFactory.getTexture(gl, bus);

        key.setObjeto(harley);

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        setCamera(gl, glu, 10);

        //Propriedades do material
        float[] rgba = {1f, 1f, 1f, 1f};

        x++;

        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glMaterialfv(GL.GL_FRONT, GL_AMBIENT, rgba, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL_SPECULAR, rgba, 0);
        gl.glMaterialf(GL.GL_FRONT, GL_SHININESS, 0.5f);
        
        
        light(gl);
        
        
        bus.getTexture().enable(gl);
        bus.getTexture().bind(gl);
        bus.drawable(gl);
        //bus.getTexture().disable(gl);

        gl.glPushMatrix();

        harley.getTexture().enable(gl);
        harley.getTexture().bind(gl);
        harley.drawable(gl);
        harley.getTexture().disable(gl);

        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, width, height);

    }

    public void setCamera(GL2 gl, GLU glu, float distance) {

        try {
            GL2 gl2 = gl.getGL2();

            float angle = 45;

            float position[] = {px, py, distance};               //  Posicao do observador
            float lookAt[] = {0.0f, 0.0f, 0.0f};                 //  Ponto para onde a camera esta olhando.
            float up[] = {0.0f, 1.0f, 0.0f};                     //  'up' da camera no espaco do universo.

            // Change to projection matrix.
            gl2.glMatrixMode(GL_PROJECTION);
            gl2.glLoadIdentity();

            // Perspective.
            float widthHeightRatio = (float) width / (float) height;
            glu.gluPerspective(angle, widthHeightRatio, 1, 1000);
            glu.gluLookAt(position[0], position[1], position[2], lookAt[0], lookAt[1], lookAt[2], up[0], up[1], up[2]);

            // Change back to model view matrix.
            gl2.glMatrixMode(GL_MODELVIEW);
            gl2.glLoadIdentity();

        } catch (Exception e) {
            System.err.println("Problemas com a camera");
        }

    }

    public void setWindow(float width, float height) {
        this.width = width;
        this.height = height;
    }

    private void light(GL2 gl) {
        try {

            // Definindo iluminaacao
            float direction = 1;                                //iluminacao em todas as direcoes
            float[] lightPos = {-30, 0, 0, direction};          //posicao da fonte de luz
            float[] lightAmbient = {0.2f, 0.8f, 0.8f, 1};       //Iluminacao ambiente
            float[] lightSpecular = {0.8f, 0.8f, 0.8f, 1f};     //Iluminacao Especular

            //parametros de iluminacao
            gl.glLightfv(GL_LIGHT1, GL_POSITION, lightPos, 0);
            gl.glLightfv(GL_LIGHT1, GL_AMBIENT, lightAmbient, 0);
            gl.glLightfv(GL_LIGHT1, GL_SPECULAR, lightSpecular, 0);

            //Habilita iluminacao
            gl.glEnable(GL_LIGHT1);
            gl.glEnable(GL_LIGHTING);

        } catch (Exception e) {
            System.err.println("Problemas com a iluminacao");
        }
    }

}
