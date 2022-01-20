/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playtogether;

import DataAndProperties.Data;
import DataAndProperties.Properties;
import KeyBoardAndMouse.KeyBoard;
import KeyBoardAndMouse.Mouse;
import Location.PointButton;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class JFrameMain extends JFrame implements KeyListener, MouseListener {

    public static int SCREEN_WIDTH = 877;
    public static int SCREEN_HEIGHT = 615;
    public static int countFish = 0;
    public static long time = 0;
    
    public static Point pointJFrame = new Point(460, 290);
    private KeyBoard keyBoard;
    private Mouse mouse;
    private JPanelMenu jPanelMenu;
    private JPanelTable jPanelTable;

    public JFrameMain() {
        if (Data.readData()) {
            this.setBounds(pointJFrame.x, pointJFrame.y, SCREEN_WIDTH, SCREEN_HEIGHT);
        } else {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            this.setBounds(((int) dimension.getWidth() - SCREEN_WIDTH) / 2, ((int) dimension.getHeight() - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
            pointJFrame = new Point(((int) dimension.getWidth() - SCREEN_WIDTH) / 2, ((int) dimension.getHeight() - SCREEN_HEIGHT) / 2);
        }
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.00f));
        this.setLayout(new BorderLayout(0, Properties.space));

        keyBoard = new KeyBoard(this);
        mouse = new Mouse(this);
        jPanelMenu = new JPanelMenu(this);
        jPanelTable = new JPanelTable(this);
        this.add(jPanelMenu, BorderLayout.NORTH);
        this.add(jPanelTable, BorderLayout.CENTER);

        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Data.writeData();
            }
        });
    }

    public void setBoundsToolFrame() {
        this.setBounds(pointJFrame.x, pointJFrame.y, SCREEN_WIDTH, SCREEN_HEIGHT);
        PointButton.pointBalo.setLocation(Properties.pointButtonBalo_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonBalo_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointCoin.setLocation(Properties.pointButtonCoin_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonCoin_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointDragFish.setLocation(Properties.pointButtonDragFish_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonDragFish_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointExit.setLocation(Properties.pointButtonExit_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonExit_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointFix.setLocation(Properties.pointButtonFix_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonFix_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointGarbage.setLocation(Properties.pointButtonGarbage_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonGarbage_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointGoFishing.setLocation(Properties.pointButtonGoFishing_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonGoFishing_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointKeepFish.setLocation(Properties.pointButtonKeepFish_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonKeepFish_Y * JFrameMain.SCREEN_HEIGHT);
        PointButton.pointTool.setLocation(Properties.pointButtonTool_X * JFrameMain.SCREEN_WIDTH, Properties.pointButtonTool_Y * JFrameMain.SCREEN_HEIGHT);
    }

    public void click(Point p) {
        Robot bot = null;
        try {
            bot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        bot.mouseMove(p.x + JFrameMain.pointJFrame.x, p.y + JFrameMain.pointJFrame.y + Properties.space + jPanelMenu.getHeight());
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public JPanelMenu getjPanelMenu() {
        return jPanelMenu;
    }

    public void setjPanelMenu(JPanelMenu jPanelMenu) {
        this.jPanelMenu = jPanelMenu;
    }

    public JPanelTable getjPanelTable() {
        return jPanelTable;
    }

    public void setjPanelTable(JPanelTable jPanelTable) {
        this.jPanelTable = jPanelTable;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyBoard.Pressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point pMouse = MouseInfo.getPointerInfo().getLocation();
        pMouse.setLocation(pMouse.x - JFrameMain.pointJFrame.x, pMouse.y - JFrameMain.pointJFrame.y - Properties.space - jPanelMenu.getHeight());
        if ((pMouse.x <= Math.max(JPanelTable.pointDrawRectStart.x, JPanelTable.pointDrawRectEnd.x))
                && (pMouse.x >= Math.min(JPanelTable.pointDrawRectStart.x, JPanelTable.pointDrawRectEnd.x))
                && (pMouse.y <= Math.max(JPanelTable.pointDrawRectStart.y, JPanelTable.pointDrawRectEnd.y))
                && (pMouse.y >= Math.min(JPanelTable.pointDrawRectStart.y, JPanelTable.pointDrawRectEnd.y))) {
            mouse.Pressed("Move_Rect_Exclamation_Mark");
        } else if (JPanelImage.pointCurrentButton != null) {
            if ((Math.pow(pMouse.x - JPanelImage.pointCurrentButton.x, 2) + Math.pow(pMouse.y - JPanelImage.pointCurrentButton.y, 2)) <= Math.pow(Mouse.radiusSize, 2)) {
                mouse.Pressed("Move_Touch_Button");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point pMouse = MouseInfo.getPointerInfo().getLocation();
        pMouse.setLocation(pMouse.x - JFrameMain.pointJFrame.x, pMouse.y - JFrameMain.pointJFrame.y - Properties.space - jPanelMenu.getHeight()); // JPanelTabel la goc toa do
        if ((pMouse.x <= Math.max(JPanelTable.pointDrawRectStart.x, JPanelTable.pointDrawRectEnd.x))
                && (pMouse.x >= Math.min(JPanelTable.pointDrawRectStart.x, JPanelTable.pointDrawRectEnd.x))
                && (pMouse.y <= Math.max(JPanelTable.pointDrawRectStart.y, JPanelTable.pointDrawRectEnd.y))
                && (pMouse.y >= Math.min(JPanelTable.pointDrawRectStart.y, JPanelTable.pointDrawRectEnd.y))) {
            mouse.Release("Move_Rect_Exclamation_Mark");
        } else if (JPanelImage.pointCurrentButton != null) {
            if ((Math.pow(pMouse.x - JPanelImage.pointCurrentButton.x, 2) + Math.pow(pMouse.y - JPanelImage.pointCurrentButton.y, 2)) <= Math.pow(Mouse.radiusSize, 2)) {
                mouse.Release("Move_Touch_Button");
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    public static void main(String[] args) {
        new JFrameMain();
        System.out.println(JFrameMain.SCREEN_WIDTH);
        System.out.println(JFrameMain.SCREEN_HEIGHT);
    }
}
