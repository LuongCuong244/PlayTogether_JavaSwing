/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyBoardAndMouse;

import DataAndProperties.Properties;
import Thread.ThreadActivateMouse;
import Thread.ThreadManager;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import playtogether.JFrameCustomMouse;
import playtogether.JFrameMain;
import playtogether.JPanelMenu;

/**
 *
 * @author Administrator
 */
public class KeyBoard {

    private JFrameMain jFrameMain;
    public static boolean isDrawLineMouse = true;
    public ThreadManager threadManager;

    public KeyBoard(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
        threadManager = new ThreadManager(jFrameMain);
    }

    public void Pressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_R: {
                threadManager.start();
                break;
            }
            case KeyEvent.VK_M: {
                isDrawLineMouse = !isDrawLineMouse;
                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
                break;
            }
            case KeyEvent.VK_G: {
                Point pMouse = MouseInfo.getPointerInfo().getLocation();
                int x = pMouse.x - JFrameMain.pointJFrame.x;
                int y = pMouse.y - JFrameMain.pointJFrame.y - Properties.space - jFrameMain.getjPanelMenu().getHeight();
                if (x > 0 && y > 0 && x < jFrameMain.getjPanelTable().getWidth() && y < jFrameMain.getjPanelTable().getHeight()&&JPanelMenu.isOpenOperationMouse) {
                    if(JFrameCustomMouse.pMouseStartCurrent == null){
                        JFrameCustomMouse.pMouseStartCurrent = new Point(x,y);
                    }else{
                        JFrameCustomMouse.pMouseStartCurrent.setLocation(x, y);
                    } 
                    jFrameMain.getjPanelTable().setVisible(false);
                    jFrameMain.getjPanelTable().setVisible(true);
                    jFrameMain.getjPanelTable().getjPanelImage().repaint();
                }else{
                    JOptionPane.showMessageDialog(jFrameMain, "Vị trí trỏ chuột không nằm trong khung!");
                }
                break;
            }
            case KeyEvent.VK_H: {
                Point pMouse = MouseInfo.getPointerInfo().getLocation();
                int x = pMouse.x - JFrameMain.pointJFrame.x;
                int y = pMouse.y - JFrameMain.pointJFrame.y - Properties.space - jFrameMain.getjPanelMenu().getHeight();
                if (x > 0 && y > 0 && x < jFrameMain.getjPanelTable().getWidth() && y < jFrameMain.getjPanelTable().getHeight()&&JPanelMenu.isOpenOperationMouse) {
                    if(JFrameCustomMouse.pMouseEndCurrent == null){
                        JFrameCustomMouse.pMouseEndCurrent = new Point(x,y);
                    }else{
                        JFrameCustomMouse.pMouseEndCurrent.setLocation(x, y);
                    }      
                    jFrameMain.getjPanelTable().setVisible(false);
                    jFrameMain.getjPanelTable().setVisible(true);
                    jFrameMain.getjPanelTable().getjPanelImage().repaint();
                }else{
                    JOptionPane.showMessageDialog(jFrameMain, "Vị trí trỏ chuột không nằm trong khung!");
                }
                break;
            }
        }
    }

    public ThreadManager getThreadManager() {
        return threadManager;
    }

    public void setThreadManager(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }
}
