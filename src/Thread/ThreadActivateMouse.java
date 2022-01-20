/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import DataAndProperties.Properties;
import KeyBoardAndMouse.ItemAutoFishing;
import Location.PointButton;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import playtogether.JFrameCustomMouse;
import static playtogether.JFrameCustomMouse.listAutoFishing;
import static playtogether.JFrameCustomMouse.pMouseGoUpStart;
import playtogether.JFrameMain;

/**
 *
 * @author Administrator
 */
public class ThreadActivateMouse {
    
//    private JFrameMain jFrameMain;
//
//    public ThreadActivateMouse(JFrameMain jFrameMain) {
//        this.jFrameMain = jFrameMain;
//    }
//
//    public void runFrame() {
//
//        for (int k = 0; k < listAutoFishing.size(); k++) {
//            ItemAutoFishing item = listAutoFishing.get(k);
//            if (ItemAutoFishing.GO_UP == item.getDirection()) {
//
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pMouseGoUpStart, new Point(pMouseGoUpStart.x,pMouseGoUpStart.y - 80), item.getValue());
//
//            } else if (ItemAutoFishing.GO_DOWN == item.getDirection()) {
//
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pMouseGoUpStart, new Point(pMouseGoUpStart.x,pMouseGoUpStart.y + 80), item.getValue());
//
//            } else if (ItemAutoFishing.TURN_LEFT == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x - item.getValue(), pRotationsFocus.y);
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            } else if (ItemAutoFishing.TURN_RIGHT == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x + item.getValue(), pRotationsFocus.y);
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            } else if (ItemAutoFishing.TURN_UP == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x, pRotationsFocus.y - item.getValue());
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            } else if (ItemAutoFishing.TURN_DOWN == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x, pRotationsFocus.y + item.getValue());
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            }
//        }
//        try {
//            Thread.sleep((long) ((Math.random() * ((4000 - 2000) + 1)) + 2000));
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ThreadActivateMouse.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        runFrameReverse();
//        jFrameMain.getKeyBoard().getThreadManager().interrupt();
//        jFrameMain.getKeyBoard().getThreadManager().start();
//    }
//
//    public void runFrameReverse() {
//        int k;
//        int size = listAutoFishing.size();
//        for (k = size - 1; k >= 0; k--) {
//            ItemAutoFishing item = listAutoFishing.get(k);
//            if (ItemAutoFishing.GO_UP == item.getDirection()) {
//
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pMouseGoUpStart, new Point(pMouseGoUpStart.x,pMouseGoUpStart.y + 80), item.getValue());
//
//            } else if (ItemAutoFishing.GO_DOWN == item.getDirection()) {
//
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pMouseGoUpStart, new Point(pMouseGoUpStart.x,pMouseGoUpStart.y - 80), item.getValue());
//
//            } else if (ItemAutoFishing.TURN_LEFT == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x + item.getValue(), pRotationsFocus.y);
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            } else if (ItemAutoFishing.TURN_RIGHT == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x - item.getValue(), pRotationsFocus.y);
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            } else if (ItemAutoFishing.TURN_UP == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x, pRotationsFocus.y + item.getValue());
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            } else if (ItemAutoFishing.TURN_DOWN == item.getDirection()) {
//
//                Point pRotationsFocus = new Point(jFrameMain.getjPanelTable().getWidth() / 2, jFrameMain.getjPanelTable().getHeight() / 2);
//                Point pEnd = new Point(pRotationsFocus.x, pRotationsFocus.y - item.getValue());
//                jFrameMain.getjPanelMenu().getjFrameCustomMouse().dragAndDrop(pRotationsFocus, pEnd, 0);
//
//            }
//        }
//    }

//    public void chat(String chat) {
//        Robot robot = null;
//        try {
//            robot = new Robot();
//        } catch (AWTException ex) {
//            Logger.getLogger(ThreadActivateMouse.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        StringSelection stringSelection = new StringSelection(chat);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, stringSelection);
//
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(ThreadActivateMouse.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//    }
}
