package Control;

import Modelos.Moto;
import Modelos.Veiculo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private static Keyboard keyboard = new Keyboard();

    private Moto moto;

    private Keyboard() {
    }

    public static Keyboard getKeyBoard() {
        return keyboard;
    }

    static float pX, pY, pZ;

    public void setObjeto(Veiculo moto) {
        this.moto = (Moto) moto;
    }

    public static void valores(float px, float py, float pz) {
        Keyboard.pX = px;
        Keyboard.pY = py;
        Keyboard.pZ = pz;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        try {

            switch (ke.getKeyChar()) {
                case 'w':
                    moto.move(new float[]{0, 0.1f, 0});
                    //System.out.println("tY" +moto.tY);
                    break;
                case 's':
                    moto.move(new float[]{0, -0.1f, 0});
                    //System.out.println("tY" + moto.tY);
                    break;
                case 'a':
                    moto.move(new float[]{-0.1f, 0, 0});
                    //System.out.println("tx" +moto.tY);
                    break;
                case 'd':
                    moto.move(new float[]{0.1f, 0, 0});
                   //System.out.println("tx" +moto.tY);
                    break;
                case '+':
                    moto.sX+= 0.5f;
                    moto.sY+= 0.5f;
                    //System.out.println("sX e sY = " + moto.sX + " " + moto.sY);
                    break;

                case '-':
                    moto.sX-= 0.5f;
                    moto.sY-= 0.5f;
                    //System.out.println("sX e sY = " + moto.sX + " " + moto.sY);
                    break;

                case '4':
                    moto.rX-= 0.5f;
                    //System.out.println("rX  = " + moto.rX);
                    break;

                case '6':
                    moto.rX+= 0.5f;
                    //System.out.println("rX  = " + moto.rX);
                    break;
                case '8':
                    moto.rY+= 0.5f;
                   // System.out.println("rY  = " + moto.rY);
                    break;
                case '2':
                    moto.rY-= 0.5f;
                    //System.out.println("rY  = " + moto.rY);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Falha em KeyTyped");
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        try {

            switch (ke.getKeyChar()) {
                case 'w':
                    System.err.println("W pressionado");

                    break;
            }

        } catch (Exception e) {
            System.out.println("Falha em KeyTyped");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        try {

            switch (ke.getKeyChar()) {
                case 'w':
                    System.err.println("W solto");

                    break;
            }

        } catch (Exception e) {
            System.out.println("Falha em KeyTyped");
        }
    }

}
