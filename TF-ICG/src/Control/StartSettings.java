package Control;

import Control.Keyboard;
import com.jogamp.opengl.glu.GLU;

public class StartSettings {

        //Esta classe vai tratar as variaives globais
    protected GLU glu;
    protected float width = 0, height = 0;
    protected float distance = 5;

    protected Keyboard key;

    protected static float px = 0;
    protected static float py = 0;
    protected static float pz = 0;

    
    public StartSettings() {
        key = Keyboard.getKeyBoard();
        usaTeclado();
    }


    private void usaTeclado() {
        Keyboard.valores(px, py, pz);
    }

}
