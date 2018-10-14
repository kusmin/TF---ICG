/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import Control.Keyboard;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    private JPanel mainPanel;
    
    private static Keyboard key;
    
    public Window(String title, FPSAnimator animator, int width, int heigth) {

        super(title);
        
        setupWindow(animator, width, heigth);
        mainPanel = new JPanel(new BorderLayout());
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        key = Keyboard.getKeyBoard();
        addKeyListener(key);
    }

    private void setupWindow(final FPSAnimator animator, int width, int heigth) {

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(width, heigth));
        this.setLocationRelativeTo(null);

        this.addWindowFocusListener(new WindowAdapter() {
        
            @Override
            public void windowClosed(WindowEvent e){
                
                if(animator.isStarted())
                {
                    System.out.println("Stop Animator");
                    animator.stop();
                    System.out.println("FPSAnimator closing...");
                }
                
                System.out.println("Closing window...");
                System.exit(0);
            }
        });

    }
    
    public void setVisibility(boolean isVisible){
        this.setVisible(isVisible);
    }
    
    public void setGLCanvas(GLCanvas canvas, String position){
        mainPanel.add(canvas, position);
    }

}
