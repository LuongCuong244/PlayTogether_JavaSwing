/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author ADMIN
 */
public class JFrameMenu extends JFrame implements KeyListener{

    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 500;
    private jPanel jpnContainer;
    public static Point pointJFrame = new Point(460, 290);
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;

    public JFrameMenu() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((int) dimension.getWidth() - SCREEN_WIDTH) / 2, ((int) dimension.getHeight() - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.00f));
        this.setLayout(null);
        jpnContainer = new jPanel();
        jpnContainer.setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        jpnContainer.setBorder(new LineBorder(Color.red, 2));
        jpnContainer.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.f));
        this.add(jpnContainer);
        this.addKeyListener(this);
        this.setVisible(true);
    }

    public static BufferedImage takeAScreenShot() {
        BufferedImage screenShot = null;
        try {
            Robot robot = new Robot();
            screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        } catch (AWTException ex) {
        }
        BufferedImage subImage = null;
        if (screenShot != null) {
            subImage = screenShot.getSubimage(pointJFrame.x, pointJFrame.y, SCREEN_WIDTH, SCREEN_HEIGHT);
        }
        return subImage;
    }

    public static BufferedImage takeImageFromComputer(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(JFrameMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return img;
    }
    
    public static void click(int x, int y) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public jPanel getJpnContainer() {
        return jpnContainer;
    }

    public void setJpnContainer(jPanel jpnContainer) {
        this.jpnContainer = jpnContainer;
    }
    
    
    public static void main(String[] args) {
        new JFrameMenu();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Start");
        new ThreadGoFishing(JFrameMenu.this).start();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

class jPanel extends JPanel{

    
    @Override
    protected void paintComponent(Graphics g) {
        if(JFrameMenu.a == 0 || JFrameMenu.b == 0 || JFrameMenu.c == 0 || JFrameMenu.d == 0){
            
        }else{
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);
            g2.drawLine(JFrameMenu.a, JFrameMenu.b, JFrameMenu.a + JFrameMenu.c, JFrameMenu.d + JFrameMenu.b);
        }
    }
    
}