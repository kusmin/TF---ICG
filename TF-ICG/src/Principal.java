
import Control.Keyboard;
import Graphics.Renderer;
import Graphics.Window;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;

public class Principal {

    static int width = 1024, height = 768;
    static int fps = 60;

    public static void main(String[] args) throws InterruptedException {

        GLCapabilities capabilities = criaCapabilities();
        GLCanvas canvas = new GLCanvas(capabilities);
        FPSAnimator animator = new FPSAnimator(canvas, fps);
    
    
    Window window = new Window("Traffic Chaos", animator, width, height);

    Renderer renderer = new Renderer();

    renderer.setWindow (width, height);

    canvas.addGLEventListener (renderer);

    window.setGLCanvas (canvas, BorderLayout.CENTER);

    animator.start ();

    window.setVisibility (

true);

    }

    public static GLCapabilities criaCapabilities() {

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        capabilities.setDoubleBuffered(true);
        capabilities.setHardwareAccelerated(true);

        capabilities.setRedBits(8);
        capabilities.setBlueBits(8);
        capabilities.setGreenBits(8);
        capabilities.setAlphaBits(8);

        return capabilities;
    }

}
