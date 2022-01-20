/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread.Move;

import DataAndProperties.Properties;
import KeyBoardAndMouse.Mouse;
import static KeyBoardAndMouse.Mouse.isMoveTouchButton;
import Location.PointButton;
import java.awt.MouseInfo;
import java.awt.Point;
import playtogether.JFrameMain;
import playtogether.JPanelImage;
import playtogether.JPanelTable;

/**
 *
 * @author Administrator
 */
public class MoveTouchButton extends Thread {

    private JFrameMain jFrameMain;

    public MoveTouchButton(JFrameMain jFrameMain) {
        this.jFrameMain = jFrameMain;
    }

    @Override
    public void run() {
        Point pMouse = MouseInfo.getPointerInfo().getLocation();
        int dX = pMouse.getLocation().x - JPanelImage.pointCurrentButton.x;
        int dY = pMouse.getLocation().y - JPanelImage.pointCurrentButton.y;

        while (Mouse.isMoveTouchButton) {
            pMouse.setLocation(MouseInfo.getPointerInfo().getLocation());

            if ((pMouse.x < (JFrameMain.SCREEN_WIDTH + JFrameMain.pointJFrame.x - 10)) && (pMouse.x > JFrameMain.pointJFrame.x + 10) && (pMouse.y < (JFrameMain.SCREEN_HEIGHT + JFrameMain.pointJFrame.y - 10)) && (pMouse.y > (JFrameMain.pointJFrame.y + jFrameMain.getjPanelMenu().getHeight() + Properties.space + 10))) {
                JPanelImage.pointCurrentButton.setLocation(pMouse.x - dX, pMouse.y - dY);
                if (JPanelImage.pointCurrentButton == PointButton.pointBalo) {

                    Properties.pointButtonBalo_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonBalo_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointCoin) {
                    Properties.pointButtonCoin_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonCoin_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointDragFish) {

                    Properties.pointButtonDragFish_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonDragFish_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointExit) {

                    Properties.pointButtonExit_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonExit_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointFix) {

                    Properties.pointButtonFix_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonFix_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointGarbage) {

                    Properties.pointButtonGarbage_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonGarbage_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointGoFishing) {

                    Properties.pointButtonGoFishing_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonGoFishing_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointKeepFish) {

                    Properties.pointButtonKeepFish_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonKeepFish_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointTool) {

                    Properties.pointButtonTool_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonTool_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                } else if (JPanelImage.pointCurrentButton == PointButton.pointChat) {

                    Properties.pointButtonChat_X = (float) JPanelImage.pointCurrentButton.x / JFrameMain.SCREEN_WIDTH;
                    Properties.pointButtonChat_Y = (float) JPanelImage.pointCurrentButton.y / JFrameMain.SCREEN_HEIGHT;

                }

                jFrameMain.getjPanelTable().setVisible(false);
                jFrameMain.getjPanelTable().setVisible(true);
                jFrameMain.getjPanelTable().getjPanelImage().repaint();
            }
        }
    }

}
