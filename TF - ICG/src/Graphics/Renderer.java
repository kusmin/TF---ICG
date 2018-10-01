package Graphics;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import static com.oracle.jrockit.jfr.DataType.FLOAT;
import java.util.ArrayList;

public class Renderer implements GLEventListener {

    float x = 1, y, z;
    ArrayList<String> vertex;
    ArrayList<String> edge;

    public Renderer(ArrayList<String> vertex, ArrayList<String> edge) {
        this.vertex = vertex;
        this.edge = edge;
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

        
        gl.glRotated(x, 1, 1, 0);
        x++;
        
        for (int i = 0; i < edge.size(); i++){
            
            try{
            //pede a posicao i na lista de aresta
            //retorna 03 vetores com as posicoes dos vertices
            //desenha um triangulo
            drawTriangle(gl, strToInt(edge.get(i)).get(0),
                             strToInt(edge.get(i)).get(1),
                             strToInt(edge.get(i)).get(2));
                    
            }catch(Exception e){System.out.println("Erro ao rasterizar objeto");}
        }

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
    }

    public void drawTriangle(GL2 gl, int posV1, int posV2, int posV3) {

        
        //GL_TRIANGLE_STRIP
        try{
        gl.glBegin(GL.GL_LINE_STRIP);

            gl.glColor3f(0, 0, 255);
            gl.glVertex3f(  strToFloat(vertex.get(posV1 - 1)).get(0),
                            strToFloat(vertex.get(posV1 - 1)).get(1),
                            strToFloat(vertex.get(posV1 - 1)).get(2));

            gl.glColor3f(0, 112, 255);
            gl.glVertex3f(  strToFloat(vertex.get(posV2 - 1)).get(0),
                            strToFloat(vertex.get(posV2 - 1)).get(1),
                            strToFloat(vertex.get(posV2 - 1)).get(2));

            gl.glColor3f(0, 23, 255);
            gl.glVertex3f(  strToFloat(vertex.get(posV3 - 1)).get(0),
                            strToFloat(vertex.get(posV3 - 1)).get(1),
                            strToFloat(vertex.get(posV3 - 1)).get(2));

        gl.glEnd();
        }catch(Exception e){System.err.println("defsdf");}

    }
    
    public ArrayList<Float> strToFloat(String vertice){
        
        String aux[] = vertice.split(" ");
        ArrayList<Float> list = new ArrayList<>();
        
        for (int i = 0; i < aux.length; i++){
            list.add( Float.parseFloat(aux[i]) );
        }
        
        return list;
    }

    public ArrayList<Integer> strToInt(String vertice){
        
        String aux[] = vertice.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < aux.length; i++){
            list.add( Integer.parseInt(aux[i]) );
        }
        
        return list;
    }
   
    
}
