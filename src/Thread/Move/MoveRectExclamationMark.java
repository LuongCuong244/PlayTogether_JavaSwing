/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread.Move;

import DataAndProperties.Properties;
import KeyBoardAndMouse.Mouse;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import playtogether.JFrameMain;
import playtogether.JPanelTable;

/**
 *
 * @author Administrator
 */
public class MoveRectExclamationMark extends Thread {

    private JFrameMain jFrameMain;

    public MoveRectExclamationMark(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
    }

    @Override
    public void run() {
        Point pMouse = MouseInfo.getPointerInfo().getLocation();
        int dXStart = pMouse.getLocation().x - JPanelTable.pointDrawRectStart.x;
        int dYStart = pMouse.getLocation().y - JPanelTable.pointDrawRectStart.y;
        int dXEnd = pMouse.getLocation().x - JPanelTable.pointDrawRectEnd.x;
        int dYEnd = pMouse.getLocation().y - JPanelTable.pointDrawRectEnd.y;
        while (Mouse.isMoveRect) {
            pMouse.setLocation(MouseInfo.getPointerInfo().getLocation());

            if ((pMouse.x < (JFrameMain.SCREEN_WIDTH + JFrameMain.pointJFrame.x - 10)) && (pMouse.x > JFrameMain.pointJFrame.x) && (pMouse.y < (JFrameMain.SCREEN_HEIGHT + JFrameMain.pointJFrame.y - 10)) && (pMouse.y > (JFrameMain.pointJFrame.y + jFrameMain.getjPanelMenu().getHeight() + Properties.space + 10))) {
                JPanelTable.pointDrawRectStart.setLocation(pMouse.x - dXStart, pMouse.y - dYStart);
                JPanelTable.pointDrawRectEnd.setLocation(pMouse.x - dXEnd, pMouse.y - dYEnd);

                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();

                Properties.pointMoveRectStartX = JPanelTable.pointDrawRectStart.x;
                Properties.pointMoveRectStartY = JPanelTable.pointDrawRectStart.y;
            }
        }
    }
}
