package Keyboard;

import Obj.Moto;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    Moto obj;

    public Keyboard(Moto obj) {
        this.obj = obj;
    }

    public void keyTyped(KeyEvent ke) {
        try {

            switch (ke.getKeyChar()) {
                case 'w':
                    obj.translate(0.0f, 0.1f, 0);
                    break;

                case 's':
                    obj.translate(0.0f, -0.1f, 0);
                    break;

                case 'a':
                    obj.direita();
                    break;

                case 'd':
                    obj.esquerda();
                    break;

                case '+':
                    obj.scale(0.001f, 0.001f, 0.001f);
                    break;

                case '-':
                    obj.scale(-0.001f, -0.001f, -0.001f);
                    break;

                case '6':
                    obj.rotate(-1f, 0, 1, 0, true);
                    break;

                case '4':
                    obj.rotate(1f, 0, 1, 0, true);
                    
                    break;
                    
                case '8':
                    obj.rotate(-1f, 1, 0, 0, true);
                    break;

                case '2':
                    obj.rotate(1f, 1, 0, 0, true);

                case '9':
                    obj.rotate(-1f, 0, 0, 1, true);
                    break;

                case '3':
                    obj.rotate(1f, 0, 0, 1, true);

                    break;
            }

        } catch (Exception e) {
            System.out.println("Falha em KeyTyped");
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        try {

        } catch (Exception e) {
            System.out.println("Falha em KeyTyped");
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        try {

            switch (ke.getKeyChar()) {

                case 'a':
                    obj.rotate(0f, 0, 0, 1);
                    break;

                case 'd':
                    obj.rotate(0f, 0, 0, 1);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Falha em KeyTyped");
        }
    }

}
