
import Graphics.Renderer;
import Graphics.Window;
import Keyboard.Keyboard;
import Loader.Loader;
import Obj.*;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class Principal {

    static int whidth = 1024, height = 768;
    
    public static void main(String[] args) throws InterruptedException {

        Keyboard keyboard;

        final GLProfile profile = GLProfile.get(GLProfile.GL2);

        GLCapabilities capabilities = new GLCapabilities(profile);
        capabilities.setDoubleBuffered(true);
        capabilities.setHardwareAccelerated(true);

        GLCanvas canvas = new GLCanvas(capabilities);
        FPSAnimator animator = new FPSAnimator(canvas, 60);

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

        ArrayList<Moto> lista = new ArrayList<>();

        //Cria os objetos que serao renderizos
        
        Moto harley = new Moto("src/Files/", "harley"); //Principal
        Moto vespa = new Moto("src/Files/", "vespa");
        Moto vespa2 = new Moto("src/Files/", "vespa");
        Moto vespa3 = new Moto("src/Files/", "vespa");

        //Carrega os vertices e faces
        loader.loader(harley);
        loader.loader(vespa);

        //Inicializando atributos
        harley.init(new float[]{0,0,0,0}, new float[]{0.3f,0.3f,1f}, new float[]{-0.1f,-3.30f,0f});
        vespa.init(new float[]{89,0,1,0}, new float[]{0.2f,0.2f,0.2f}, new float[]{-0.8f, -0.90f, 0f});
        vespa2.init(new float[]{89,0,1,0}, new float[]{0.2f,0.2f,0.2f}, new float[]{0.2f, -0f, 0f});
        
        lista.add(harley);
        lista.add(vespa);
        lista.add(vespa2);
        lista.add(vespa3);

        //Indica qual o objeto que terah interacao com o teclado
        keyboard = new Keyboard(harley);

        //Envia os objetos para renderizacao
        renderer.Render(lista);

        Window window = new Window("OpenGL", animator, whidth, height, keyboard);

        canvas.addGLEventListener(renderer);

        window.setGLCanvas(canvas, BorderLayout.CENTER);
        animator.start();

        window.setVisibility(true);

    }

}
