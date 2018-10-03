
import Graphics.Renderer;
import Graphics.Window;
import Loader.Loader;
import Loader.Obj;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
       final GLProfile profile = GLProfile.get(GLProfile.GL2);
       
        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDoubleBuffered(true);
        capabilities.setHardwareAccelerated(true);
        
        GLCanvas canvas = new GLCanvas(capabilities);
        FPSAnimator animator = new FPSAnimator(canvas, 60);
        
        
        
        Obj monkey = new Obj("src/Objetos/", "monkey");
        Obj tree = new Obj("src/Objetos/", "moto");
    
        Loader loader = new Loader();
        loader.loader(tree);
     
        Renderer renderer = new Renderer(tree);
        
        Window window = new Window("OpenGL", animator, 1333, 796);
        
        canvas.addGLEventListener(renderer);
        
        window.setGLCanvas(canvas, BorderLayout.CENTER);
        animator.start();
        
        window.setVisibility(true);
        
        
        
    }
    
}
